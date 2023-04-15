package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JPasswordField_arrondi;
import ElementsVisuels.JTextArea_arrondi;

public class vue_nouveau_compte {

	private JTextArea_arrondi textArea_0;
	private JLabel lblNewLabel_1;
	private JTextArea_arrondi textArea;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextArea_arrondi textArea_2;
	private JLabel lblNewLabel_3_1;
	private JTextArea_arrondi textArea_2_1;
	private JLabel lblNewLabel_3_1_1;
	private JPasswordField_arrondi textArea_2_1_1;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnRomantique;
	private JRadioButton rdbtnDocumentaire;
	private JButton_arrondi btnPayement;
	private JButton_arrondi retour;
	private GridBagLayout gridBagLayout;

	public vue_nouveau_compte() {
		lblNewLabel_1 = new JLabel("Prenom");
		textArea = new JTextArea_arrondi();

		lblNewLabel_2 = new JLabel("Nom");
		textArea_0 = new JTextArea_arrondi();

		lblNewLabel_3 = new JLabel("Mail");
		textArea_2 = new JTextArea_arrondi();

		lblNewLabel_3_1 = new JLabel("Telephone");
		textArea_2_1 = new JTextArea_arrondi();

		lblNewLabel_3_1_1 = new JLabel("Mot de passe");
		textArea_2_1_1 = new JPasswordField_arrondi();

		lblNewLabel = new JLabel("Sélectionner vos types de contenus préférés ");
		rdbtnNewRadioButton = new JRadioButton("Action");
		rdbtnNewRadioButton_1 = new JRadioButton("Comédie");
		rdbtnRomantique = new JRadioButton("Romantique");
		rdbtnDocumentaire = new JRadioButton("Documentaire");
		btnPayement = new JButton_arrondi("Payement");
		retour = new JButton_arrondi();
		// setListeners();
		this.gridBagLayout = new GridBagLayout();
	}

	public JButton_arrondi getPayement() {
		return this.btnPayement;
	}

	public JButton getRetour() {
		return this.retour;
	}

	public String getMDP() {
		return String.valueOf(this.textArea_2_1_1.getPassword());

	}

	public String getMail() {
		return textArea_2.getText();
	}

	public String getPrenom() {
		return textArea.getText();
	}

	public String getNom() {
		return textArea_0.getText();
	}

	public String getTelephone() {
		return textArea_2_1.getText();
	}

	public boolean getAction() {
		return this.rdbtnNewRadioButton.isSelected();
	}

	public boolean getComedie() {
		return this.rdbtnNewRadioButton_1.isSelected();
	}

	public boolean getRomantique() {
		return this.rdbtnRomantique.isSelected();
	}

	public boolean getDocumentaire() {
		return this.rdbtnDocumentaire.isSelected();
	}

	/*
	 * public ArrayList<Component> getEnterToListen(){ ArrayList<Component>
	 * composants = new ArrayList<Component>(); composants.add(textArea_2);
	 * composants.add(textArea); composants.add(textArea_2_1);
	 * composants.add(textArea_0); composants.add(textArea_2_1_1); return
	 * composants; }
	 * 
	 * public ArrayList<JTextArea_arrondi> getTextAreas(){
	 * ArrayList<JTextArea_arrondi> composants = new ArrayList<JTextArea_arrondi>();
	 * composants.add(textArea_2); composants.add(textArea);
	 * composants.add(textArea_2_1); composants.add(textArea_0); return composants;
	 * }
	 */

