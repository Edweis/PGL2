package view;

import java.awt.Container;

import javax.swing.JFrame;

public class Vue{
	private static Vue instance = null;
	private static JFrame fenetre = null;
	public static Vue getInstance(){
		if(instance == null){
			instance = new Vue();
		}
		return instance;
	}
	private Vue(){
		fenetre = new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setLayout(null);
	}
	public void vider (){
		fenetre.getContentPane().removeAll();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setLayout(null);
	}
	public void finitions(){
		fenetre.pack();
		fenetre.setSize(1000,700);
		fenetre.setVisible(true);
	}
	public Container getContentPane(){
		return fenetre.getContentPane();
	}
}
