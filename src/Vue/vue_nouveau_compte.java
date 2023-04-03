package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class vue_nouveau_compte {

	private JPasswordField passwordField;
	private GridBagLayout gridBagLayout;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JTextArea textArea_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnRomantique;
	private JRadioButton rdbtnDocumentaire;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vue_nouveau_compte window = new vue_nouveau_compte();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
	public JButton getPayement() {
		return this.btnNewButton;
	}

	/**
	 * Create the application.
	 */
	public vue_nouveau_compte() {
		passwordField = new JPasswordField();
		gridBagLayout = new GridBagLayout();
		lblNewLabel_1 = new JLabel("mail");
		lblNewLabel_2 = new JLabel("mot de passe");
		lblNewLabel_3 = new JLabel("prénom/pseudo");
		lblNewLabel = new JLabel("Sélectionner vos types de film préférer ");
		textArea = new JTextArea();
		textArea_2 = new JTextArea();
		rdbtnNewRadioButton = new JRadioButton("Action");
		rdbtnNewRadioButton_1 = new JRadioButton("Comédie");
		rdbtnRomantique = new JRadioButton("Romantique");
		rdbtnDocumentaire = new JRadioButton("Documentaire");
		btnNewButton = new JButton("Payement");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {
		

		gridBagLayout.columnWidths = new int[] { 83, 73, 33, 114, 17, 43, 60, 54, 60, 42, 73, 60, 114, 91, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 34, 33, 0, 33, 33, 43, 53, 113, 95, 87, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 2;
		
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		
		
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.DARK_GRAY);
		
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 5;
		gbc_textArea.gridy = 2;
		
		frame.getContentPane().add(textArea, gbc_textArea);
		
		

		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 4;
		
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		
		
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 5;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 5;
		gbc_passwordField.gridy = 4;
		
		frame.getContentPane().add(passwordField, gbc_passwordField);

		
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 5;
		
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		
		
		textArea_2.setForeground(Color.WHITE);
		textArea_2.setBackground(Color.DARK_GRAY);
		
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.gridwidth = 5;
		gbc_textArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 5;
		gbc_textArea_2.gridy = 5;
		
		frame.getContentPane().add(textArea_2, gbc_textArea_2);

		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 7;
		
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		
		
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(Color.BLACK);
		
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 3;
		gbc_rdbtnNewRadioButton.gridy = 8;
		
		frame.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		
		
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBackground(Color.BLACK);
		
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.gridwidth = 2;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 6;
		gbc_rdbtnNewRadioButton_1.gridy = 8;
		
		frame.getContentPane().add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		

		rdbtnRomantique.setForeground(new Color(255, 255, 255));
		rdbtnRomantique.setBackground(Color.BLACK);
		
		GridBagConstraints gbc_rdbtnRomantique = new GridBagConstraints();
		gbc_rdbtnRomantique.gridwidth = 2;
		gbc_rdbtnRomantique.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRomantique.gridx = 9;
		gbc_rdbtnRomantique.gridy = 8;
		
		frame.getContentPane().add(rdbtnRomantique, gbc_rdbtnRomantique);

		
		
		rdbtnDocumentaire.setForeground(new Color(255, 255, 255));
		rdbtnDocumentaire.setBackground(Color.BLACK);
		
		GridBagConstraints gbc_rdbtnDocumentaire = new GridBagConstraints();
		gbc_rdbtnDocumentaire.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDocumentaire.gridx = 12;
		gbc_rdbtnDocumentaire.gridy = 8;
		
		frame.getContentPane().add(rdbtnDocumentaire, gbc_rdbtnDocumentaire);

		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 9;
		
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}
	
	
	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.passwordField);
		frame.getContentPane().remove(this.lblNewLabel_1);
		frame.getContentPane().remove(this.lblNewLabel_2);
		frame.getContentPane().remove(this.lblNewLabel_3);
		frame.getContentPane().remove(this.lblNewLabel);
		frame.getContentPane().remove(this.textArea);
		frame.getContentPane().remove(this.textArea_2);
		frame.getContentPane().remove(this.rdbtnNewRadioButton);
		frame.getContentPane().remove(this.rdbtnNewRadioButton_1);
		frame.getContentPane().remove(this.rdbtnRomantique);
		frame.getContentPane().remove(this.rdbtnDocumentaire);
		frame.getContentPane().remove(this.btnNewButton);
	}

}
