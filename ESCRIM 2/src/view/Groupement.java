package view;

/**
 * Permet d'afficher l'objet dans AfficheurGrp
 */
public interface Groupement {
	
	
	/**
	 * Permet d'afficher les valeurs a renseigner dans une ligne d'un AfficheurGrp
	 * @return
	 */
	public String plusDetails();
	/*
	 * Retourne les nom des en têtes à afficher dans l'AfficheurGrp
	 */
	public String [] getNomColonnes();
	/*
	 * Retourne les valeurs associées aux en têtes 
	 */
	public String [] getValues();
}

