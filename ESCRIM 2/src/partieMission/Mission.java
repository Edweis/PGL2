package partieMission;

import utilisateur.Donnee;

public class Mission implements Donnee {
	CaracMission caracteristiques;
	GrpAvions ensAvions;
	GrpColis ensColis;
	
	private Object[] param;
	
	public Mission(CaracMission carac, GrpAvions avions, GrpColis colis){
		caracteristiques = carac;
		ensAvions = avions;
		ensColis = colis;
	}
	@Override
	public Object[] getParameters() {
		return param;
	}
}
