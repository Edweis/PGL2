package partieMission;

<<<<<<< HEAD
import utilisateur.Donnee;

public class Mission implements Donnee {
=======
import view.Groupement;

public class Mission implements Groupement {
	String nom;
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CaracMission getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(CaracMission caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public GrpAvions getEnsAvions() {
		return ensAvions;
	}

	public void setEnsAvions(GrpAvions ensAvions) {
		this.ensAvions = ensAvions;
	}

	public GrpColis getEnsColis() {
		return ensColis;
	}

	public void setEnsColis(GrpColis ensColis) {
		this.ensColis = ensColis;
	}

>>>>>>> branch 'master' of https://github.com/Edweis/PGL2.git
	CaracMission caracteristiques;
	GrpAvions ensAvions;
	GrpColis ensColis;
	
	private Object[] param;
	
	public Mission(String nom, CaracMission carac, GrpAvions avions, GrpColis colis){
		this.nom = nom;
		caracteristiques = carac;
		ensAvions = avions;
		ensColis = colis;
	}
<<<<<<< HEAD
	@Override
	public Object[] getParameters() {
		return param;
=======

	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String plusDetails() {
		// TODO Auto-generated method stub
		return null;
>>>>>>> branch 'master' of https://github.com/Edweis/PGL2.git
	}
}
