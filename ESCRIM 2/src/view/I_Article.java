package view;
import utilisateur.*;
import java.awt.EventQueue;
import metier.Article;
import javax.swing.JFrame;

import utilisateur.Utilisateur;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class I_Article {

	private JFrame frame;

	
	public void run() {
		try {
			I_Article window = new I_Article();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Article() throws SQLException {

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
		
		JLabel lblMissionPrecedente = new JLabel("ARTICLE EXISTANT");
		lblMissionPrecedente.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMissionPrecedente.setBounds(44, 21, 377, 102);
		frame.getContentPane().add(lblMissionPrecedente);
		
		JList list = new JList();
		Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_article) FROM article");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		Article[] art = new Article[val];
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM article WHERE id_article=="+i;
			ResultSet Art = Bdd_utilisateur.lecture(requete);
			String nomArt = Art.getString("nom");
			String typeArt = Art.getString("type");
			Article unArticle = new Article(nomArt,typeArt);
			art[i]= unArticle;			
		}
					
		list.setBounds(44, 113, 364, 380);
		list.setLayoutOrientation(JList.VERTICAL);
		frame.getContentPane().add(list);
		
		
		
		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 101, 229, 40);
		frame.getContentPane().add(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 173, 229, 40);
		frame.getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(803, 470, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifier.setBounds(602, 242, 229, 33);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 311, 229, 40);
		frame.getContentPane().add(btnSupprimer);
		
		JButton btnGererStock = new JButton("GERER STOCK");
		btnGererStock.setBounds(602, 374, 229, 40);
		frame.getContentPane().add(btnGererStock);
	}
}