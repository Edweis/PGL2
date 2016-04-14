package metier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

import utilisateur.*;
import view.Groupement;

public class Article implements Groupement{
	private String nom;
	private Stack<Caracteristique> stocks;
	private String type;
	public float poids;
	

	public Article(String nom, String type, float poids) {
		this.nom = nom;
		this.type = type;
		this.poids = poids;
	}
	public int getStockTotal() {
		int total =0;
		for(Caracteristique stock : stocks){
			total += stock.getQuantite();
		}
		return total;
	}
	public void addStock(int quantite,String date) {
		this.stocks.add(new Caracteristique(quantite, date));
	}
	public Caracteristique getStock(int index) {
		return stocks.get(index);
	}
	public Stack<Caracteristique> getStock(){
		return stocks;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void creerArticle(String nom, String type, Double poids) throws SQLException{
		Bdd_utilisateur.connecter("root","");
		Bdd_utilisateur.ecriture("INSERT INTO 'article' VALUES ('','nom','type','poids')");
		Bdd_utilisateur.deconnecter();
	}
	
	public void supprimerArticle(String nom) throws SQLException{
		Bdd_utilisateur.connecter("root","");
		Bdd_utilisateur.ecriture("DELETE 'nom' FROM 'article'");
		Bdd_utilisateur.deconnecter();
	}
	public void addStock(String nom2,int quantite2) throws SQLException{
		Bdd_utilisateur.connecter("root","");
		ResultSet id_art = Bdd_utilisateur.lecture("SELECT 'id_article' FROM 'stock' WHERE 'nom' == nom2");
		Bdd_utilisateur.ecriture("UPDATE 'stock' SET  'quantite'= 'quantite'+quantite2 WHERE id_article =id_art");
		Bdd_utilisateur.deconnecter();
	}
	
	public void supprimerStock(String nom2,int quantite2) throws SQLException{
		Bdd_utilisateur.connecter("root","");
		ResultSet id_art = Bdd_utilisateur.lecture("SELECT 'id_article' FROM 'stock' WHERE 'nom' == nom2");
		Bdd_utilisateur.ecriture("UPDATE 'stock' SET  'quantite'= 'quantite'-quantite2 WHERE id_article =id_art");
		Bdd_utilisateur.deconnecter();
	}
	
	public void modifierArticle(Utilisateur utilisateur, String nom,String type,float poids) throws SQLException{
		String anciennom = this.nom;
		this.nom = nom;
		this.type = type;
		this.poids = poids;
		String requete = "UPDATE article SET nom = 'nom' type='type' poids ='poids' WHERE nom = 'anciennom'";
		Bdd_utilisateur.connecter("root","");
		Bdd_utilisateur.ecriture(requete);
		Bdd_utilisateur.deconnecter();
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	
	@Override
	public String details() {
		
		return null;
	}
	
	public String toString(){
		return nom ;
	}
	
}
