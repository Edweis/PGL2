package partieMission;

public class Article {
private String nom;
private String type;
private Float poids;
	
	public Article(String nom,String type, Float poids){
		this.setNom(nom);
		this.setType(type);
		this.setPoids(poids);
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}
}
