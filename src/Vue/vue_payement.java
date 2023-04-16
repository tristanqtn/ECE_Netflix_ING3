package Vue;

/**
 * @author Clement Brot
 *
 * Cette vue permet à l'utilisateur de rentrer des informations bancaires lors de la création d'un comtpe
 *
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JPasswordField_arrondi;
import ElementsVisuels.JTextArea_arrondi;

public class vue_payement {

	private JPasswordField_arrondi passwordField_1;
	private JTextArea_arrondi textArea;
	private JTextArea_arrondi textArea_1;
	private JButton_arrondi btnNewButton;
	private JTextArea txtrTrisflix;
	private JLabel lblNewLabel;
	private JLabel lblCryptogramme;
	private JLabel lblRib;
	private JButton_arrondi retour;

	// CONSTRUCTEUR - allocation des éléments visuels
	public vue_payement() {
		this.passwordField_1 = new JPasswordField_arrondi();
		this.textArea = new JTextArea_arrondi();
		this.textArea_1 = new JTextArea_arrondi();
		this.btnNewButton = new JButton_arrondi("Valider");
		this.txtrTrisflix = new JTextArea();
		this.lblNewLabel = new JLabel("Numéro de carte");
		this.lblCryptogramme = new JLabel("Cryptogramme");
		this.lblRib = new JLabel("Date Expiration (mm/aa)");
		this.retour = new JButton_arrondi();
		// setListeners();
	}

	/*
	 * public ArrayList<Component> getEnterToListen(){ ArrayList<Component>
	 * composants = new ArrayList<Component>(); composants.add(textArea_1);
	 * composants.add(textArea); composants.add(passwordField_1); return composants;
	 * }
	 * 
	 * public ArrayList<JTextArea_arrondi> getTextAreas(){
	 * ArrayList<JTextArea_arrondi> composants = new ArrayList<JTextArea_arrondi>();
	 * composants.add(textArea_1); composants.add(textArea); return composants; }
	 */
	// initialisation - placemement et configuration des éléments visuels
	public void initialize(JFrame frame) {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 120, 183, 120, 0 };
		gridBagLayout.rowHeights = new int[] { 210, 50, 50, 63, 70, 248, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };

		frame.getContentPane().setLayout(gridBagLayout);

		txtrTrisflix.setText("Informations Bancaires");
		txtrTrisflix.setTabSize(20);
		txtrTrisflix.setForeground(Color.RED);
		txtrTrisflix.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 30));
		txtrTrisflix.setEditable(false);
		txtrTrisflix.setBackground(Color.BLACK);

		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.anchor = GridBagConstraints.SOUTH;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.gridx = 2;
		gbc_txtrTrisflix.gridy = 0;

		frame.getContentPane().add(txtrTrisflix, gbc_txtrTrisflix);

		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;

		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 2;

		frame.getContentPane().add(textArea, gbc_textArea);

		lblRib.setEnabled(false);
		lblRib.setForeground(Color.WHITE);
		lblRib.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GridBagConstraints gbc_lblRib = new GridBagConstraints();
		gbc_lblRib.anchor = GridBagConstraints.EAST;
		gbc_lblRib.insets = new Insets(0, 0, 5, 5);
		gbc_lblRib.gridx = 1;
		gbc_lblRib.gridy = 3;

		frame.getContentPane().add(lblRib, gbc_lblRib);

		textArea_1.setForeground(Color.WHITE);
		textArea_1.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = 3;

		frame.getContentPane().add(textArea_1, gbc_textArea_1);

		lblCryptogramme.setBackground(Color.WHITE);
		lblCryptogramme.setEnabled(false);
		lblCryptogramme.setForeground(Color.WHITE);
		lblCryptogramme.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GridBagConstraints gbc_lblCryptogramme = new GridBagConstraints();
		gbc_lblCryptogramme.anchor = GridBagConstraints.EAST;
		gbc_lblCryptogramme.insets = new Insets(0, 0, 5, 5);
		gbc_lblCryptogramme.gridx = 1;
		gbc_lblCryptogramme.gridy = 4;

		frame.getContentPane().add(lblCryptogramme, gbc_lblCryptogramme);

		passwordField_1.setForeground(Color.WHITE);
		passwordField_1.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.fill = GridBagConstraints.BOTH;
		gbc_passwordField_1.gridx = 2;
		gbc_passwordField_1.gridy = 4;

		frame.getContentPane().add(passwordField_1, gbc_passwordField_1);

		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 5;

		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));
		retour.setBackground(new Color(0, 0, 0));

		GridBagConstraints gbc_retour = new GridBagConstraints();
		gbc_retour.anchor = GridBagConstraints.NORTHWEST;
		gbc_retour.insets = new Insets(0, 0, 5, 5);
		gbc_retour.gridx = 0;
		gbc_retour.gridy = 0;

		frame.getContentPane().add(this.retour, gbc_retour);

		repaint(frame);

	}

	// GETTERS
	public String getNumCB() {
		return textArea.getText();
	}

	public String getExpiration() {
		return textArea_1.getText();
	}

	public String getCryptogramme() {
		return String.valueOf(this.passwordField_1.getPassword());
	}

	public JButton_arrondi get_valider() {
		return btnNewButton;
	}

	public JButton getRetour() {
		return retour;
	}

	// re-affichage des éléments graphiques
	public void repaint(JFrame frame) {
		this.btnNewButton.repaint();
		this.lblCryptogramme.repaint();
		this.lblNewLabel.repaint();
		this.lblRib.repaint();
		this.passwordField_1.repaint();
		this.textArea.repaint();
		this.textArea_1.repaint();
		this.txtrTrisflix.repaint();
		this.retour.repaint();

		frame.validate();
		frame.repaint();
	}

	// suppression des éléments visuels
	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.btnNewButton);
		frame.getContentPane().remove(this.lblCryptogramme);
		frame.getContentPane().remove(this.lblNewLabel);
		frame.getContentPane().remove(this.lblRib);
		frame.getContentPane().remove(this.passwordField_1);
		frame.getContentPane().remove(this.textArea);
		frame.getContentPane().remove(this.textArea_1);
		frame.getContentPane().remove(this.txtrTrisflix);
		frame.getContentPane().remove(this.retour);

		repaint(frame);
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
	 * @Override public void keyPressed(KeyEvent e) { String text =
	 * list.get(rank).getText(); char chara = 10; String character="";
	 * character+=chara; list.get(rank).setText(text.replaceAll(character,"")); }
	 * 
	 * @Override public void keyReleased(KeyEvent e) {
	 * 
	 * }
	 * 
	 * }); } }
	 */

}