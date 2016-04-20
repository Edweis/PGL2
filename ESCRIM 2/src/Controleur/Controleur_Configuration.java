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
import view.I_Article;
import view.I_Config;
import view.I_StockArticle;
import view.I_acceuil;

public class Controleur_Configuration implements ActionListener {

	Utilisateur utilisateur;
	Config selection;
	I_Config vue;

	public Controleur_Configuration(Utilisateur utilisateur, I_Config vue) {
		this.utilisateur = utilisateur;
		this.vue = vue;
//		selection = (Article) afficheur.ExporterSelection().get(0);
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		String str = "0";
		JButton btn = (JButton) e1.getSource();
		str = btn.getText();
		switch (str) {

		case "VOIR CARACTERISTIQUE":

			break;
		case "CREER NOUVEAU":
			vue.creerNouveau();
			break;
		case "RETOUR":
			new I_acceuil(utilisateur);
			break;
		case "GERER STOCK":
			selection = vue.getAfficheur().ExporterSelection().get(0);
			try {
				new I_StockArticle(utilisateur, selection);
			} catch (Throwable e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "MODIFIER":
			vue.modifier();
			break;
		case "SUPPRIMER":
			// try {
			// Bdd_utilisateur.connecter("root", "");
			// ArrayList<Article> art = (ArrayList<Article>)
			// afficheur.ExporterSelection().get(0);
			// String suppr = art.get(0).getNom();
			// String requete = "DELETE suppr fROM article";
			// Bdd_utilisateur.ecriture(requete);
			// Bdd_utilisateur.deconnecter();
			// } catch (SQLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			break;
		case "Valider":

			break;
		case "Annuler":
			vue.fermerFrame();
			break;
		}

	}
}