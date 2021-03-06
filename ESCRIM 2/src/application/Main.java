package application;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Controleur.LanceRequete;
import metier.Article;
import metier.Stock;
import metier.utilisateur.Utilisateur;
import view.AfficheurGrp;

public class Main {

	public static void main(String[] args) throws Throwable {
		exLanceRequete();
	}

	/*
	 * Exemple d'utilisation de l'afficheur de groupe
	 */
	public static void exempleAfficheurGrp() {
		JFrame fenetre = new JFrame("Salut !");
		fenetre.setLayout(new GridLayout(2, 0));

		JTabbedPane tabbedPane = new JTabbedPane();

		// ---------------------Onglet1

		JPanel onglet1 = new JPanel();
		AfficheurGrp<Utilisateur> afficheur = new AfficheurGrp<Utilisateur>("Mon nouvel afficheur, il est beau ?");

		// creer mon groupe de colis

		Utilisateur c1 = new Utilisateur("JAck", "Sozzlof", "zerty", true, false, "None");
		Utilisateur c2 = new Utilisateur("aack", "Sodf", "zerty", false, false, "None");

		ArrayList<Utilisateur> mesUser = new ArrayList<Utilisateur>();
		mesUser.add(c1);
		mesUser.add(c2);

		afficheur.MajGrpColis(mesUser);
		onglet1.add(afficheur);

		// Zone de lecture
		JLabel zone = new JLabel("fghj");
		onglet1.add(zone);

		// Associe l'afficheur avec la zone
		afficheur.ajouterZoneDetail(zone);

		tabbedPane.addTab("onglet1", onglet1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		// ---------------------Onglet2

		JPanel onglet2 = new JPanel();
		JLabel test = new JLabel("Test de Biatch");
		onglet2.add(test);

		tabbedPane.addTab("onglet2", onglet2);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		fenetre.add(tabbedPane);

		fenetre.pack();
		fenetre.setVisible(true);
	}

	/*
	 * Exeple de lance requete 
	 */
	public static void exLanceRequete() throws Throwable {

		/*
		 * Utilisateur
		 */
		LanceRequete<Utilisateur> bddUser = new LanceRequete<Utilisateur>(Utilisateur.class.getName());
		Utilisateur u1 = bddUser.selectFromId(1);
		Utilisateur u2 = bddUser.selectFromId(2);
		Utilisateur u3 = bddUser.selectFromId(3);

		Utilisateur u4 = new Utilisateur("Porte", "Table", "poignée", true, false, "Barre de fer");

		ArrayList<Utilisateur> al = bddUser.selectWhere("droit_lecture = 1");

		/*
		 * ARTICLE
		 */

		LanceRequete<Article> bddArticle = new LanceRequete<Article>(Article.class.getName());
		Article a1 = bddArticle.selectFromId(1);
		Article a2 = new Article("Pastis", "Alcool", 1);
		bddArticle.add(a2);
		bddArticle.remove(a2);

		/*
		 * Stock
		 */

		LanceRequete<Stock> bddStock = new LanceRequete<Stock>(Stock.class.getName());
		Stock s1 = bddStock.selectWhere("1").get(0);
		
		int a = 1;
	}

}
