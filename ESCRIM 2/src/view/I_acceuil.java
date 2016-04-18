package view;
import utilisateur.*;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controleur.Controleur_Acceuil;

public class I_acceuil {

	private JFrame frame;
	Utilisateur utilisateur;

	public void run() {
		try {
			I_acceuil window = new I_acceuil(utilisateur);
			window.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public I_acceuil(Utilisateur utilisateur) {
		
		this.utilisateur =utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 941, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGestionMission = new JButton("GESTION MISSION");
		btnGestionMission.setBounds(360, 120, 250, 50);
		frame.getContentPane().add(btnGestionMission);
		
		JButton btnNGestionConfiguration = new JButton("GESTION CONFIGURATION");
		btnNGestionConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNGestionConfiguration.setBounds(360, 200, 250, 50);
		frame.getContentPane().add(btnNGestionConfiguration);
		
		JButton btnGestionColis = new JButton("GESTION COLIS");
		btnGestionColis.setBounds(360, 280, 250, 50);
		frame.getContentPane().add(btnGestionColis);
		
		JButton btnGestionArticle = new JButton("GESTION ARTICLE");
		btnGestionArticle.setBounds(360, 360, 250, 50);
		frame.getContentPane().add(btnGestionArticle);
		
		JButton btnGestionAvion = new JButton("GESTION AVION");
		btnGestionAvion.setBounds(360, 440, 250, 50);
		frame.getContentPane().add(btnGestionAvion);
		
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHello.setBounds(380, 30, 115, 50);
		frame.getContentPane().add(lblHello);
		
		String uti = utilisateur.getNom();
		JLabel lbl = new JLabel(uti);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbl.setBounds(465, 30, 115, 50);
		frame.getContentPane().add(lbl);
		
		Controleur_Acceuil  e = new Controleur_Acceuil (utilisateur,this);
		btnGestionMission.addActionListener(e);
		btnNGestionConfiguration.addActionListener(e);
		btnGestionColis.addActionListener(e);
		btnGestionArticle.addActionListener(e);
		btnGestionAvion.addActionListener(e);
		
		frame.pack();
		frame.setSize(1000,700);
		frame.setVisible(true);
	}
	
	public void closeWindow(){
		frame.setVisible(false);
	}
}
