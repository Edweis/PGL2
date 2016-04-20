package partieMission.configs;

import utilisateur.Donnee;
import view.Groupement;

import java.util.ArrayList;

import metier.Colis;

public class Configuration implements Groupement, Donnee {

	private String nom;
	private String observation;
	private ArrayList<Colis> groupeColis;
	private final Object[] param;

	public Configuration(String nom, String observation, ArrayList<Colis> groupeColis) {
		this.nom = nom;
		this.observation = observation;
		this.groupeColis = groupeColis;
		this.param = new Object[] {nom, observation, groupeColis};
	}

	public void addColis(Configuration config, Colis c) {
		config.groupeColis.add(c);
	}

	public void removeColis(Configuration config, Colis c) {
		config.groupeColis.remove(c);
	}

	public void modifierObs(Configuration config, String s) {
		config.observation = s;
	}

	public String getNom() {
		return nom;
	}


	@Override
	public String plusDetails() {
		return observation;
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

	@Override
	public String[] getNomColonnes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getValues() {
		// TODO Auto-generated method stub
		return null;
	}

}
