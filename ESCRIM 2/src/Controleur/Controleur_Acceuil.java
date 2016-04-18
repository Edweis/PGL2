package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import utilisateur.Utilisateur;
import view.I_Article;
import view.I_Colis;

public class Controleur_Acceuil implements ActionListener {

	Utilisateur utilisateur;

	public Controleur_Acceuil(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String str = "0";
		JButton btn = (JButton) e.getSource();
		str = btn.getText();
		switch (str) {

		case "GESTION MISSION":

			break;
		case "GESTION CONFIGURATION":

			break;
		case "GESTION COLIS":
			I_Colis ouvrir = null;
			try {
				ouvrir = new I_Colis(utilisateur);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ouvrir.run();
			break;
		case "GESTION ARTICLE":

			try {
				I_Article ouvrir3 = new I_Article(utilisateur);
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
