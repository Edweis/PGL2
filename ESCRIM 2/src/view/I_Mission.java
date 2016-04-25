package view;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controleur.Controleur_Mission;
import metier.Mission;
import metier.utilisateur.Utilisateur;

public class I_Mission {

	Utilisateur utilisateur;
	
	public void run() {
		try {
			I_Mission window = new I_Mission(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public I_Mission(Utilisateur utilisateur) throws SQLException {
		
		this.utilisateur= utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		Vue.getInstance().vider();
		JLabel lblMissionExistant = new JLabel("MISSIONS EXISTANTES");
		lblMissionExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMissionExistant.setBounds(44, 21, 377, 102);
		Vue.getInstance().getContentPane().add(lblMissionExistant);
		
		
		/*Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_mission) FROM mission");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		ArrayList<Mission> mis = new ArrayList<>();
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM mission WHERE id_mission=="+i;
			ResultSet Mis = Bdd_utilisateur.lecture(requete);
			String nomMis = Mis.getString("nom");
			CaracMission caracMis = (CaracMission) Mis.getObject("caracteristiques");
			GrpAvions ensAvionsMis = (GrpAvions) Mis.getObject("ensAvions");
			GrpColis ensColisMis = (GrpColis) Mis.getObject("ensColis");;;
			Mission uneMis = new Mission(nomMis,caracMis,ensAvionsMis,ensColisMis);
			mis.set(i,uneMis);			
		}*/
					
		AfficheurGrp<Mission> afficheur = new AfficheurGrp<Mission>();
		//afficheur.MajGrpColis(mis);
		Vue.getInstance().getContentPane().add(afficheur);

		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 100, 250, 50);
		Vue.getInstance().getContentPane().add(btnVoirCaracteristique);
		
		afficheur.activeOnSelect(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 170, 250, 50);
		Vue.getInstance().getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(602, 380, 250, 50);
		Vue.getInstance().getContentPane().add(btnRetour);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(602, 240, 250, 50);
		Vue.getInstance().getContentPane().add(btnModifier);
		
		afficheur.activeOnSelect(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 310, 250, 50);
		Vue.getInstance().getContentPane().add(btnSupprimer);
		
		afficheur.activeOnSelect(btnSupprimer);
		
		Controleur_Mission  e5 = new Controleur_Mission (utilisateur, afficheur,this);
		btnVoirCaracteristique.addActionListener(e5);
		btnCreerNouvelle.addActionListener(e5);
		btnRetour.addActionListener(e5);
		btnModifier.addActionListener(e5);
		btnSupprimer.addActionListener(e5);
		
		Vue.getInstance().finitions();
	}
}