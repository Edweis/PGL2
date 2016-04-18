package partieMission;

import utilisateur.Donnee;
import view.Groupement;

public class Mission implements Groupement, Donnee {
	private String nom;
	private CaracMission caracteristiques;
	private GrpAvions ensAvions;
	private GrpColis ensColis;

	private Object[] param;

	public Mission(String nom, CaracMission carac, GrpAvions avions, GrpColis colis) {
		this.nom = nom;
		caracteristiques = carac;
		ensAvions = avions;
		ensColis = colis;
		
		param = new Object[]{nom, carac, avions, colis};
		
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

	@Override
	public String plusDetails() {
		// TODO Auto-generated method stub
		return null;
	}

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
	
}
