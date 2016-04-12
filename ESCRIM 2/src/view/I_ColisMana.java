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
import javax.swing.JLabel;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

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
		frame = new JFrame("Management des Colis");
		frame.setBounds(100, 100, 642, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bonjour");
			}
		});
		btnOK.setBounds(102, 25, 69, 23);
		frame.getContentPane().add(btnOK);
		
		textField = new JTextField("Rechercher");
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(null);
			}
		});
		textField.setBounds(6, 26, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(211, 26, 50, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(271, 26, 69, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(350, 26, 78, 20);
		frame.getContentPane().add(comboBox_2);
		
		JList list = new JList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		
		JList list_1 = new JList();
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblListeDeColis = new JLabel("Liste de Colis");
		lblListeDeColis.setBounds(6, 57, 76, 14);
		frame.getContentPane().add(lblListeDeColis);
		
		JLabel label = new JLabel("Groupe de Colis");
		label.setBounds(373, 57, 147, 14);
		frame.getContentPane().add(label);
		
		JLabel lblSecteur = new JLabel("Secteur");
		lblSecteur.setBounds(211, 1, 50, 23);
		frame.getContentPane().add(lblSecteur);
		
		JLabel label_1 = new JLabel("Désignation");
		label_1.setBounds(271, 1, 69, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Configuration");
		label_2.setBounds(350, 1, 78, 23);
		frame.getContentPane().add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 311, 620, 91);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("infos...");
		lblNewLabel.setBounds(6, 16, 608, 82);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(271, 71, 86, 229);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Ajouter");
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("Retirer");
		panel_1.add(button);
		
		JList list_2 = new JList();
		list_2.setBounds(6, 128, 50, -54);
		frame.getContentPane().add(list_2);
		
		JList list_3 = new JList();
		list_3.setBounds(6, 73, 266, 227);
		frame.getContentPane().add(list_3);
		
		JList list_4 = new JList();
		list_4.setBounds(354, 73, 266, 227);
		frame.getContentPane().add(list_4);
	}
}
