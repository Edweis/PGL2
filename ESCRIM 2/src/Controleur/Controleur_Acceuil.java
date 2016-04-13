package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import utilisateur.Utilisateur;
import view.I_Article;

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

			break;
		case "GESTION ARTICLE":
			try {
				I_Article ouvrir = new I_Article(utilisateur);
				ouvrir.run();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "GESTION AVION":

			break;

		}

	}
}
