package view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Controleur.Controleur_Article;
import Controleur.Controleur_ModifArticle;
import metier.Article;
import utilisateur.Utilisateur;

import javax.swing.JComboBox;
import javax.swing.JButton;


public class I_PopupModifArticle {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	Utilisateur utilisateur;
	Article selection;
	public void run() {
		try {
			I_PopupModifArticle window = new I_PopupModifArticle(utilisateur);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public I_PopupModifArticle(Utilisateur utilisateur, Article selection) throws SQLException {
		this.utilisateur = utilisateur;
		this.selection = selection;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEcran = new JLabel();
		lblEcran.setBounds(917, 104, -845, 410);
		frame.getContentPane().add(lblEcran);
		
		JLabel lblModification = new JLabel("Modification");
		lblModification.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblModification.setBounds(377, 11, 278, 69);
		frame.getContentPane().add(lblModification);
		
		JLabel lblNouveauNom = new JLabel("Nouveau nom");
		lblNouveauNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNouveauNom.setBounds(82, 127, 115, 26);
		frame.getContentPane().add(lblNouveauNom);
		
		JLabel lblNouveauType = new JLabel("Nouveau type");
		lblNouveauType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNouveauType.setBounds(82, 203, 115, 26);
		frame.getContentPane().add(lblNouveauType);
		
		JLabel lblNouveauPoids = new JLabel("Nouveau poids");
		lblNouveauPoids.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNouveauPoids.setBounds(82, 273, 108, 26);
		frame.getContentPane().add(lblNouveauPoids);
		
		textField = new JTextField();
		textField.setBounds(234, 127, 120, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(234, 278, 110, 31);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(234, 203, 120, 26);	
		comboBox.addItem("Medicament");
		comboBox.addItem("Materiel");
		frame.getContentPane().add(comboBox);
		
		JButton btnValider = new JButton("VALIDER");
		btnValider.setBounds(502, 473, 127, 41);
		frame.getContentPane().add(btnValider);
		
		Controleur_ModifArticle  e6 = new Controleur_ModifArticle(utilisateur, selection, textField, textField_2, comboBox);
		textField.addActionListener(e6);
		textField_2.addActionListener(e6);
		comboBox.addActionListener(e6);
		btnValider.addActionListener(e6);

	}
}
