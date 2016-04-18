package partieMission;

public class Stockpris {
 
	int quantite_prise;
	Stock stock;
	
	public Stockpris(Stock stock, int quantite_prise){
		this.stock=stock;
		stock.setQuantite(stock.getQuantite()-quantite_prise);
		this.quantite_prise=quantite_prise;
	}
}
