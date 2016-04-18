package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import utilisateur.Utilisateur;
import view.I_Article;
import view.I_Colis;
import view.I_Mission;
import view.I_acceuil;

public class Controleur_Acceuil implements ActionListener {

	Utilisateur utilisateur;
	I_acceuil vue;
	public Controleur_Acceuil(Utilisateur utilisateur, I_acceuil vue) {
		this.utilisateur = utilisateur;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String str = "0";
		JButton btn = (JButton) e.getSource();
		str = btn.getText();
		switch (str) {

		case "GESTION MISSION":
			try {
				I_Mission ouvrir2 = new I_Mission(utilisateur);
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			vue.closeWindow();
			break;
		case "GESTION CONFIGURATION":

			break;
		case "GESTION COLIS":
			try {
			I_Colis	ouvrir = new I_Colis(utilisateur);
			vue.closeWindow();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			//ouvrir.run();
			break;
		case "GESTION ARTICLE":

			try {
				I_Article ouvrir3 = new I_Article(utilisateur);
				vue.closeWindow();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		case "GESTION AVION":

			break;

		}

	}
}
