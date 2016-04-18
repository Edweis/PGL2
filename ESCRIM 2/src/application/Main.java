package application;

/*import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import metier.Article;
import metier.Colis;
import metier.Dimension;
import partieMission.GrpColis;*/
import utilisateur.Utilisateur;
/*import view.AfficheurGrp;*/
import view.I_acceuil;

public class Main {

	public static void main(String[] args) {
		Utilisateur pierre= new Utilisateur("pierre","pierre","nouveaubis",true,true,"grade");
		I_acceuil ouvrir = new I_acceuil(pierre);
		
	}
}


