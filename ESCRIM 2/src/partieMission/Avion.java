package partieMission;

import view.Groupement;

public class Avion implements Groupement{
	private String nom;
	private long volume;
	private String caracteristiques;
	private String immatriculation;
	
	
	public Avion(String nom, long volume, String caracteristiques, String immatriculation) {
		this.nom = nom;
		this.volume = volume;
		this.caracteristiques = caracteristiques;
		this.immatriculation = immatriculation;
	}


	@Override
	public String getInfos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String plusDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
