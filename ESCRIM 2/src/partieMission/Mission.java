package partieMission;

import utilisateur.Donnee;
import view.Groupement;

public class Mission implements Groupement, Donnee {
	String nom;
	CaracMission caracteristiques;
	GrpAvions ensAvions;
	GrpColis ensColis;

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
}
