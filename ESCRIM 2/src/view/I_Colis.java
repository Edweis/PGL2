package view;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controleur.Controleur_Colis;
import metier.Colis;
import metier.utilisateur.Utilisateur;

public class I_Colis {

	Utilisateur utilisateur;

	public void run() {
		try {
			I_Colis window = new I_Colis(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public I_Colis(Utilisateur utilisateur) throws SQLException {
		this.utilisateur = utilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
		Vue.getInstance().vider();
		// LanceRequete<Article> bdd = new LanceRequete<Article>(Article.class);

		JLabel lblColisExistant = new JLabel("COLIS EXISTANTS");
		lblColisExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblColisExistant.setBounds(44, 21, 377, 102);
		Vue.getInstance().getContentPane().add(lblColisExistant);

		/*
		 * Bdd_utilisateur.connecter("root",""); ResultSet dernierID =
		 * Bdd_utilisateur.lecture("SELECT LAST(id_colis) FROM colis"); int val
		 * = ((Number) dernierID.getObject(1)).intValue();
		 * 
		 * ArrayList<Colis> col = new ArrayList<>(); for (int i=1;i<val;i++){
		 * String requete="SELECT * FROM colis WHERE id_colis=="+i; ResultSet
		 * Col = Bdd_utilisateur.lecture(requete); Dimension dimColis =
		 * (Dimension) Col.getObject("dim"); int numColis =
		 * Col.getInt("numerosColis"); Colis unColis = new
		 * Colis(numColis,dimColis); col.set(i,unColis); }
		 */

		AfficheurGrp<Colis> afficheur = new AfficheurGrp<Colis>();
		// afficheur.MajGrpColis(col);
		Vue.getInstance().getContentPane().add(afficheur);

		JButton btnVoirCaracteristique = new JButton("VOIR CARACTERISTIQUE");
		btnVoirCaracteristique.setBounds(602, 100, 250, 50);
		Vue.getInstance().getContentPane().add(btnVoirCaracteristique);

		afficheur.activeOnSelect(btnVoirCaracteristique);

		JButton btnCreerNouvelle = new JButton("CREER NOUVEAU");
		btnCreerNouvelle.setBounds(602, 170, 250, 50);
		Vue.getInstance().getContentPane().add(btnCreerNouvelle);

		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(602, 450, 250, 50);
		Vue.getInstance().getContentPane().add(btnRetour);

		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(602, 240, 250, 50);
		Vue.getInstance().getContentPane().add(btnModifier);

		afficheur.activeOnSelect(btnModifier);

		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(602, 310, 250, 50);
		Vue.getInstance().getContentPane().add(btnSupprimer);

		afficheur.activeOnSelect(btnSupprimer);

		JButton btnGererStock = new JButton("GERER STOCK");
		btnGererStock.setBounds(602, 380, 250, 50);
		Vue.getInstance().getContentPane().add(btnGererStock);

		Controleur_Colis e2 = new Controleur_Colis(utilisateur, afficheur, this);
		btnVoirCaracteristique.addActionListener(e2);
		btnCreerNouvelle.addActionListener(e2);
		btnRetour.addActionListener(e2);
		btnModifier.addActionListener(e2);
		btnSupprimer.addActionListener(e2);
		btnGererStock.addActionListener(e2);

		Vue.getInstance().finitions();

	}

}
