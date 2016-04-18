package view;
import utilisateur.*;
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
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 941, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGestionMission = new JButton("GESTION MISSION");
		btnGestionMission.setBounds(362, 124, 160, 50);
		frame.getContentPane().add(btnGestionMission);
		
		JButton btnNGestionConfiguration = new JButton("GESTION CONFIGURATION");
		btnNGestionConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNGestionConfiguration.setBounds(362, 198, 160, 50);
		frame.getContentPane().add(btnNGestionConfiguration);
		
		JButton btnGestionColis = new JButton("GESTION COLIS");
		btnGestionColis.setBounds(362, 259, 160, 50);
		frame.getContentPane().add(btnGestionColis);
		
		JButton btnGestionArticle = new JButton("GESTION ARTICLE");
		btnGestionArticle.setBounds(362, 334, 160, 44);
		frame.getContentPane().add(btnGestionArticle);
		
		JButton btnGestionAvion = new JButton("GESTION AVION");
		btnGestionAvion.setBounds(362, 405, 160, 32);
		frame.getContentPane().add(btnGestionAvion);
		
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHello.setBounds(293, 30, 115, 50);
		frame.getContentPane().add(lblHello);
		
		String uti = utilisateur.getNom();
		JLabel lbl = new JLabel(uti);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbl.setBounds(373, 30, 115, 50);
		frame.getContentPane().add(lbl);
		
		Controleur_Acceuil  e = new Controleur_Acceuil (utilisateur);
		btnGestionMission.addActionListener(e);
		btnNGestionConfiguration.addActionListener(e);
		btnGestionColis.addActionListener(e);
		btnGestionArticle.addActionListener(e);
		btnGestionAvion.addActionListener(e);
		
		frame.pack();
		frame.setVisible(true);
	}
}
