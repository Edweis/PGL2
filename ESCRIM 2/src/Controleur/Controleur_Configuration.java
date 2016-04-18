package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import metier.Article;
import metier.Colis;
import partieMission.Avion;
import partieMission.configs.Configuration;
import utilisateur.Bdd_utilisateur;
import utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_Config;
import view.I_acceuil;

public class Controleur_Configuration implements ActionListener {
	Utilisateur utilisateur;
	AfficheurGrp afficheur;
	I_Config vue;
	public Controleur_Configuration(Utilisateur utilisateur, AfficheurGrp afficheur, I_Config vue) {
		this.utilisateur = utilisateur;
		this.afficheur = afficheur;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e4) {
		// TODO Auto-generated method stub
		String str = "0";
		JButton btn =(JButton) e4.getSource();
		str = btn.getText();
		switch (str) {

		case "VOIR CARACTERISTIQUE":
		
			break;
		case "CREER NOUVEAU":
			
			break;
		case "RETOUR":
			I_acceuil ouvrir = new I_acceuil(utilisateur);
			break;	

		case "MODIFIER":

			break;
		case "SUPPRIMER":
			try {
				Bdd_utilisateur.connecter("root", "");
				ArrayList<Configuration> configuration = (ArrayList<Configuration>) afficheur.ExporterSelection().get(0);
				String suppr = configuration.get(0).getNom();
				String requete = "DELETE"+ suppr +"FROM configuration";
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