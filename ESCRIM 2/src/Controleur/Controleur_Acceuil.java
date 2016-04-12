package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import view.I_Article;

public class Controleur_Acceuil implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String str = "0";
		JButton btn =(JButton) e.getSource();
		str = btn.getText();
		switch (str) {

		case "btnGestionMission":
		
			break;
		case "btnNGestionConfiguration":
			
			break;
		case "btnGestionColis":
			
			break;				
		case "btnGestionArticle":
			try {
				I_Article ouvrir = new I_Article();
				ouvrir.run();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "btnGestionAvion":
			
			break;
		

	}

	}
}
