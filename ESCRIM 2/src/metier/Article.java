package metier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

import utilisateur.*;

public class Article {
	private String nom;
	private Stack<Caracteristique> stocks;
	private String type;

	public Article(String nom, String type) {
		this.nom = nom;
		this.type = type;
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
	
}
