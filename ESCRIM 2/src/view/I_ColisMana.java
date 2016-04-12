package view;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class I_ColisMana {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					I_ColisMana window = new I_ColisMana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public I_ColisMana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bonjour");
			}
		});
		btnOK.setBounds(100, 10, 69, 23);
		frame.getContentPane().add(btnOK);
		
		textField = new JTextField("Rechercher");
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(null);
			}
		});
		textField.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(205, 26, 50, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(265, 26, 69, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(344, 26, 50, 20);
		frame.getContentPane().add(comboBox_2);
		
		JTextPane txtpnSecteur = new JTextPane();
		txtpnSecteur.setText("Secteur");
		txtpnSecteur.setBounds(205, 0, 50, 20);
		frame.getContentPane().add(txtpnSecteur);
		
		JTextPane txtpnDsignation = new JTextPane();
		txtpnDsignation.setText("D\u00E9signation");
		txtpnDsignation.setBounds(265, 0, 69, 20);
		frame.getContentPane().add(txtpnDsignation);
		
		JTextPane txtpnConfiguration = new JTextPane();
		txtpnConfiguration.setText("Configuration");
		txtpnConfiguration.setBounds(344, 0, 69, 20);
		frame.getContentPane().add(txtpnConfiguration);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 313, 604, 81);
		frame.getContentPane().add(textPane);
		
		JList list = new JList();
		list.setBounds(10, 73, 260, 229);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(354, 73, 260, 229);
		frame.getContentPane().add(list_1);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(275, 57, 69, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Retirer");
		button.setBounds(275, 83, 69, 23);
		frame.getContentPane().add(button);
		
		JTextPane txtpnListeDeColis = new JTextPane();
		txtpnListeDeColis.setText("Liste de Colis");
		txtpnListeDeColis.setBounds(10, 57, 69, 20);
		frame.getContentPane().add(txtpnListeDeColis);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Groupe de Colis");
		textPane_1.setBounds(354, 57, 81, 20);
		frame.getContentPane().add(textPane_1);
	}
}
