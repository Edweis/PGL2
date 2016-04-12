package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import metier.Colis;
import partieMission.GrpColis;

public class AfficheurGrp extends JPanel  implements ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private Colis [] listeColis;  
	private JList<Colis> maListe;
	private JButton selectAll;
	private JButton deselectAll;
	private JButton inverstSelect;

	
	private JLabel text;
	private JLabel zoneDetail;
	private int width = 500;
	private int height = 600;

	public AfficheurGrp() {
		init();
	}

	public AfficheurGrp(String texteInitial) {
		init();
		setText(texteInitial);
	}

	/**
	 * Initilise les variables
	 */
	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(width, height));
		
		//Ajout du text
		text = new JLabel();
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setPreferredSize(new Dimension(width, 20));
		this.add(text);
		
		//Ajout des boutons
		selectAll = new JButton("selectionner tout");
		deselectAll = new JButton("déselectionner tout");
		inverstSelect = new JButton("inverser la selection");
		this.add(selectAll);
		this.add(deselectAll);
		this.add(inverstSelect);
		
	}

	/**
	 * Met à jour les groupements et les affiches
	 * 
	 * @param colis
	 */
	public void MajGrpColis(GrpColis colis) {
		
		if(maListe != null){
			this.remove(maListe);
		}
		
		listeColis = new Colis[colis.size()];
		for (int i = 0 ; i<colis.size(); i++) {
			listeColis[i] = colis.get(i);
		}
		
		maListe = new JList<Colis>(listeColis);
		maListe.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		maListe.setPreferredSize(new Dimension(width, height));
		maListe.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		this.add(maListe);
	}

	/**
	 * renvoie les colis cochés
	 * 
	 * @return les colis cochés
	 */
	public GrpColis Exporter() {
		GrpColis res = new GrpColis();
		
		for(Colis c : maListe.getSelectedValuesList()){
			res.add(c);
		}
		
		return res;
	}

	/**
	 * Change le texte en haut
	 * 
	 * @param nouveauText
	 */
	public void setText(String nouveauText) {
		text.setText(nouveauText);
	}

	/**
	 * Ajoute la zone de lecture qui donne des détails sur la selection
	 * 
	 * @param zoneDetail
	 */
	public void ajouterZoneDetail(JLabel zoneDetail) {
		if(zoneDetail != null){
			this.remove(zoneDetail);
		}
		
		this.zoneDetail = zoneDetail;
		this.add(zoneDetail);
		
		maListe.addListSelectionListener(this);
		
		
	}


	/**
	 * modifie les paramètre de formatage des chaque ligne Si l'on met 0, la
	 * taille de la colonne est ajust automatiquement
	 * 
	 * @param param
	 *            est un tableau d'ntier représentant le nombre de caractère à
	 *            afficher par colonne de chaque ligne
	 */
	public void setAllParamFormat(int[] param) {

		// on calcul la largeur par defaut (quand il y a des 0 dans le
		// parametre)
		int defaut = 0;
		for (int i = 0; i < param.length; i++) {
			defaut += param[i];
		}
		defaut = (int) width / param.length;

		for (int i = 0; i < param.length; i++) {
			if (param[i] == 0) {
				param[i] = defaut;
			}
		}
	}

	public void setWidth(int width) {
		this.width = width;
		this.setPreferredSize(new Dimension(width, height));
	}

	public void setHeight(int height) {
		this.height = height;
		this.setPreferredSize(new Dimension(width, height));
	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		zoneDetail.setText(maListe.getSelectedValue().details());
	}
}
