package metier;

import java.util.ArrayList;
import java.util.Stack;

import partieMission.GrpStock;
import utilisateur.Donnee;
import view.Groupement;

public class Colis implements Groupement, Donnee {

	private int numeroColis;
	public int getNumeroColis() {
		return numeroColis;
	}

	private Dimension dim;
	private ArrayList<Article> articles;
	private float poids;
	private String observations;
	private String secteur;
	private String affectataire;
	private String designation;
	private String precision;
	private GrpStock grpstock;

	private Object[] param;

	public Colis(int numeroColis, Dimension dim, ArrayList<Article> articles, float poids, String observations,
			String secteur, String affectataire, String designation, String precision, GrpStock grpstock) {

		this.numeroColis = numeroColis;
		this.dim = dim;
		this.articles = articles;
		this.poids = poids;
		this.observations = observations;
		this.secteur = secteur;
		this.affectataire = affectataire;
		this.designation = designation;
		this.precision = precision;
		this.grpstock=grpstock;
		
		param = new Object[] { numeroColis, dim, articles, poids, observations, secteur, affectataire, designation,
				precision };
	}

	// A SUPPRIMER DANS LES FUTUR ! c'est juste pour jouer

	public void setInfos(String affectaire, String designation, String precision) {
		this.affectataire = affectaire;
		this.designation = designation;
		this.precision = precision;
	}

	// Implemented methods

	public String plusDetails() {
		String res = "<html>";
		res = res + "blabalbalablalbal <br>" + "blabalbalbal <br>" + "blabalbalablapùmlbal <br>";
		res = res + "</html>";
		return res;
	}

	@Override
	public String [] getValues() {
		String [] res = new String[]{
			Integer.toString(numeroColis),
			secteur, 
			observations,
			affectataire, 
			designation,
			Float.toString(poids)
		};
		return res;
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

	@Override
	public String[] getNomColonnes() {
		return new String[]{
		"#",
		"Secteur",
		"Observations",
		"Affectataire",
		"Designation",
		"Poids"
		};
	}

}
