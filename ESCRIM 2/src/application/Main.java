package application;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import utilisateur.Utilisateur;
import view.AfficheurGrp;
<<<<<<< HEAD
=======
/*import view.AfficheurGrp;*/
>>>>>>> branch 'master' of https://github.com/Edweis/PGL2.git
import view.I_acceuil;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/Edweis/PGL2.git

public class Main {

	public static void main(String[] args) {
		exempleAfficheurGrp();
	}
<<<<<<< HEAD

	public static void exempleAfficheurGrp() {
		JFrame fenetre = new JFrame("Salut !");
		fenetre.setLayout(new GridLayout(2, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//---------------------Onglet1
		
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

=======
>>>>>>> branch 'master' of https://github.com/Edweis/PGL2.git
}
