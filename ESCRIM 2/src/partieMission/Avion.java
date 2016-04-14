package partieMission;

import view.Groupement;

public class Avion implements Groupement{
	private String nom;
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public long getVolume() {
		return volume;
	}


	public void setVolume(long volume) {
		this.volume = volume;
	}


	public String getCaracteristiques() {
		return caracteristiques;
	}


	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}


	public String getImmatriculation() {
		return immatriculation;
	}


	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


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
