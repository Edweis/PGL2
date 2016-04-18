package view;

/**
 * Permet d'afficher l'objet dans AfficheurGrp
 * @author piou
 *
 */
public interface Groupement {
	
	
	/**
	 * Permet d'afficher les valeurs a renseigner dans une ligne d'un AfficheurGrp
	 * @return
	 */
	public String plusDetails();
	public String [] getNomColonnes();
	public String [] getValues();
}

