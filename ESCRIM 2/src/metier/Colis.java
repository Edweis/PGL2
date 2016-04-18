package metier;

import java.util.ArrayList;
import java.util.Stack;

import utilisateur.Donnee;
import view.Groupement;

public class Colis implements Groupement, Donnee {
	private Dimension dim;
	private ArrayList<Article> articles;
	private int numeroColis;
	public float poids;
	public String observations;
	public String secteur; // Creer une classe ?

	/**
	 * Ajoutés par François
	 */
	public String Affectataire; // Creer une classe ?
	public String Secteur;
	public String Designation; // Creer une classe ?
	public String precision;
	public String volume;

	private Object[] param;

	public Colis(int numerosColis, Dimension dim, ArrayList<Article> articles) {
		this.numeroColis = numerosColis;
		this.dim = dim;
		this.articles = articles;

		param = new Object[] {};
	}
	public Colis(int numerosColis, Dimension dim) {
		this.numeroColis = numerosColis;
		this.dim = dim;
		this.articles = new ArrayList<Article>();
		
		param = new Object[]{};
	}
	public Dimension getDim() {
		return dim;
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	public int getNumerosColis() {
		return numeroColis;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	// A SUPPRIMER DANS LES FUTUR ! c'est juste pour jouer

	public void setInfos(String Affectaire, String Designation, String precision) {
		this.Affectataire = Affectaire;
		this.Designation = Designation;
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
		String res = Affectataire + " - " +
				Integer.toString(numeroColis) + " - " +
				Designation + " - " +
				precision+ " - " + 
				dim.toString();
		return res;
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

}
