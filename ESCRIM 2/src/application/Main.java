package application;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import metier.Article;
import metier.Colis;
import metier.Dimension;
import partieMission.GrpColis;
import utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_acceuil;

public class Main {


	public static void main(String... args) throws Throwable {
		//LanceRequete<Utilisateur> bddUser = new LanceRequete<Utilisateur>(Utilisateur.class);
		//bddUser.add(new Utilisateur("a","b","c",true,false,"d"));
		exempleAfficheurGrp();
	}

	public static void exempleAfficheurGrp() {
		JFrame fenetre = new JFrame("Salut !");
		fenetre.setLayout(new GridLayout(2, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//---------------------Onglet1
		
		JPanel onglet1 = new JPanel();
		AfficheurGrp<Colis> afficheur = new AfficheurGrp<Colis>("Mon nouvel afficheur, il est beau ?");

		// creer mon groupe de colis

		GrpColis grp = new GrpColis();

		Colis c1 = new Colis(10, new Dimension(11, 22, 33));
		c1.setInfos("George", "Paris", "bleue");
		Colis c2 = new Colis(20, new Dimension(11, 22, 33));
		c2.setInfos("René", "NYC", "bleue");
		Colis c3 = new Colis(30, new Dimension(11, 22, 33));
		c3.setInfos("Bob", "OKil", "bleue");

		grp.add(c1);
		grp.add(c2);
		grp.add(c3);

		afficheur.MajGrpColis(grp.getColis());
		onglet1.add(afficheur);

		afficheur.setAllParamFormat(new int[] { 0, 60, 0, 0, 60 });

		// Zone de lecture
		JLabel zone = new JLabel("fghj");
		onglet1.add(zone);

		// Associe l'afficheur avec la zone
		afficheur.ajouterZoneDetail(zone);
		
		
		
		
		
		tabbedPane.addTab("onglet1", onglet1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		//---------------------Onglet2

		JPanel onglet2 = new JPanel();
		JLabel test = new JLabel("Test de Biatch");
		onglet2.add(test);
		
		tabbedPane.addTab("onglet2", onglet2);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		fenetre.add(tabbedPane);
		fenetre.pack();
		fenetre.setVisible(true);
	}

	public static void exempleAfficheurGrp2(){
		Article a1 = new Article("salut", "jaques");
		Article a2 = new Article("df", "jaquqsdqses");
		Article a3 = new Article("sadfsdflut", "jaqucdcdes");
		
		ArrayList<Article> mesArticles = new ArrayList<Article>();
			mesArticles.add(a1);
			mesArticles.add(a2);
			mesArticles.add(a3);
			
		AfficheurGrp<Article> afficheur = new AfficheurGrp<Article>();
			afficheur.MajGrpColis(mesArticles);
	}*/
}
