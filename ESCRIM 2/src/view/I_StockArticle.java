package view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controleur.Controleur_StockArticle;
import metier.Article;
import metier.Stock;
import metier.utilisateur.Utilisateur;

public class I_StockArticle {
	private Utilisateur utilisateur;
	private Controleur_StockArticle controleur;
	private Article selection;
	private JFrame frame;
	private JTextField quantite;
	private JTextField date;
	private AfficheurGrp<Stock> afficheur;

	public void run() throws Throwable {
		try {
			I_Article window = new I_Article(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public I_StockArticle(Utilisateur utilisateur, Article selection) throws Throwable {
		this.selection = selection;
		this.utilisateur = utilisateur;
		this.afficheur = new AfficheurGrp<Stock>("test");
		this.controleur = new Controleur_StockArticle(utilisateur, this);
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

		JLabel lblArticleExistant = new JLabel("Stock de l'article " + selection.getNom());
		lblArticleExistant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblArticleExistant.setBounds(44, 21, 377, 102);
		Vue.getInstance().getContentPane().add(lblArticleExistant);

		Stock art1 = new Stock("test1", 0);
		Stock art2 = new Stock("test1", 0);
		
		ArrayList<Stock> test = new ArrayList<Stock>();
		test.add(art1);
		test.add(art2);
		
		afficheur.MajGrpColis(test);
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

		btnCreerNouvelle.addActionListener(controleur);
		btnRetour.addActionListener(controleur);
		btnModifier.addActionListener(controleur);
		btnSupprimer.addActionListener(controleur);

		Vue.getInstance().finitions();
	}

	public void creerNouveau() {
		JLabel label = new JLabel("Cr�er Nouveau");
		date = new JTextField();
		quantite = new JTextField();
		edition(label);
	}
	
	public void modifier() {
		JLabel label = new JLabel("Modifier");
		date = new JTextField();
		quantite = new JTextField();
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
		
		JLabel lbldate = new JLabel("Nouvelle date");
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldate.setBounds(82, 127, 115, 26);
		frame.getContentPane().add(lbldate);
		
		JLabel lblquantite = new JLabel("Nouvelle quantit�e");
		lblquantite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblquantite.setBounds(82, 203, 115, 26);
		frame.getContentPane().add(lblquantite);
				
		
		date.setBounds(234, 127, 120, 31);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
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

	public String getDate() {
		return date.getText();
	}

	public int getQuantite() {
		return Integer.parseInt(quantite.getText());
	}
	

	public void fermerFrame() {
		this.frame.setVisible(false);
		;
	}
}