	public void initialize(JFrame frame) {

		gridBagLayout.columnWidths = new int[] { 83, 73, 33, 114, 17, 43, 60, 54, 60, 42, 73, 60, 114, 91, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 34, 33, 0, 33, 33, 35, 33, 43, 53, 113, 95, 87, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
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

		textArea_0.setForeground(Color.WHITE);
		textArea_0.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 5;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 5;
		gbc_passwordField.gridy = 4;

		frame.getContentPane().add(textArea_0, gbc_passwordField);

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

		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 3;
		gbc_lblNewLabel_3_1.gridy = 6;

		frame.getContentPane().add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);

		textArea_2_1.setForeground(Color.WHITE);
		textArea_2_1.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_textArea_2_1 = new GridBagConstraints();
		gbc_textArea_2_1.gridwidth = 5;
		gbc_textArea_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_2_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_2_1.gridx = 5;
		gbc_textArea_2_1.gridy = 6;

		frame.getContentPane().add(textArea_2_1, gbc_textArea_2_1);

		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GridBagConstraints gbc_lblNewLabel_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1.gridx = 3;
		gbc_lblNewLabel_3_1_1.gridy = 7;

		frame.getContentPane().add(lblNewLabel_3_1_1, gbc_lblNewLabel_3_1_1);

		textArea_2_1_1.setForeground(Color.WHITE);
		textArea_2_1_1.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_textArea_2_1_1 = new GridBagConstraints();
		gbc_textArea_2_1_1.gridwidth = 5;
		gbc_textArea_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_2_1_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_2_1_1.gridx = 5;
		gbc_textArea_2_1_1.gridy = 7;

		frame.getContentPane().add(textArea_2_1_1, gbc_textArea_2_1_1);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 0, 0));

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;

		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(Color.BLACK);

		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 3;
		gbc_rdbtnNewRadioButton.gridy = 10;

		frame.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBackground(Color.BLACK);

		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.gridwidth = 2;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 6;
		gbc_rdbtnNewRadioButton_1.gridy = 10;

		frame.getContentPane().add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

		rdbtnRomantique.setForeground(new Color(255, 255, 255));
		rdbtnRomantique.setBackground(Color.BLACK);

		GridBagConstraints gbc_rdbtnRomantique = new GridBagConstraints();
		gbc_rdbtnRomantique.gridwidth = 2;
		gbc_rdbtnRomantique.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRomantique.gridx = 9;
		gbc_rdbtnRomantique.gridy = 10;

		frame.getContentPane().add(rdbtnRomantique, gbc_rdbtnRomantique);

		rdbtnDocumentaire.setForeground(new Color(255, 255, 255));
		rdbtnDocumentaire.setBackground(Color.BLACK);

		GridBagConstraints gbc_rdbtnDocumentaire = new GridBagConstraints();
		gbc_rdbtnDocumentaire.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDocumentaire.gridx = 12;
		gbc_rdbtnDocumentaire.gridy = 10;

		frame.getContentPane().add(rdbtnDocumentaire, gbc_rdbtnDocumentaire);

		btnPayement.setBackground(Color.RED);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 11;

		frame.getContentPane().add(btnPayement, gbc_btnNewButton);

		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));
		retour.setBackground(new Color(0, 0, 0));

		GridBagConstraints gbc_retour = new GridBagConstraints();
		gbc_retour.anchor = GridBagConstraints.WEST;
		gbc_retour.insets = new Insets(0, 0, 5, 5);
		gbc_retour.gridx = 0;
		gbc_retour.gridy = 0;

		frame.getContentPane().add(this.retour, gbc_retour);

		repaint(frame);

	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.textArea_0);
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
		frame.getContentPane().remove(this.btnPayement);
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.lblNewLabel_3_1);
		frame.getContentPane().remove(this.lblNewLabel_3_1_1);
		frame.getContentPane().remove(this.textArea_2_1);
		frame.getContentPane().remove(this.textArea_2_1_1);
		repaint(frame);
	}

	public void repaint(JFrame frame) {
		this.textArea_0.repaint();
		this.lblNewLabel.repaint();
		this.lblNewLabel_1.repaint();
		this.lblNewLabel_2.repaint();
		this.lblNewLabel_3.repaint();
		this.textArea.repaint();
		this.textArea_2.repaint();
		this.rdbtnNewRadioButton.repaint();
		this.rdbtnNewRadioButton_1.repaint();
		this.rdbtnRomantique.repaint();
		this.rdbtnDocumentaire.repaint();
		this.btnPayement.repaint();
		this.retour.repaint();
		this.lblNewLabel_3_1.repaint();
		this.lblNewLabel_3_1_1.repaint();
		this.textArea_2_1.repaint();
		this.textArea_2_1_1.repaint();

		frame.validate();
		frame.repaint();
	}

	/*
	 * public void setListeners() { ArrayList<JTextArea_arrondi> list =
	 * getTextAreas(); for(int i=0;i<list.size();i++) { final int rank =i;
	 * list.get(rank).addKeyListener(new KeyListener() {
	 * 
	 * @Override public void keyTyped(KeyEvent e) {
	 * 
	 * }
	 * 
	 * @Override public void keyPressed(KeyEvent e) { }
	 * 
	 * @Override public void keyReleased(KeyEvent e) { String text =
	 * list.get(rank).getText(); char chara = 10; String character="";
	 * character+=chara; list.get(rank).setText(text.replaceAll(character,"")); }
	 * 
	 * }); } }
	 */

}
