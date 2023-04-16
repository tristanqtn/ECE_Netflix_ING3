package Vue;

/**
 * 
 * @author Clement BROT
 *
 *         Permet à utilisateur de se connecter à son compte
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JPasswordField_arrondi;
import ElementsVisuels.JTextArea_arrondi;
import ElementsVisuels.JTextField_arrondi;

public class vue_connexion {

	private JPasswordField_arrondi passwordField;
	private JLabel lblNewLabel_1;
	private JButton_arrondi btnNewButton;
	private JTextArea_arrondi txtrTrisflix;
	private JTextField_arrondi textArea;
	private JTextArea txtrMotDePasse;
	private GridBagLayout gridBagLayout;
	private JButton_arrondi retour;

	public JButton_arrondi getSoumettre() {
		return this.btnNewButton;
	}

	public JButton_arrondi get_retour() {
		return this.retour;
	}

	public String get_password() {
		return String.valueOf(passwordField.getPassword());
	}

	public String get_mail() {
		return this.textArea.getText();
	}

	/**
	 * Create the application.
	 */
	public vue_connexion() {

		this.gridBagLayout = new GridBagLayout();
		this.txtrTrisflix = new JTextArea_arrondi();
		this.lblNewLabel_1 = new JLabel("mail");
		this.textArea = new JTextField_arrondi();
		this.txtrMotDePasse = new JTextArea();
		this.retour = new JButton_arrondi();
		this.passwordField = new JPasswordField_arrondi();
		this.btnNewButton = new JButton_arrondi("Soumettre");

		configure();

	}

	public void resetInformations() {// On reset les informations
		this.textArea.setText("");
		this.passwordField.setText("");
	}

	public void configure() {// on configure les éléments

		this.gridBagLayout.columnWidths = new int[] { 0, 120, 183, 120, 0 };
		this.gridBagLayout.rowHeights = new int[] { 210, 50, 78, 129, 0, 248, 0 };
		this.gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		this.gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };

		this.txtrTrisflix.setForeground(new Color(255, 0, 0));
		this.txtrTrisflix.setBackground(new Color(0, 0, 0));
		this.txtrTrisflix.setEditable(false);
		this.txtrTrisflix.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 50));
		this.txtrTrisflix.setTabSize(20);
		this.txtrTrisflix.setText(" FLOU-FLIX ");

		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath());
		retour.setIcon(icon);
		retour.setBackground(new Color(0, 0, 0));

		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_1.setForeground(new Color(224, 240, 255));

		this.textArea.setForeground(Color.WHITE);
		this.textArea.setBackground(Color.DARK_GRAY);

		this.txtrMotDePasse.setForeground(new Color(255, 255, 255));
		this.txtrMotDePasse.setToolTipText("");
		this.txtrMotDePasse.setBackground(new Color(0, 0, 0));
		this.txtrMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtrMotDePasse.setText("mot de passe");

		this.passwordField.setForeground(Color.WHITE);
		this.passwordField.setBackground(Color.DARK_GRAY);

		btnNewButton.setBackground(new Color(224, 240, 255));

	}

	public void initialize(JFrame frame) {// On affiche les éléments sur frame

		frame.getContentPane().setLayout(this.gridBagLayout);

		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.anchor = GridBagConstraints.SOUTH;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.gridx = 2;
		gbc_txtrTrisflix.gridy = 0;

		frame.getContentPane().add(this.txtrTrisflix, gbc_txtrTrisflix);

		GridBagConstraints gbc_retour = new GridBagConstraints();
		gbc_retour.anchor = GridBagConstraints.NORTHWEST;
		gbc_retour.insets = new Insets(0, 0, 5, 5);
		gbc_retour.gridx = 0;
		gbc_retour.gridy = 0;

		frame.getContentPane().add(this.retour, gbc_retour);

		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;

		frame.getContentPane().add(this.lblNewLabel_1, gbc_lblNewLabel_1);

		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 2;

		frame.getContentPane().add(this.textArea, gbc_textArea);

		GridBagConstraints gbc_txtrMotDePasse = new GridBagConstraints();
		gbc_txtrMotDePasse.anchor = GridBagConstraints.EAST;
		gbc_txtrMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_txtrMotDePasse.gridx = 1;
		gbc_txtrMotDePasse.gridy = 3;

		frame.getContentPane().add(this.txtrMotDePasse, gbc_txtrMotDePasse);

		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;

		frame.getContentPane().add(this.passwordField, gbc_passwordField);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;

		frame.getContentPane().add(this.btnNewButton, gbc_btnNewButton);

		repaint(frame);

	}

	public void delete(JFrame frame) {// On retire les éléments de frame
		frame.getContentPane().remove(this.btnNewButton);
		frame.getContentPane().remove(this.lblNewLabel_1);
		frame.getContentPane().remove(this.passwordField);
		frame.getContentPane().remove(this.textArea);
		frame.getContentPane().remove(this.txtrMotDePasse);
		frame.getContentPane().remove(this.txtrTrisflix);
		frame.getContentPane().remove(this.retour);

		repaint(frame);

	}

	public void repaint(JFrame frame) {// on rafraichit la frame

		this.btnNewButton.repaint();
		this.lblNewLabel_1.repaint();
		this.passwordField.repaint();
		this.retour.repaint();
		this.textArea.repaint();
		this.txtrMotDePasse.repaint();
		this.txtrTrisflix.repaint();

		frame.validate();
		frame.repaint();

	}

}
