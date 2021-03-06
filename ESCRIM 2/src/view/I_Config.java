package view;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controleur.Controleur_Configuration;
import metier.Article;
import metier.GrpColis;
import metier.configs.Configuration;
import metier.utilisateur.Utilisateur;

public class I_Config {


	private Utilisateur utilisateur;
	private Controleur_Configuration controleur;
	private JFrame frame;
	private JTextField nom;
	private JTextField observations;
	private AfficheurGrp<Configuration> afficheur;
	

	public void run() throws Throwable {
		try {
			I_Config window = new I_Config(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public I_Config(Utilisateur utilisateur) throws Throwable {
		this.utilisateur = utilisateur;
		this.afficheur = new AfficheurGrp<Configuration>("test");
		this.controleur = new Controleur_Configuration(utilisateur, this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {

		Vue.getInstance().vider();

		// LanceRequete<Article> bdd = new LanceRequete<Article>(Article.class);

		JLabel lblArticleExistant = new JLabel("ARTICLES EXISTANTS");
		lblArticleExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblArticleExistant.setBounds(44, 21, 377, 102);
		Vue.getInstance().getContentPane().add(lblArticleExistant);

		GrpColis test = new GrpColis();
		
		Configuration art1 = new Configuration("test1","observation", null);
		Configuration art2 = new Configuration("test2", "Gay", null);
		
		ArrayList<Configuration> test2 = new ArrayList<Configuration>();
		test2.add(art1);
		test2.add(art2);
		
		afficheur.MajGrpColis(test2);
		afficheur.setBounds(50,100,500,500);
		Vue.getInstance().getContentPane().add(afficheur);

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
		
		afficheur.activeOnSelect(btnGererStock);
		
		btnCreerNouvelle.addActionListener(controleur);
		btnRetour.addActionListener(controleur);
		btnModifier.addActionListener(controleur);
		btnSupprimer.addActionListener(controleur);
		btnGererStock.addActionListener(controleur);

		Vue.getInstance().finitions();
	}

	public void creerNouveau() {
		JLabel label = new JLabel("Cr�er Nouveau");
		nom = new JTextField();
		poids = new JTextField();
		edition(label);
	}
	
	public void modifier() {
		JLabel label = new JLabel("Modifier");
		nom = new JTextField();
		poids = new JTextField();
		edition(label);
	}
	
	public void edition(JLabel label){
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel lblEcran = new JLabel();
		lblEcran.setBounds(917, 104, -845, 410);
		frame.getContentPane().add(lblEcran);
		
		label.setFont(new Font("Tahoma", Font.BOLD, 35));
		label.setBounds(100, 11, 278, 69);
		frame.getContentPane().add(label);
		
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
		
		
		nom.setBounds(234, 127, 120, 31);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		
		poids.setBounds(234, 273, 110, 31);
		frame.getContentPane().add(poids);
		poids.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(234, 203, 120, 26);	
		comboBox.addItem("Medicament");
		comboBox.addItem("Materiel");
		frame.getContentPane().add(comboBox);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(70, 350, 127, 41);
		frame.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(230, 350, 127, 41);
		frame.getContentPane().add(btnAnnuler);

		btnValider.addActionListener(controleur);
		btnAnnuler.addActionListener(controleur);
		
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);

	}

	public String getNom() {
		return nom.getText();
	}

	public String getType() {
		return type.getText();
	}

	public float getPoids() {
		return Float.parseFloat(poids.getText());
	}
	
	public AfficheurGrp<Article> getAfficheur(){
		return afficheur;
	}

	public void fermerFrame() {
		this.frame.setVisible(false);
		;
	}
}

