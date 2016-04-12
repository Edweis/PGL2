package application;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import metier.Colis;
import metier.Dimension;
import partieMission.GrpColis;
import view.AfficheurGrp;

public class Main {

	public static void main(String[] args) {
		exempleAfficheurGrp();

	}

	public static void exempleAfficheurGrp() {
		JTabbedPane tabbedPane = new JTabbedPane();

		JFrame fenetre = new JFrame("Salut !");
		fenetre.setLayout(new GridLayout(2, 0));
		
		JPanel onglet1 = new JPanel();
		AfficheurGrp afficheur = new AfficheurGrp("Mon nouvel afficheur, il est beau ?");

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

		afficheur.MajGrpColis(grp);
		onglet1.add(afficheur);

		afficheur.setAllParamFormat(new int[] { 0, 10, 0, 0, 40 });

		// Zone de lecture
		JLabel zone = new JLabel("fghj");
		onglet1.add(zone);

		// Associe l'afficheur avec la zone
		afficheur.ajouterZoneDetail(zone);
		tabbedPane.addTab("onglet1", onglet1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		JPanel onglet2 = new JPanel();
		JLabel test = new JLabel("Test de Biatch");
		onglet2.add(test);
		
		tabbedPane.addTab("onglet2", onglet2);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		fenetre.add(tabbedPane);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
