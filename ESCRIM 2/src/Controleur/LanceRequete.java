package Controleur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import metier.*;
import partieMission.*;
import partieMission.configs.Configuration;
import utilisateur.Donnee;
import utilisateur.Utilisateur;

public class LanceRequete<E extends Donnee> {

	private String url = "jdbc:mysql://localhost/escrim";
	private String user = "root";
	private String pwd = "";

	private Class classe;

	private String table;

	Connection connexion;

	/**
	 * Mettre en parametre E.class. Par exemple pour faire une BDD por les
	 * articles il faut faire Bdd<Article> = new Bdd<Article>(Article.class);
	 * 
	 * @param cls
	 */
	public LanceRequete(Class<E> cls) {

		Map<String, String> assoc = new HashMap<>();

		assoc.put("Utilisateur", "utilisateur");
		assoc.put("Article", "article");
		assoc.put("Colis", "colis");
		assoc.put("Avion", "avion");
		assoc.put("GrpColis", "grpcolis");
		assoc.put("GrpAvion", "grpavion");
		assoc.put("Dimension", "dimension");
		// ...

		if (assoc.containsKey(cls.getName())) {
			table = assoc.get(cls.getName());
		} else {
			table = null;
			System.out.println("erreur dans Bdd");
		}

		classe = cls;
	}

	private void connexion() throws SQLException {
		connexion = DriverManager.getConnection(url, user, pwd);
	}

	private void deconnexion() throws SQLException {
		connexion.close();
	}

	public ArrayList<E> selectWhere(String requete) throws Throwable {
		Constructor<E> c = classe.getConstructors()[0];
		int nbParam = c.getParameterCount();
		Type[] typeParam = c.getGenericParameterTypes();

		ArrayList<E> res = new ArrayList<E>();
		Object[] param;

		// --------------Debut de la connexion
		connexion();

		requete = "SELECT * FROM " + table + "WHERE " + requete;
		Statement stmt = connexion.createStatement();
		ResultSet rs = stmt.executeQuery(requete);

		if (rs.getMetaData().getColumnCount() != nbParam) {
			System.out.println("Requete incorrecte");
			return null;
		}

		while (rs.next()) {
			param = new Object[nbParam];

			for (int i = 0; i < nbParam; i++) {
				param[i] = getColumnContent(rs, i, typeParam[i]);
			}

			E monObjet = c.newInstance(param);
			res.add(monObjet);
		}

		deconnexion();
		// ---------------Fin de connexion

		return res;
	}

	public E selectFromId(int id) throws Throwable {
		return selectWhere("id = " + id).get(0);
	}

	public void add(E element) throws Throwable {
		// préparation de la requete

		String req = "INSERT INTO " + table + " VALUES(";

		for (Object o : element.getParameters()) {
			req = req + o + ",";
		}
		req = req.substring(0, req.length() - 1) + ")";

		// envoi de la requete
		connexion();
		Statement stmt = connexion.createStatement();
		ResultSet rs = stmt.executeQuery(req);
		deconnexion();
	}

	public void remove(E element) throws Throwable {

		connexion();

		// On chope le nom des colonnes
		ResultSetMetaData data = (ResultSetMetaData) connexion.getMetaData();

		int nbCol = data.getColumnCount();
		String[] nomCol = new String[nbCol];
		for (int i = 0; i < nbCol; i++) {
			nomCol[i] = data.getColumnName(i);
		}

		// on prépare la requete
		Object[] param = element.getParameters();
		String req = "DELETE FROM " + table + " WHERE ";
		for (int i = 0; i < nbCol; i++) {
			req = req + nomCol[i] + " = " + param[i] + ", ";
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

		String[] noms = type.getTypeName().split(".");
		String nom = noms[noms.length - 1];

		switch (nom) {
		case "String":
			return rs.getString(colonne);
		case "int":
			return rs.getInt(colonne);
		case "long":
			return rs.getLong(colonne);
		case "boolean":
			return rs.getBoolean(colonne);
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
				switch(nom){
				
				case "Utilisateur":
					sousBase = new LanceRequete<Utilisateur>(Utilisateur.class);
					break;
				case "Article":
					sousBase = new LanceRequete<Article>(Article.class);
					break;
				case "Colis":
					sousBase = new LanceRequete<Colis>(Colis.class);
					break;
				case "GrpColis":
					sousBase = new LanceRequete<GrpColis>(GrpColis.class);
					break;
				case "GrpAvion":
					sousBase = new LanceRequete<GrpAvions>(GrpAvions.class);
					break;
				case "Configuration":
					sousBase = new LanceRequete<Configuration>(Configuration.class);
					break;
				case "Mission":
					sousBase = new LanceRequete<Mission>(Mission.class);
					break;
				
				default:
					System.out.print("La classe " + nom + "n'est pas implémentée dans LanceRequete, appelle François"));
					break;
				}
				
				
				return sousBase.selectFromId(rs.getInt(colonne));
			
			}
			deconnexion();

			System.out.println("JE NE CONNAIS PAS CE TYPE ?! \n \t " + nom);
			return null;
		}

	}

	private <T extends Donnee> LanceRequete<T> classFacotory(Class<T> type) {
		return new LanceRequete<T>(type);
	}

}
