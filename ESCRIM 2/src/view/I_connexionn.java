package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;


import utilisateur.Admin;
import utilisateur.Bdd_utilisateur;
import utilisateur.Utilisateur;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class I_connexionn {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNom;
	private JLabel lblPrnom;
	private JTextField textField_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					I_connexionn window = new I_connexionn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public I_connexionn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(28, 13, 396, 238);
		frame.getContentPane().add(panel_2);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		panel_2.add(lblMotDePasse);
		
		lblPrnom = new JLabel("Pr\u00E9nom");
		panel_2.add(lblPrnom);
		
		JButton btnSeConnecter = new JButton("Se connecter");
		panel_2.add(btnSeConnecter);
		
		lblNom = new JLabel("Nom");
		panel_2.add(lblNom);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel image = new JLabel( new ImageIcon("/Devellopement/Workspace/demojdbc/src/Image/horloge1.png"));
		panel_2.add(image);
		
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String prenom=textField_2.getText();
			String nom= textField.getText();
			Bdd_utilisateur a = new Bdd_utilisateur();
			try {
				a.connecter("root", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String requete="SELECT * from utilisateur where nom='"+nom+"'AND prenom='"+prenom+"'";
			String vrai_mdp=null;
			try {
				ResultSet resultat= a.lecture(requete);
				
				while(resultat.next()){
					 vrai_mdp =resultat.getString("mdp");
				}
				String mdp_ecris= textField_1.getText();
			if(textField_2.getText().equals("admin") && textField.getText().equals("admin") && textField_1.getText().equals("admin")) {
				Admin admin= new Admin();
				I_administrateur b=new I_administrateur(a,admin);
				b.run();
			}else if(vrai_mdp != null && vrai_mdp.equals(mdp_ecris)){
					System.out.println("vous pouvez vous connecter");
					Utilisateur utilisateur= new Utilisateur("jean","pierre","coucou",true,false,"Pr.");
					I_acceuil iaccuil=new I_acceuil(utilisateur);
					iaccuil.run();
				}else{
					System.out.println("enfoiré");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("erreur");
			}
			
			}
		});
	
	
		
	}
}
