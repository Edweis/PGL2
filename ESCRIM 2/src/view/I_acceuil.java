package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controleur.Controleur_Acceuil;
import metier.utilisateur.Utilisateur;

public class I_acceuil {

	Utilisateur utilisateur;


	public I_acceuil(Utilisateur utilisateur) {
		
		this.utilisateur =utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Vue.getInstance().vider();
		
		JButton btnGestionMission = new JButton("GESTION MISSION");
		btnGestionMission.setBounds(362, 124, 160, 50);
		Vue.getInstance().getContentPane().add(btnGestionMission);
		
		JButton btnNGestionConfiguration = new JButton("GESTION CONFIGURATION");
		btnNGestionConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNGestionConfiguration.setBounds(362, 198, 160, 50);
		Vue.getInstance().getContentPane().add(btnNGestionConfiguration);
		
		JButton btnGestionColis = new JButton("GESTION COLIS");
		btnGestionColis.setBounds(362, 259, 160, 50);
		Vue.getInstance().getContentPane().add(btnGestionColis);
		
		JButton btnGestionArticle = new JButton("GESTION ARTICLE");
		btnGestionArticle.setBounds(362, 334, 160, 44);
		Vue.getInstance().getContentPane().add(btnGestionArticle);
		
		JButton btnGestionAvion = new JButton("GESTION AVION");
		btnGestionAvion.setBounds(362, 405, 160, 32);
		Vue.getInstance().getContentPane().add(btnGestionAvion);
		
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHello.setBounds(293, 30, 115, 50);
		Vue.getInstance().getContentPane().add(lblHello);
		
		String uti = utilisateur.getNom();
		JLabel lbl = new JLabel(uti);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbl.setBounds(373, 30, 115, 50);
		Vue.getInstance().getContentPane().add(lbl);
		
		Controleur_Acceuil  e = new Controleur_Acceuil (utilisateur,this);
		btnGestionMission.addActionListener(e);
		btnNGestionConfiguration.addActionListener(e);
		btnGestionColis.addActionListener(e);
		btnGestionArticle.addActionListener(e);
		btnGestionAvion.addActionListener(e);
		
		Vue.getInstance().finitions();
	}
	
}
