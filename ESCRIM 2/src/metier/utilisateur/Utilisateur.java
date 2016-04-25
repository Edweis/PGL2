package metier.utilisateur;


import metier.Donnee;
import view.Groupement;

public class Utilisateur implements Groupement, Donnee {

	String prenom;
	String nom;
	String mdp;
	Boolean droit_modifier;
	Boolean droit_lecture;
	String grade;
	
	private final Object [] param;

	public Utilisateur(String nom, String prenom, String mdp, Boolean droit_modifier, Boolean droit_lecture,
			String grade) {
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.droit_lecture = droit_lecture;
		this.droit_modifier = droit_modifier;
		this.grade = grade;

		param = new Object[]{nom, prenom, mdp, droit_lecture, droit_modifier, grade};
	}

	@Override
	public Object[] getParameters() {
		return param;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String plusDetails() {
		return nom + " qs fsd f sdfqsdf f sf\n qsdf qsdfbsjf \n \n qfqsdfqsbdf ";
	}

	@Override
	public String[] getNomColonnes() {
		return new String[]{"Nom", "Prénom", "Droit de lecture", "Bite"};
	}

	@Override
	public String[] getValues() {
		return new String[]{nom, prenom, Boolean.toString(droit_lecture), "Lol"};
}
}
