package partieMission.configs;

import view.Groupement;

public class Configuration implements Groupement {
	
	String nom;
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Configuration(String nom){
		this.nom = nom;
	}

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
