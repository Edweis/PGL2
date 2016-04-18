package view;
import utilisateur.*;
import java.awt.EventQueue;
import metier.Article;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;

import Controleur.Controleur_Acceuil;
import Controleur.Controleur_Article;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Article {

	private JFrame frame;
	Utilisateur utilisateur;
	public void run() throws Throwable {
		try {
			I_Article window = new I_Article(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Article(Utilisateur utilisateur) throws Throwable {
		this.utilisateur= utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {

		Vue.getInstance().vider();

//		LanceRequete<Article> bdd = new LanceRequete<Article>(Article.class);
		
		JLabel lblArticleExistant = new JLabel("ARTICLES EXISTANTS");
		lblArticleExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblArticleExistant.setBounds(44, 21, 377, 102);
		Vue.getInstance().getContentPane().add(lblArticleExistant);
		
		
//		ArrayList<Article> articles = bdd.selectWhere("");
//		int val =  ((Number) dernierID.getObject(1)).intValue();
//				
//		ArrayList<Article> art = new ArrayList<>();
//		for (int i=1;i<val;i++){
//			String requete="SELECT * FROM article WHERE id_article=="+i;
//			ResultSet Art = Bdd_utilisateur.lecture(requete);
//			String nomArt = Art.getString("nom");
//			String typeArt = Art.getString("type");
//			float poidsArt = Art.getFloat("poids");
//			Article unArticle = new Article(nomArt,typeArt,poidsArt);
//			art.set(i,unArticle);			
//		}
					
		AfficheurGrp<Article> afficheur = new AfficheurGrp<Article>();
//		afficheur.MajGrpColis(articles);
		Vue.getInstance().getContentPane().add(afficheur);

		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 100, 250, 50);
		Vue.getInstance().getContentPane().add(btnVoirCaracteristique);
		
		afficheur.activeOnSelect(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 170, 250, 50);
		Vue.getInstance().getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(602, 380, 250, 50);
		Vue.getInstance().getContentPane().add(btnRetour);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(602, 240, 250, 50);
		Vue.getInstance().getContentPane().add(btnModifier);
		
		afficheur.activeOnSelect(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 310, 250, 50);
		Vue.getInstance().getContentPane().add(btnSupprimer);
		
		afficheur.activeOnSelect(btnSupprimer);
		
		JButton btnGererStock = new JButton("GERER STOCK");
		btnGererStock.setBounds(602, 380, 250, 50);
		Vue.getInstance().getContentPane().add(btnGererStock);
		
		Controleur_Article  e1 = new Controleur_Article (utilisateur, afficheur,this);
		btnVoirCaracteristique.addActionListener(e1);
		btnCreerNouvelle.addActionListener(e1);
		btnRetour.addActionListener(e1);
		btnModifier.addActionListener(e1);
		btnSupprimer.addActionListener(e1);
		btnGererStock.addActionListener(e1);
		
		Vue.getInstance().finitions();
	}
}