package view;
import utilisateur.*;
import java.awt.EventQueue;

import javax.swing.JFrame;

import utilisateur.Utilisateur;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JList;
import javax.swing.JButton;

public class I_Mission {

	private JFrame frame;

	
	public void run() {
		try {
			I_Mission window = new I_Mission();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Mission() throws SQLException {

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
		
		JLabel lblMissionPrecedente = new JLabel("MISSION PRECEDENTE");
		lblMissionPrecedente.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMissionPrecedente.setBounds(44, 21, 377, 102);
		frame.getContentPane().add(lblMissionPrecedente);
		
		JList list = new JList();
		Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_mission) FROM mission");
		int val =  ((Number) dernierID.getObject(1)).intValue();
		String[] mission = new String[val];
		for (int i=1;i<val;i++){
			
			
		}
		list.setBounds(44, 113, 364, 380);
		list.setLayoutOrientation(JList.VERTICAL);
		frame.getContentPane().add(list);
		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 101, 229, 40);
		frame.getContentPane().add(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVELLE");
		btnCreerNouvelle.setBounds(602, 173, 229, 40);
		frame.getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(803, 470, 89, 23);
		frame.getContentPane().add(btnRetour);
	}
}
