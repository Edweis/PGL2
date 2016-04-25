package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import metier.Mission;
import metier.utilisateur.Bdd_utilisateur;
import metier.utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_Mission;
import view.I_acceuil;

public class Controleur_Mission implements ActionListener {
	Utilisateur utilisateur;
	AfficheurGrp afficheur;
	I_Mission vue;
	public Controleur_Mission(Utilisateur utilisateur, AfficheurGrp afficheur, I_Mission vue) {
		this.utilisateur = utilisateur;
		this.afficheur = afficheur;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e5) {
		// TODO Auto-generated method stub
		String str = "0";
		JButton btn =(JButton) e5.getSource();
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
				ArrayList<Mission> mission = (ArrayList<Mission>) afficheur.ExporterSelection().get(0);
				String suppr = mission.get(0).getNom();
				String requete = "DELETE"+ suppr +"FROM mission";
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