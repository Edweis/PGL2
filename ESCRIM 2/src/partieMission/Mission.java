package partieMission;

import java.util.Date;

import utilisateur.Donnee;
import view.Groupement;

public class Mission implements Groupement, Donnee {
	private String nom;
	public String getNom() {
		return nom;
	}

	private GrpAvions ensAvions;
	private GrpColis ensColis;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;
	private String nomMission;
	private String description;

	private Object[] param;

	public Mission(String nom, GrpAvions ensAvions, GrpColis ensColis, Date dateDebut, Date dateFin, String lieu,
			String nomMission, String description) {

		this.nom = nom;
		this.ensAvions = ensAvions;
		this.ensColis = ensColis;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
		this.nomMission = nomMission;
		this.description = description;

		param = new Object[] { nom, ensAvions, ensColis, dateDebut, dateFin, lieu, nomMission, description };

	}

	@Override
	public String[] getNomColonnes() {
		return null;
	}

	@Override
	public String[] getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

	@Override
	public String plusDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
