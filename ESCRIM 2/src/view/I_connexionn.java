package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import metier.utilisateur.Admin;
import metier.utilisateur.Bdd_utilisateur;
import metier.utilisateur.Utilisateur;

public class I_connexionn {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNom;
	private JLabel lblPrnom;
	private JTextField textField_2;

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
		//Declaration de la frame
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		//Declaration des champs de textes
		textField = new JTextField();
		textField.setBounds(204, 143, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(204, 205, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotDePasse.setBounds(99, 208, 95, 14);
		frame.getContentPane().add(lblMotDePasse);
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(99, 141, 46, 20);
		frame.getContentPane().add(lblNom);
		
		lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrnom.setBounds(100, 172, 70, 20);
		frame.getContentPane().add(lblPrnom);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 174, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		
		JButton btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String prenom=textField_2.getText();
			String nom= textField.getText();
			
			try {
				Bdd_utilisateur.connecter("root", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String requete="SELECT * from utilisateur where nom='"+nom+"'AND prenom='"+prenom+"'";
			String vrai_mdp=null;
			try {
				ResultSet resultat= Bdd_utilisateur.lecture(requete);
				
				while(resultat.next()){
					 vrai_mdp =resultat.getString("mdp");
				}
				String mdp_ecris= textField_1.getText();
			if(textField_2.getText().equals("admin") && textField.getText().equals("admin") && textField_1.getText().equals("admin")) {
				Admin admin= new Admin();
				I_administrateur b=new I_administrateur(admin);
				b.run();
			}else if(vrai_mdp.equals(mdp_ecris)){
					System.out.println("vous pouvez vous connecter");
					Utilisateur utilisateur= new Utilisateur("jean","pierre","coucou",true,false,"Pr.");
					I_acceuil iaccuil=new I_acceuil(utilisateur);
					//iaccuil.run();
				}else{
					System.out.println("enfoir�");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("erreur");
			}
			
			}
		});
		btnSeConnecter.setBounds(187, 235, 120, 23);
		frame.getContentPane().add(btnSeConnecter);
		JLabel image = new JLabel( new ImageIcon( "/Users/Fino/git/PGL2/ESCRIM 2/src/Image/logo_escrime.png"));
		frame.getContentPane().add(image);
		image.setBounds(150, 11, 202, 136);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( "/Users/Fino/git/PGL2/ESCRIM 2/src/Image/arriere_plan.jpg"));
		lblNewLabel.setBounds(0, 0, 491, 269);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
}
