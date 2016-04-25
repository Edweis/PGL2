package metier;


import view.Groupement;

public class Avion implements Donnee, Groupement {
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

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

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

	@Override
	public String plusDetails() {
		// TODO Auto-generated method stub
		return null;
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
