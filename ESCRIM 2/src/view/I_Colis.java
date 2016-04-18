package view;
import utilisateur.*;
import java.awt.EventQueue;
import metier.Article;
import metier.Colis;
import metier.Dimension;

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
import Controleur.Controleur_Colis;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Colis {

	private JFrame frame;
	Utilisateur utilisateur;	
	public void run() {
		try {
			I_Colis window = new I_Colis(utilisateur);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Colis(Utilisateur utilisateur) throws SQLException {
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
		
//		LanceRequete<Article> bdd = new LanceRequete<Article>(Article.class);
		
		JLabel lblColisExistant = new JLabel("COLIS EXISTANTS");
		lblColisExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblColisExistant.setBounds(44, 21, 377, 102);
		frame.getContentPane().add(lblColisExistant);
		
		
		/*Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_colis) FROM colis");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		ArrayList<Colis> col = new ArrayList<>();
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM colis WHERE id_colis=="+i;
			ResultSet Col = Bdd_utilisateur.lecture(requete);
			Dimension dimColis = (Dimension) Col.getObject("dim");
			int numColis = Col.getInt("numerosColis");
			Colis unColis = new Colis(numColis,dimColis);
			col.set(i,unColis);			
		}*/
					
		AfficheurGrp<Colis> afficheur = new AfficheurGrp<Colis>();
//		afficheur.MajGrpColis(col);
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
		
		Controleur_Colis  e2 = new Controleur_Colis (utilisateur, afficheur,this);
		btnVoirCaracteristique.addActionListener(e2);
		btnCreerNouvelle.addActionListener(e2);
		btnRetour.addActionListener(e2);
		btnModifier.addActionListener(e2);
		btnSupprimer.addActionListener(e2);
		btnGererStock.addActionListener(e2);
	
	frame.pack();
	frame.setVisible(true);
}

	public void closeWindow(){
	frame.setVisible(false);
}
}
