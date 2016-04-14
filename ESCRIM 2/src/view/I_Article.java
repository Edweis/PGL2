package view;
import utilisateur.*;
import java.awt.EventQueue;
import metier.Article;
import javax.swing.JFrame;

import utilisateur.Utilisateur;
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
	public void run() {
		try {
			I_Article window = new I_Article(utilisateur);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Article(Utilisateur utilisateur) throws SQLException {
		this.utilisateur= utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 952, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblArticleExistant = new JLabel("ARTICLES EXISTANTS");
		lblArticleExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblArticleExistant.setBounds(44, 21, 377, 102);
		frame.getContentPane().add(lblArticleExistant);
		
		
		Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_article) FROM article");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		ArrayList<Article> art = new ArrayList<>();
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM article WHERE id_article=="+i;
			ResultSet Art = Bdd_utilisateur.lecture(requete);
			String nomArt = Art.getString("nom");
			String typeArt = Art.getString("type");
			float poidsArt = Art.getFloat("poids");
			Article unArticle = new Article(nomArt,typeArt,poidsArt);
			art.set(i,unArticle);			
		}
					
		AfficheurGrp<Article> afficheur = new AfficheurGrp<Article>();
		afficheur.MajGrpColis(art);
		frame.getContentPane().add(afficheur);

		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 101, 229, 40);
		frame.getContentPane().add(btnVoirCaracteristique);
		
		afficheur.activeOnSelect(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 173, 229, 40);
		frame.getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(803, 470, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(602, 242, 229, 33);
		frame.getContentPane().add(btnModifier);
		
		afficheur.activeOnSelect(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 311, 229, 40);
		frame.getContentPane().add(btnSupprimer);
		
		afficheur.activeOnSelect(btnSupprimer);
		
		JButton btnGererStock = new JButton("GERER STOCK");
		btnGererStock.setBounds(602, 374, 229, 40);
		frame.getContentPane().add(btnGererStock);
		
		Controleur_Article  e1 = new Controleur_Article (utilisateur, afficheur);
		btnVoirCaracteristique.addActionListener(e1);
		btnCreerNouvelle.addActionListener(e1);
		btnRetour.addActionListener(e1);
		btnModifier.addActionListener(e1);
		btnSupprimer.addActionListener(e1);
		btnGererStock.addActionListener(e1);
	}
}