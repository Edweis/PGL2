package view;

import utilisateur.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controleur.Controleur_Acceuil;

public class I_acceuil {

	Utilisateur utilisateur;

	public void run() {
		try {
			I_acceuil window = new I_acceuil(utilisateur);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public I_acceuil(Utilisateur utilisateur) {

		this.utilisateur = utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the Vue.getInstance().
	 */
	private void initialize() {

		Vue.getInstance().vider();
		JButton btnGestionMission = new JButton("GESTION MISSION");
		btnGestionMission.setBounds(360, 120, 250, 50);
		Vue.getInstance().getContentPane().add(btnGestionMission);

		JButton btnNGestionConfiguration = new JButton("GESTION CONFIGURATION");
		btnNGestionConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNGestionConfiguration.setBounds(360, 200, 250, 50);
		Vue.getInstance().getContentPane().add(btnNGestionConfiguration);

		JButton btnGestionColis = new JButton("GESTION COLIS");
		btnGestionColis.setBounds(360, 280, 250, 50);
		Vue.getInstance().getContentPane().add(btnGestionColis);

		JButton btnGestionArticle = new JButton("GESTION ARTICLE");
		btnGestionArticle.setBounds(360, 360, 250, 50);
		Vue.getInstance().getContentPane().add(btnGestionArticle);

		JButton btnGestionAvion = new JButton("GESTION AVION");
		btnGestionAvion.setBounds(360, 440, 250, 50);
		Vue.getInstance().getContentPane().add(btnGestionAvion);

		JLabel lblHello = new JLabel("Hello");
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHello.setBounds(380, 30, 115, 50);
		Vue.getInstance().getContentPane().add(lblHello);

		String uti = utilisateur.getNom();
		JLabel lbl = new JLabel(uti);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbl.setBounds(465, 30, 115, 50);
		Vue.getInstance().getContentPane().add(lbl);

		Controleur_Acceuil e = new Controleur_Acceuil(utilisateur, this);
		btnGestionMission.addActionListener(e);
		btnNGestionConfiguration.addActionListener(e);
		btnGestionColis.addActionListener(e);
		btnGestionArticle.addActionListener(e);
		btnGestionAvion.addActionListener(e);

		Vue.getInstance().finitions();
	}
}
