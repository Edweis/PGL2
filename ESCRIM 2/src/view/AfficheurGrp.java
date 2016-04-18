package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AfficheurGrp<E extends Groupement> extends JPanel implements ListSelectionListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<E> listeElement;
	// private JList<E> maJListe;
	private JTable maJTable;

	// Boutons
	private JButton selectAll;
	private JButton deselectAll;
	private JButton inverstSelect;

	private ArrayList<JButton> btnActiveOnSelect;
	private int typeDeSelection;

	private JLabel text;
	private JLabel zoneDetail;
	private int width = 500;
	private int height = 600;
	private ArrayList<E> elements;

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
		btnActiveOnSelect = new ArrayList<JButton>();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(width, height));
		typeDeSelection = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;

		// Ajout du text
		text = new JLabel();
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setPreferredSize(new Dimension(width, 20));
		this.add(text);

		// Ajout des boutons
		selectAll = new JButton("selectionner tout");
		deselectAll = new JButton("déselectionner tout");
		inverstSelect = new JButton("inverser la selection");
		selectAll.addActionListener(this);
		// deselectAll.addActionListener(this);
		// inverstSelect.addActionListener(this);

		this.add(selectAll);
<<<<<<< HEAD
		// this.add(deselectAll);
		// this.add(inverstSelect);

		maJTable = new JTable();
=======
			//this.add(deselectAll);
			//this.add(inverstSelect);
		
		maJListe = new JList<E>();
>>>>>>> branch 'master' of https://github.com/Edweis/PGL2.git

	}

	/**
	 * Met à jour les groupements et les affiches
	 * 
	 * @param colis
	 */
	public void MajGrpColis(ArrayList<E> desElements) {
		elements = desElements;

		if (maJTable != null) {
			this.remove(maJTable);
		}

		listeElement = new DefaultListModel<E>();

		for (E e : desElements) {
			listeElement.addElement(e);
		}

		// Création des données
		int nbCol = desElements.get(0).getNomColonnes().length;
		int nbLig = desElements.size();
		String[][] values = new String[nbLig][nbCol];
		for (int i = 0; i < nbLig; i++) {
			values[i] = desElements.get(i).getValues();
		}

		maJTable = new JTable(values, desElements.get(0).getNomColonnes()){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col)
		    {
		        return false;
		    }
		};

		maJTable.setSelectionMode(typeDeSelection);
		maJTable.setPreferredSize(new Dimension(width, height));

		this.add(maJTable);
	}

	/**
	 * renvoie les colis cochés
	 * 
	 * @return les colis cochés
	 */
	public ArrayList<E> ExporterSelection() {
		ArrayList<E> res = new ArrayList<E>();

		for (int i : maJTable.getSelectedColumns()) {
			res.add(elements.get(i));
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
		if (zoneDetail != null) {
			this.remove(zoneDetail);
		}

		this.zoneDetail = zoneDetail;
		this.add(zoneDetail);

		maJTable.getSelectionModel().addListSelectionListener(this);
	}

	/**
	 * Modifie les paramètre de formatage des chaque ligne Si l'on met 0, la
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

	/**
	 * Ajoute des boutons qui sont enable lorsqu'il y a quelque chose de
	 * selectionné. ils sont déselectionné sinon.
	 * 
	 * @param btn
	 */
	public void activeOnSelect(JButton btn) {
		if (maJTable.getSelectedColumns().length == 0) {
			btn.setEnabled(false);
		} else {
			btn.setEnabled(true);
		}

		btnActiveOnSelect.add(btn);
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
	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();

		switch (btn.getText()) {
		case "selectionner tout":

			int[] toSelect = new int[listeElement.size()];
			for (int i = 0; i < listeElement.size(); i++) {
				toSelect[i] = i;
			}
			maJTable.selectAll();

			break;
		}

	}

	/**
	 * Envoyer true permet d'actionner la selection multiple, c'est une
	 * selection unique
	 * 
	 * @param selection
	 */
	public void setMultipleSelection(boolean selection) {
		if (selection) {
			typeDeSelection = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
		} else {
			typeDeSelection = ListSelectionModel.SINGLE_SELECTION;

		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (zoneDetail != null) {
			if (maJTable.getSelectedRow() > -1) {
				zoneDetail.setText(elements.get(maJTable.getSelectedColumn()).plusDetails());
			}

		}
	}
}
