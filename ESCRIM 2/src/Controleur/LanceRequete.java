package Controleur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import metier.*;
import metier.Article;
import partieMission.*;
import partieMission.configs.Configuration;
import utilisateur.Donnee;
import utilisateur.Utilisateur;

public class LanceRequete<E extends Donnee> {

	private String url = "jdbc:mysql://localhost/test";
	private String user = "root";
	private String pwd = "";

	private String classParam;
	private String classParamShort;

	private String table;
	private String [] nomColonnes;
	private int nbColonnes;

	Connection connexion;

	/**
	 * Mettre en parametre E.class. Par exemple pour faire une BDD por les
	 * articles il faut faire Bdd<Article> = new Bdd<Article>(Article.class);
	 * 
	 * @param cls
	 * @throws Throwable 
	 */
	public LanceRequete(String cls) throws Throwable {

		Map<String, String> assoc = new HashMap<>();

		assoc.put("Utilisateur", "utilisateur");
		assoc.put("Article", "article");
		assoc.put("Colis", "colis");
		assoc.put("Avion", "avion");
		assoc.put("GrpColis", "grpcolis");
		assoc.put("GrpAvion", "grpavion");
		assoc.put("Dimension", "dimension");
		// ...

		classParam = cls;
		cls = cls.split("\\.")[cls.split("\\.").length - 1];

		if (assoc.containsKey(cls)) {
			table = assoc.get(cls);
		} else {
			table = null;
			System.out.println("erreur dans Bdd");
		}

		classParamShort = cls;
		
		generateColumnNames();
	}

	private void generateColumnNames() throws Throwable {
		connexion();
			Statement stmt = connexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `" + table + "`");
			ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();
			nomColonnes = new String[rsmd.getColumnCount()];
			
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				nomColonnes[i] = rsmd.getColumnName(i+1);
			}
			
			nbColonnes = nomColonnes.length;
		deconnexion();
	}

	private void connexion() throws SQLException {
		connexion = DriverManager.getConnection(url, user, pwd);
	}

	private void deconnexion() throws SQLException {
		connexion.close();
	}

	public ArrayList<E> selectWhere(String requete) throws Throwable {
		Constructor<?> c = Class.forName(classParam).getConstructors()[0];
		int nbParam = c.getParameterCount();
		Type[] typeParam = c.getGenericParameterTypes();

		ArrayList<E> res = new ArrayList<E>();
		Object[] param;

		// --------------Debut de la connexion
		connexion();

		requete = "SELECT * FROM `" + table + "` WHERE " + requete;
		Statement stmt = connexion.createStatement();
		ResultSet rs = stmt.executeQuery(requete);
		rs.next();

		if (rs.getMetaData().getColumnCount() != nbParam + 1) {
			System.out.println("Requete incorrecte");
			return null;
		}

		do {
			param = new Object[nbParam];

			for (int i = 0; i < nbParam; i++) {
				param[i] = getColumnContent(rs, i + 2, typeParam[i]);// +1 for
																		// the
																		// index,
																		// +1
																		// for
																		// the
																		// id_*
			}

			@SuppressWarnings("unchecked")
			Constructor<E> cc = (Constructor<E>) c;
			E monObjet = cc.newInstance(param);
			res.add(monObjet);
		} while (rs.next());

		deconnexion();
		// ---------------Fin de connexion

		return res;
	}

	public E selectFromId(int id) throws Throwable {
		

		return selectWhere(nomColonnes[0] + " = " + id).get(0);
	}

	public void add(E element) throws Throwable {
		// préparation de la requete

		String req = "INSERT INTO `" + table + "` VALUES ( NULL, ";

		
		for (Object o : element.getParameters()) {
			try {
				Boolean b = (Boolean) o;
				if (b) {
					o = "1";
				} else {
					o = "0";
				}
			} catch (Exception e) {
			}

			req = req + "\'" + o + "\'" + ", ";
		}
		req = req.substring(0, req.length() - 2) + ")";

		System.out.println(req);

		// envoi de la requete
		connexion();
		Statement stmt = connexion.createStatement();
		stmt.executeUpdate(req);
		deconnexion();
	}

	public void remove(E element) throws Throwable {

		connexion();

		// on prépare la requete
		Object[] param = element.getParameters();
		String req = "DELETE FROM `" + table + "` WHERE ";
		for (int i = 0; i < param.length; i++) {
			req = req +"`"+ nomColonnes[i+1] + "` = " + param[i] + ", ";//on esquive l'ID !
		}
		req = req.substring(0, req.length() - 2);

		// On envoi
		Statement stmt = connexion.createStatement();
		ResultSet rs = stmt.executeQuery(req);

		deconnexion();
	}

	public void update(E ancien, E nouveau) throws Throwable {

	}

	private Object getColumnContent(ResultSet rs, int colonne, Type type) throws Throwable {

		String[] noms = type.getTypeName().split("\\.");
		String nom = noms[noms.length - 1];

		switch (nom) {
		case "String":
			return rs.getString(colonne);
		case "int":
			return rs.getInt(colonne);
		case "float":
			return rs.getFloat(colonne);
		case "Boolean":
			return (rs.getInt(colonne) != 0);
		default:
			/**
			 * On regarde si ce n'est pas une classe, dans ce cas on regarde si
			 * le nom de la colonne de la table commence par "id". Si c'est le
			 * cas on trouve cette objet avec une nouvelle Bdd
			 */
			connexion();
			ResultSetMetaData data = (ResultSetMetaData) connexion.getMetaData();
			if (data.getColumnName(colonne).substring(0, 2) == "id") {

				LanceRequete<?> sousBase;
				
				 switch (nom) {
				
				 case "Utilisateur":
					 sousBase = new LanceRequete<Utilisateur>("Utilisateur");
					 break;
				 case "Article":
					 sousBase = new LanceRequete<Article>("Article");
					 break;
				 case "Colis":
					 sousBase = new LanceRequete<Colis>("Colis");
					 break;
				 case "GrpColis":
					 sousBase = new LanceRequete<GrpColis>("GrpColis");
					 break;
				 case "GrpAvion":
					 sousBase = new LanceRequete<GrpAvions>("GrpAvions");
					 break;
				 case "Configuration":
					 sousBase = new
					 LanceRequete<Configuration>("Configuration");
					 break;
				 case "Mission":
					 sousBase = new LanceRequete<Mission>("Mission");
					 break;
				
				 default:
					 System.out.print("La classe " + nom + "n'est pas implémentée dans LanceRequete, appelle François");
					 sousBase = null;
					 break;
				 }

				 return sousBase.selectFromId(rs.getInt(colonne));

				
			
			}
			deconnexion();

			System.out.println("JE NE CONNAIS PAS CE TYPE ?! \n \t " + nom);
			return null;
		}

	}


}
