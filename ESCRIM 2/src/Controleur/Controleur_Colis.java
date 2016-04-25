package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import metier.Colis;
import metier.utilisateur.Bdd_utilisateur;
import metier.utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_Colis;
import view.I_acceuil;

public class Controleur_Colis implements ActionListener {
	Utilisateur utilisateur;
	AfficheurGrp afficheur;
	I_Colis vue;
	public Controleur_Colis(Utilisateur utilisateur, AfficheurGrp afficheur, I_Colis vue) {
		this.utilisateur = utilisateur;
		this.afficheur = afficheur;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e2) {
		// TODO Auto-generated method stub
		String str = "0";
		JButton btn =(JButton) e2.getSource();
		str = btn.getText();
		switch (str) {

		case "VOIR CARACTERISTIQUE":
		
			break;
		case "CREER NOUVEAU":
			
			break;
		case "RETOUR":
			I_acceuil ouvrir = new I_acceuil(utilisateur);
			break;	
		case "GERER STOCK":
			
			break;	
		case "MODIFIER":

			break;
		case "SUPPRIMER":
			try {
				Bdd_utilisateur.connecter("root", "");
				ArrayList<Colis> colis = (ArrayList<Colis>) afficheur.ExporterSelection().get(0);				
				int suppr = colis.get(0).getNumeroColis();
				String requete = "DELETE"+ suppr +"FROM colis";
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
