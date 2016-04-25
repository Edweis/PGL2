package view;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controleur.Controleur_Avion;
import metier.Avion;
import metier.utilisateur.Utilisateur;

public class I_Avion {

	Utilisateur utilisateur;
	
	public void run() {
		try {
			I_Avion window = new I_Avion(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public I_Avion(Utilisateur utilisateur) throws SQLException {
		this.utilisateur= utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		Vue.getInstance().vider();
		JLabel lblAvionExistant = new JLabel("AVIONS EXISTANTS");
		lblAvionExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAvionExistant.setBounds(44, 21, 377, 102);
		Vue.getInstance().getContentPane().add(lblAvionExistant);
		
		
		/*Bdd_utilisateur.connecter("root","");
		ResultSet dernierID = Bdd_utilisateur.lecture("SELECT LAST(id_avion) FROM avion");
		int val =  ((Number) dernierID.getObject(1)).intValue();
				
		ArrayList<Avion> avi = new ArrayList<>();
		for (int i=1;i<val;i++){
			String requete="SELECT * FROM avion WHERE id_avion=="+i;
			ResultSet Avi = Bdd_utilisateur.lecture(requete);
			String nomAv = Avi.getString("nom");
			Long volumeAv = Avi.getLong("volume");
			String caracv = Avi.getString("caracteristiques");
			String immaAv = Avi.getString("immatriculation");
			Avion unAvion = new Avion(nomAv,volumeAv,caracv,immaAv);
			avi.set(i,unAvion);			
		}*/
					
		AfficheurGrp<Avion> afficheur = new AfficheurGrp<Avion>();
		//afficheur.MajGrpColis(avi);
		Vue.getInstance().getContentPane().add(afficheur);

		
		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 100, 250,50);
		Vue.getInstance().getContentPane().add(btnVoirCaracteristique);
		
		afficheur.activeOnSelect(btnVoirCaracteristique);
		
		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 170,  250,50);
		Vue.getInstance().getContentPane().add(btnCreerNouvelle);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(602, 380,  250,50);
		Vue.getInstance().getContentPane().add(btnRetour);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(602, 240, 250,50);
		Vue.getInstance().getContentPane().add(btnModifier);
		
		afficheur.activeOnSelect(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 310,  250,50);
		Vue.getInstance().getContentPane().add(btnSupprimer);
		
		afficheur.activeOnSelect(btnSupprimer);
		
		Controleur_Avion  e3 = new Controleur_Avion (utilisateur, afficheur,this);
		btnVoirCaracteristique.addActionListener(e3);
		btnCreerNouvelle.addActionListener(e3);
		btnRetour.addActionListener(e3);
		btnModifier.addActionListener(e3);
		btnSupprimer.addActionListener(e3);
		Vue.getInstance().finitions();

	}
}

