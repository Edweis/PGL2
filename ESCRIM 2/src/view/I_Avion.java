package view;
import utilisateur.*;
import java.awt.EventQueue;
import metier.Article;
import metier.Colis;
import metier.Dimension;
import partieMission.Avion;

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

public class I_Avion {

	private JFrame frame;
	Utilisateur utilisateur;
	
	public void run() {
		try {
			I_Avion window = new I_Avion(utilisateur);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Avion(Utilisateur utilisateur) throws SQLException {
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
		
		JLabel lblAvionExistant = new JLabel("AVIONS EXISTANTS");
		lblAvionExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAvionExistant.setBounds(44, 21, 377, 102);
		frame.getContentPane().add(lblAvionExistant);
		
		
		Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_avion) FROM avion");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		ArrayList<Avion> avi = new ArrayList<>();
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM avion WHERE id_avion=="+i;
			ResultSet Avi = Bdd_utilisateur.lecture(requete);
			String nomAv = Avi.getString("nom");
			Long volumeAv = Avi.getLong("volume");
			String caracv = Avi.getString("caracteristiques");
			String immaAv = Avi.getString("immatriculation");
			Avion unAvion = new Avion(nomAv,volumeAv,caracv,immaAv);
			avi.set(i,unAvion);			
		}
					
		AfficheurGrp<Avion> afficheur = new AfficheurGrp<Avion>();
		afficheur.MajGrpColis(avi);
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
		
		Controleur_Colis  e3 = new Controleur_Colis (utilisateur, afficheur);
		btnVoirCaracteristique.addActionListener(e3);
		btnCreerNouvelle.addActionListener(e3);
		btnRetour.addActionListener(e3);
		btnModifier.addActionListener(e3);
		btnSupprimer.addActionListener(e3);
	}
}

