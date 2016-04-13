package Controleur;
import utilisateur.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import metier.Article;
import utilisateur.Bdd_utilisateur;
import utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_Article;
import view.I_acceuil;

public class Controleur_Article implements ActionListener {

	Utilisateur utilisateur;
	AfficheurGrp afficheur;
	public Controleur_Article(Utilisateur utilisateur, AfficheurGrp afficheur) {
		this.utilisateur = utilisateur;
		this.afficheur = afficheur;
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
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

			break;
		case "SUPPRIMER":
			try {
				Bdd_utilisateur.connecter("root", "");
				Article art = afficheur.exporterSelection().get(0);
				String suppr = art.getNom();
				String requete = "DELETE suppr from article";
				Bdd_utilisateur.ecriture(requete);
				Bdd_utilisateur.deconnecter();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		

	}

	}
}