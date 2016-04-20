package partieMission;

import metier.Article;
import java.util.Date;
import utilisateur.Donnee;

public class Stock implements Donnee{

	private int quantite_dispo;
	private Date date;
	private 	Article article;
	private Object[] param;
	
	
	public Stock(Date date,int quantite_dispo, Article article){
		this.quantite_dispo=quantite_dispo;
		this.date=date;
		this.article=article;	
		
		param = new Object[]{date, quantite_dispo, article};
	}
	
	
	public int getQuantite() {
		return quantite_dispo;
	}

	public void setQuantite(int quantite) {
		this.quantite_dispo = quantite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	@Override
	public Object[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}
}
