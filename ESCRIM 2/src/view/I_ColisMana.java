package view;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;

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
		frame.setBounds(100, 100, 517, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bonjour");
			}
		});
		btnOK.setBounds(119, 24, 69, 23);
		frame.getContentPane().add(btnOK);
		
		textField = new JTextField("Rechercher");
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(null);
			}
		});
		textField.setBounds(23, 25, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(246, 25, 64, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(320, 25, 67, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(397, 25, 69, 20);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblSecteur = new JLabel("Secteur");
		lblSecteur.setBounds(246, 11, 37, 14);
		frame.getContentPane().add(lblSecteur);
		
		JLabel lblDsignation = new JLabel("Désignation");
		lblDsignation.setBounds(320, 11, 66, 14);
		frame.getContentPane().add(lblDsignation);
		
		JLabel label = new JLabel("Configuration");
		label.setBounds(397, 11, 66, 14);
		frame.getContentPane().add(label);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(221, 56, 69, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnNewButton = new JButton("Retirer");
		btnNewButton.setBounds(221, 89, 69, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblColisSlectionns = new JLabel("Colis s\u00E9lectionn\u00E9s");
		lblColisSlectionns.setBounds(300, 56, 87, 14);
		frame.getContentPane().add(lblColisSlectionns);
	}
}

