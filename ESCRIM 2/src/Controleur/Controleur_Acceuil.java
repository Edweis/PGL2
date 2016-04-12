package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
			
			break;
		case "btnGestionAvion":
			
			break;
		

	}

	}
}
