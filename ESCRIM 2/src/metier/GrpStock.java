package metier;


import java.util.ArrayList;

public class GrpStock {

	ArrayList<Stockpris> contenu_stock = new ArrayList<Stockpris>();
	
	public GrpStock(){	
	}
	
	public void ajouter_colis(Stockpris stockpris){
		contenu_stock.add(stockpris);
	}
	
}
