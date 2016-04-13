package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import utilisateur.Utilisateur;
import view.I_Article;
import view.I_acceuil;

public class Controleur_Article implements ActionListener {

	Utilisateur utilisateur;
	public Controleur_Article(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur;
		String str = "0";
		JButton btn =(JButton) e1.getSource();
		str = btn.getText();
		switch (str) {

		case "VOIR CARACTERISTIQUE":
		
			break;
		case "CREER NOUVEAU":
			
			break;
		case "RETOUR":
			I_acceuil ouvrir = new I_acceuil(utilisateur);
			ouvrir.run();
			break;	
		case "GERER STOCK":
			
			break;	
		case "MODIFIER":
			try {

			break;
		case "SUPPRIMER":
			
			break;
		

	}

	}
}