package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import utilisateur.*;
import view.Groupement;

public class Article implements Groupement, Donnee {
	private String nom;

	public String getNom() {
		return nom;
	}

	private String type;
	private float poids;

	private final Object[] param;

	public Article(String nom, String type, float poids) {
		this.nom = nom;
		this.type = type;
		this.poids = poids;
		this.param = new Object[] { nom, type, poids };
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public String plusDetails() {
		return null;
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

	@Override
	public String[] getNomColonnes() {
		return new String[] { "Nom", "Type", "Poids" };
	}

	@Override
	public String[] getValues() {
		return new String[] { nom, type, Float.toString(poids) };
	}

}
