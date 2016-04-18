package partieMission.configs;

import utilisateur.Donnee;
import view.Groupement;

public class Configuration implements Groupement, Donnee {
	
	
	
	private String nom;
	private Object [] param;
	
	
	public Configuration(String nom){
		this.nom = nom;
		
		param = new Object[]{nom}; 
		
	}
	
	public String getNom() {
		return nom;
	}


	public String getInfos() {
		return nom;
	}

	@Override
	public String plusDetails() {
		return nom;
	}

	@Override
	public Object[] getParameters() {
return param;
		}

}
