package partieMission;

import java.util.ArrayList;
import java.util.Iterator;

import utilisateur.Donnee;

public class GrpAvions implements Iterable<Avion>, Donnee {
	private ArrayList<Avion> ensAvion;
	private Chargement chargement;
	
	private Object[] param;

	public GrpAvions() {
		ensAvion = new ArrayList<Avion>();

		param = new Object[]{};
	}

	/**
	 * Ajoute le chargement au groupe d'avion. Cette méthode est appellée par
	 * Chargement dans son constructeur
	 * 
	 * @param le
	 *            chargement
	 */
	public void addChargement(Chargement chargement) {
		this.chargement = chargement;
	}

	
	
	
	
	
	//Fonction sur ArrayList
	public void add(Avion avion) {
		ensAvion.add(avion);
	}

	public void remove(Avion avion){
		ensAvion.remove(avion);
	}
	public Avion get(int index) {
		return ensAvion.get(index);
	}

	public Iterator<Avion> iterator() {
		return ensAvion.iterator();
	}

	@Override
	public Object[] getParameters() {
		return param;
	}

}
