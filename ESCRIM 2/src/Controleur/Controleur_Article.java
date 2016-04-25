package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import metier.Article;
import metier.utilisateur.Utilisateur;
import view.I_Article;
import view.I_StockArticle;
import view.I_acceuil;

public class Controleur_Article implements ActionListener {

	Utilisateur utilisateur;
	Article selection;
	I_Article vue;
	LanceRequete<Article> bdd;
	public Controleur_Article(Utilisateur utilisateur, I_Article vue) throws Throwable {
		this.utilisateur = utilisateur;
		this.vue = vue;
		this.bdd = new LanceRequete<Article>(Article.class.getName());
//		selection = (Article) afficheur.ExporterSelection().get(0);
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
			vue.creerNouveau();
			break;
		case "RETOUR":
			I_acceuil ouvrir = new I_acceuil(utilisateur);
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
			Article nouveau = new Article(this.vue.getNom(),this.vue.getType(),this.vue.getPoids());
			try {
				bdd.add(nouveau);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				vue.fermerFrame();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Annuler":
			vue.fermerFrame();
			break;
	}

	}
}