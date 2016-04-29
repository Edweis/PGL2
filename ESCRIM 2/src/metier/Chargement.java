package metier;

/*
 * Associe une position pour chaque boite à chaque conteneur de chaque avion
 */
public class Chargement {
	private GrpAvions ensAvions;
	private GrpColis ensColis;
	//variable associant les boites aux avions � une position pr�cise
	
	public Chargement(GrpAvions avions, GrpColis colis) {
		ensAvions = avions;
		ensColis = colis;
		avions.addChargement(this);
	}
	
}
