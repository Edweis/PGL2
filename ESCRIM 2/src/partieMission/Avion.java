package partieMission;

import utilisateur.Donnee;

public class Avion implements Donnee {
	private String nom;
	private long volume;
	private String caracteristiques;
	private String immatriculation;

	private Object[] param;

	public Avion(String nom, long volume, String caracteristiques, String immatriculation) {
		this.nom = nom;
		this.volume = volume;
		this.caracteristiques = caracteristiques;
		this.immatriculation = immatriculation;
		
		param = new Object[]{nom, volume, caracteristiques, immatriculation};
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

}
