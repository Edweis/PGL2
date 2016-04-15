package metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

import utilisateur.*;
import view.Groupement;

public class Article implements Groupement, Donnee {
	private String nom;
	private String type;
	private ArrayList<Caracteristique> stock;

	private final Object[] param;

	public Article(ArrayList<Caracteristique> stock, String nom, String type) {
		this.nom = nom;
		this.type = type;

		param = new Object[] { stock, nom, type };
	}

	public int getStockTotal() {
		int total = 0;
		for (Caracteristique stock : stock) {
			total += stock.getQuantite();
		}
		return total;
	}

	public ArrayList<Caracteristique> getStock() {
		return stock;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * utiliser Bdd
	 */

	// public void addStock(int quantite,String date) {
	// this.stock.add(new Caracteristique(quantite, date));
	// }
	// public void creerArticle(String nom, String type, Double poids) throws
	// SQLException{
	// Bdd_utilisateur.connecter("root","");
	// Bdd_utilisateur.ecriture("INSERT INTO 'article' VALUES
	// ('','nom','type','poids')");
	// Bdd_utilisateur.deconnecter();
	// }
	//
	// public void supprimerArticle(String nom) throws SQLException{
	// Bdd_utilisateur.connecter("root","");
	// Bdd_utilisateur.ecriture("DELETE 'nom' FROM 'article'");
	// Bdd_utilisateur.deconnecter();
	// }
	// public void addStock(String nom2,int quantite2) throws SQLException{
	// Bdd_utilisateur.connecter("root","");
	// ResultSet id_art = Bdd_utilisateur.lecture("SELECT 'id_article' FROM
	// 'stock' WHERE 'nom' == nom2");
	// Bdd_utilisateur.ecriture("UPDATE 'stock' SET 'quantite'=
	// 'quantite'+quantite2 WHERE id_article =id_art");
	// Bdd_utilisateur.deconnecter();
	// }
	//
	// public void supprimerStock(String nom2,int quantite2) throws
	// SQLException{
	// Bdd_utilisateur.connecter("root","");
	// ResultSet id_art = Bdd_utilisateur.lecture("SELECT 'id_article' FROM
	// 'stock' WHERE 'nom' == nom2");
	// Bdd_utilisateur.ecriture("UPDATE 'stock' SET 'quantite'=
	// 'quantite'-quantite2 WHERE id_article =id_art");
	// Bdd_utilisateur.deconnecter();
	// }

	public String toString() {
		return nom;
	}

	@Override
	public String plusDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

}
