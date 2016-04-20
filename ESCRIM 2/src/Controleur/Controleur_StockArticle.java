package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import metier.Article;
import utilisateur.Bdd_utilisateur;
import utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_Article;
import view.I_StockArticle;
import view.I_acceuil;

public class Controleur_StockArticle implements ActionListener{

	Utilisateur utilisateur;
	Article selection;
	I_StockArticle vue;
	public Controleur_StockArticle(Utilisateur utilisateur, I_StockArticle vue) {
		this.utilisateur = utilisateur;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		String str = "0";
		JButton btn =(JButton) e1.getSource();
		str = btn.getText();
		switch (str) {

		case "CREER NOUVEAU":
			vue.creerNouveau();
			break;
		case "RETOUR":
			try {
				new I_Article(utilisateur);
			} catch (Throwable e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;	

		case "MODIFIER":
			vue.modifier();
			break;
		case "SUPPRIMER":
//			try {
//				Bdd_utilisateur.connecter("root", "");
//				ArrayList<Article> art = (ArrayList<Article>) afficheur.ExporterSelection().get(0);
//				String suppr = art.get(0).getNom();
//				String requete = "DELETE suppr fROM article";
//				Bdd_utilisateur.ecriture(requete);
//				Bdd_utilisateur.deconnecter();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			break;
		case "Valider":
			
			break;
		case "Annuler":
			vue.fermerFrame();
			break;
	}

	}
}
