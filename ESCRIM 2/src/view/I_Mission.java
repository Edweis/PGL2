package view;
import utilisateur.*;
import java.awt.EventQueue;
import metier.Article;
import metier.Colis;
import metier.Dimension;
import partieMission.Avion;
import partieMission.GrpAvions;
import partieMission.GrpColis;
import partieMission.Mission;


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
import Controleur.Controleur_Mission;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Mission {

	private JFrame frame;
	Utilisateur utilisateur;
	
	public void run() {
		try {
			I_Mission window = new I_Mission(utilisateur);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public I_Mission(Utilisateur utilisateur) throws SQLException {
		
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
		
		JLabel lblMissionExistant = new JLabel("MISSIONS EXISTANTES");
		lblMissionExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMissionExistant.setBounds(44, 21, 377, 102);
		frame.getContentPane().add(lblMissionExistant);
		
		
		/*Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_mission) FROM mission");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		ArrayList<Mission> mis = new ArrayList<>();
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM mission WHERE id_mission=="+i;
			ResultSet Mis = Bdd_utilisateur.lecture(requete);
			String nomMis = Mis.getString("nom");
			CaracMission caracMis = (CaracMission) Mis.getObject("caracteristiques");
			GrpAvions ensAvionsMis = (GrpAvions) Mis.getObject("ensAvions");
			GrpColis ensColisMis = (GrpColis) Mis.getObject("ensColis");;;
			Mission uneMis = new Mission(nomMis,caracMis,ensAvionsMis,ensColisMis);
			mis.set(i,uneMis);			
		}*/
					
		AfficheurGrp<Mission> afficheur = new AfficheurGrp<Mission>();
		//afficheur.MajGrpColis(mis);
		frame.getContentPane().add(afficheur);

		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 100, 250, 50);
		frame.getContentPane().add(btnVoirCaracteristique);
		
		afficheur.activeOnSelect(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 170, 250, 50);
		frame.getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(602, 380, 250, 50);
		frame.getContentPane().add(btnRetour);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(602, 240, 250, 50);
		frame.getContentPane().add(btnModifier);
		
		afficheur.activeOnSelect(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 310, 250, 50);
		frame.getContentPane().add(btnSupprimer);
		
		afficheur.activeOnSelect(btnSupprimer);
		
		Controleur_Mission  e5 = new Controleur_Mission (utilisateur, afficheur,this);
		btnVoirCaracteristique.addActionListener(e5);
		btnCreerNouvelle.addActionListener(e5);
		btnRetour.addActionListener(e5);
		btnModifier.addActionListener(e5);
		btnSupprimer.addActionListener(e5);
		
		frame.pack();
		frame.setSize(1000,700);
		frame.setVisible(true);
	}
	
	
	public void closeWindow(){
		frame.setVisible(false);
	}
}