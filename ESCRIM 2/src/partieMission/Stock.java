package partieMission;

import sun.util.calendar.BaseCalendar.Date;

public class Stock {

	int quantite_dispo;
	Date date;
	Article article;
	
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

	public Stock(Article article,int quantite_dispo,Date date){
		this.quantite_dispo=quantite_dispo;
		this.date=date;
		this.article=article;	
	}
}
