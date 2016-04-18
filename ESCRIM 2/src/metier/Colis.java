package metier;

import java.util.ArrayList;
import java.util.Stack;

import utilisateur.Donnee;
import view.Groupement;

public class Colis implements Groupement, Donnee {

	private int numeroColis;
	private Dimension dim;
	private ArrayList<Article> articles;
	private float poids;
	private String observations;
	private String secteur;
	private String affectataire;
	private String designation;
	private String precision;

	private Object[] param;

	public Colis(int numeroColis, Dimension dim, ArrayList<Article> articles, float poids, String observations,
			String secteur, String affectataire, String designation, String precision) {

		this.numeroColis = numeroColis;
		this.dim = dim;
		this.articles = articles;
		this.poids = poids;
		this.observations = observations;
		this.secteur = secteur;
		this.affectataire = affectataire;
		this.designation = designation;
		this.precision = precision;

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

	public String toString() {
		// String[] res = { Affectataire, Integer.toString(numeroColis),
		// Designation, precision, dim.toString() };
		String res = affectataire + " - " + Integer.toString(numeroColis) + " - " + designation + " - " + precision
				+ " - " + dim.toString();
		return res;
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

}
