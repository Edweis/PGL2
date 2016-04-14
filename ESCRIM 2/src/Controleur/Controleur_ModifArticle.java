package Controleur;
import utilisateur.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import metier.Article;
import utilisateur.Bdd_utilisateur;
import utilisateur.Utilisateur;
import view.AfficheurGrp;
import view.I_Article;
import view.I_acceuil;

public class Controleur_ModifArticle implements ActionListener {

	Utilisateur utilisateur;
	Article selection;
	JTextField textField;
	JTextField textField_2;
	JComboBox<String> comboBox;
	public Controleur_ModifArticle(Utilisateur utilisateur, Article selection, JTextField textField, JTextField textField_2,JComboBox<String> comboBox) {
		this.utilisateur = utilisateur;
		this.selection = selection;
		this.textField = textField;
		this.textField_2 = textField_2;
		this.comboBox =comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e6) {
		// TODO Auto-generated method stub
		String str = "0";
		JButton btn =(JButton) e6.getSource();
		str = btn.getText();
		if (str=="VALIDER") {
			String newnom = textField.getText();
			String newpoids = textField_2.getText();
			String newtype = (String) comboBox.getSelectedItem();
			int newpoids2 = Integer.parseInt(newpoids); 
			float newpoids3 = (float) newpoids2;
			try {
				selection.modifierArticle(utilisateur, newnom, newtype, newpoids3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	}
}
