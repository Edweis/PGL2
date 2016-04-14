package utilisateur;

public class Utilisateur implements Donnee {

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
}
