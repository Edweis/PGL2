package metier;

import utilisateur.Donnee;
import view.Groupement;

public class Stock implements Groupement, Donnee{
	
	private String date;
	private int quantite;
	private final Object[] param;

	public Stock(String date, int quantite){
		this.date = date;
		this.quantite = quantite;
		this.param = new Object[] {date, quantite};
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Object[] getParameters() {
		return param;
	}
	@Override
	public String plusDetails() {
		return "Quantitée: " + Integer.toString(quantite) + " | Date: " + date;
	}
	@Override
	public String[] getNomColonnes() {
		return new String[] {"date","quantitée"};
	}
	@Override
	public String[] getValues() {
		return new String[] {date, Integer.toString(quantite)};
	}
	
}
