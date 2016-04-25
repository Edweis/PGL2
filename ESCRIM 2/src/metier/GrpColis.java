package metier;


import java.util.ArrayList;
import java.util.Iterator;

public class GrpColis implements Donnee, Iterable<Colis>{
	ArrayList<Colis> ensColis;
	
	private Object[] param;
	
	public GrpColis(){
		ensColis = new ArrayList<Colis>();
		param = new Object[]{};
	}
	
	

	
	
	
	//Fonction sur ArrayList
	
	public void add(Colis colis) {
		ensColis.add(colis);
	}

	public void remove(Colis Colis){
		ensColis.remove(Colis);
	}
	
	public Colis get(int index) {
		return ensColis.get(index);
	}

	public Iterator<Colis> iterator() {
		return ensColis.iterator();
	}

	public int size(){
		return ensColis.size();
	}

	public ArrayList<Colis> getColis(){
		return ensColis;
	}
	
	@Override
	public Object[] getParameters() {
		return param;
	}
}
