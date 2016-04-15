package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import metier.Article;
import metier.Colis;
import partieMission.Avion;
import utilisateur.Bdd_utilisateur;
import utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_acceuil;

public class Controleur_Avion implements ActionListener {
	Utilisateur utilisateur;
	AfficheurGrp afficheur;
	public Controleur_Avion(Utilisateur utilisateur, AfficheurGrp afficheur) {
		this.utilisateur = utilisateur;
		this.afficheur = afficheur;
	}

	@Override
	public void actionPerformed(ActionEvent e3) {
		// TODO Auto-generated method stub
		String str = "0";
		JButton btn =(JButton) e3.getSource();
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

		case "MODIFIER":

			break;
		case "SUPPRIMER":
			try {
				Bdd_utilisateur.connecter("root", "");
				ArrayList<Avion> avion = (ArrayList<Avion>) afficheur.ExporterSelection().get(0);
				String suppr = avion.get(0).getNom();
				String requete = "DELETE"+ suppr +"FROM avion";
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