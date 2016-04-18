package view;
import utilisateur.*;
import java.awt.EventQueue;
import metier.Article;
import metier.Colis;
import metier.Dimension;
import partieMission.Avion;
import partieMission.configs.Configuration;

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
import Controleur.Controleur_Configuration;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Config {

	private JFrame frame;
	Utilisateur utilisateur;
	
	public void run() {
		try {
			I_Config window = new I_Config(utilisateur);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Config(Utilisateur utilisateur) throws SQLException {
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
		
		JLabel lblConfigExistant = new JLabel("CONFIGURATIONS EXISTANTES");
		lblConfigExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblConfigExistant.setBounds(44, 21, 377, 102);
		frame.getContentPane().add(lblConfigExistant);
		
		
		/*Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_config) FROM configuration");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		ArrayList<Configuration> conf = new ArrayList<>();
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM configuration WHERE id_configuration=="+i;
			ResultSet Conf = Bdd_utilisateur.lecture(requete);
			String nomConf = Conf.getString("nom");
			Configuration uneConf = new Configuration(nomConf);
			conf.set(i,uneConf);			
		}*/
					
		AfficheurGrp<Configuration> afficheur = new AfficheurGrp<Configuration>();
		//afficheur.MajGrpColis(conf);
		frame.getContentPane().add(afficheur);

		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 100, 250,50);
		frame.getContentPane().add(btnVoirCaracteristique);
		
		afficheur.activeOnSelect(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 170, 250,50);
		frame.getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(602, 380, 250,50);
		frame.getContentPane().add(btnRetour);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(602, 240,250,50);
		frame.getContentPane().add(btnModifier);
		
		afficheur.activeOnSelect(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 310, 250,50);
		frame.getContentPane().add(btnSupprimer);
		
		afficheur.activeOnSelect(btnSupprimer);
		
		Controleur_Configuration  e4 = new Controleur_Configuration (utilisateur, afficheur,this);
		btnVoirCaracteristique.addActionListener(e4);
		btnCreerNouvelle.addActionListener(e4);
		btnRetour.addActionListener(e4);
		btnModifier.addActionListener(e4);
		btnSupprimer.addActionListener(e4);
		frame.pack();
		frame.setSize(1000,700);
		frame.setVisible(true);
	}
	
	public void closeWindow(){
		frame.setVisible(false);
	}
}

