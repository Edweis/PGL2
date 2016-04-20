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
import javax.swing.JTextField;

import Controleur.Controleur_Acceuil;
import Controleur.Controleur_Article;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Article {

	Utilisateur utilisateur;
	Controleur_Article controleur;

	public void run() throws Throwable {
		try {
			I_Article window = new I_Article(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public I_Article(Utilisateur utilisateur) throws Throwable {
		this.utilisateur = utilisateur;
		this.controleur = new Controleur_Article(utilisateur, this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {

		Vue.getInstance().vider();

		// LanceRequete<Article> bdd = new LanceRequete<Article>(Article.class);

		JLabel lblArticleExistant = new JLabel("ARTICLES EXISTANTS");
		lblArticleExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblArticleExistant.setBounds(44, 21, 377, 102);
		Vue.getInstance().getContentPane().add(lblArticleExistant);

		// ArrayList<Article> articles = bdd.selectWhere("");
		// int val = ((Number) dernierID.getObject(1)).intValue();
		//
		// ArrayList<Article> art = new ArrayList<>();
		// for (int i=1;i<val;i++){
		// String requete="SELECT * FROM article WHERE id_article=="+i;
		// ResultSet Art = Bdd_utilisateur.lecture(requete);
		// String nomArt = Art.getString("nom");
		// String typeArt = Art.getString("type");
		// float poidsArt = Art.getFloat("poids");
		// Article unArticle = new Article(nomArt,typeArt,poidsArt);
		// art.set(i,unArticle);
		// }

		AfficheurGrp<Article> afficheur = new AfficheurGrp<Article>();
		// afficheur.MajGrpColis(articles);
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

		
		btnVoirCaracteristique.addActionListener(controleur);
		btnCreerNouvelle.addActionListener(controleur);
		btnRetour.addActionListener(controleur);
		btnModifier.addActionListener(controleur);
		btnSupprimer.addActionListener(controleur);
		btnGererStock.addActionListener(controleur);

		Vue.getInstance().finitions();
	}

	public void creerNouveau() {

		JFrame frame = new JFrame();
		frame.setLayout(null);
		JTextField nom = new JTextField();
		JTextField type = new JTextField();
		JTextField poids = new JTextField();

		JLabel nomlbl = new JLabel("Nom:");
		nomlbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel typelbl = new JLabel("Type:");
		typelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel poidslbl = new JLabel("Poids:");
		poidslbl.setFont(new Font("Tahoma", Font.BOLD, 14));

		nom.setBounds(204, 143, 86, 20);
		type.setBounds(204, 174, 86, 20);
		poids.setBounds(204, 205, 86, 20);

		nomlbl.setBounds(104, 143, 86, 20);
		typelbl.setBounds(104, 174, 86, 20);
		poidslbl.setBounds(104, 205, 86, 20);

		JButton valider = new JButton("Valider");
		valider.setBounds(204, 235, 120, 23);
		JButton annuler = new JButton("Annuler");
		annuler.setBounds(104, 235, 120, 23);

		valider.addActionListener(controleur);
		annuler.addActionListener(controleur);

		frame.getContentPane().add(nom);
		frame.getContentPane().add(nomlbl);
		frame.getContentPane().add(type);
		frame.getContentPane().add(typelbl);
		frame.getContentPane().add(poids);
		frame.getContentPane().add(poidslbl);
		frame.getContentPane().add(valider);
		frame.getContentPane().add(annuler);


		nom.setColumns(10);
		type.setColumns(10);
		poids.setColumns(10);
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}