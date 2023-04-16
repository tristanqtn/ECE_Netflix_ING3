package Vue;

/**
 * 
 * @author Clement BROT
 *
 *         Première vue du projet permet à l'utilisateur de choisir entre la connexion et les création d'un nouveau compte.
 *
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;

public class vue_accueil {

	private JButton_arrondi logIn;
	private JButton_arrondi newUser;
	private JTextArea_arrondi txtrTrisflix;
	private GridBagLayout gridBagLayout;

	// GETTERS
	public JButton_arrondi getLogIn() {
		return this.logIn;
	}

	public JButton_arrondi getNewUser() {
		return this.newUser;
	}

	/**
	 * Create the application.
	 */
	public vue_accueil() {
		this.txtrTrisflix = new JTextArea_arrondi();
		this.logIn = new JButton_arrondi("Log In");
		this.newUser = new JButton_arrondi("New User");
		configure();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void configure() {// On configure les éléments
		this.txtrTrisflix.setForeground(new Color(255, 0, 0));
		this.txtrTrisflix.setBackground(new Color(0, 0, 0));
		this.txtrTrisflix.setEditable(false);
		this.txtrTrisflix.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 50));
		this.txtrTrisflix.setTabSize(20);
		this.txtrTrisflix.setText(" FLOU-FLIX ");

		this.logIn.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		this.logIn.setBackground(new Color(255, 0, 0));
		this.logIn.setForeground(new Color(255, 255, 255));

		this.newUser.setForeground(new Color(255, 255, 255));
		this.newUser.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		this.newUser.setBackground(new Color(255, 0, 0));
	}

	public void initialize(JFrame frame) {// On affiche la vue dans frame

		this.gridBagLayout = new GridBagLayout();
		this.gridBagLayout.columnWidths = new int[] { 0, 0, 120, 101, 126, 248, 59, 75, 50, 150, -185, 0 };
		this.gridBagLayout.rowHeights = new int[] { 210, 50, 78, 129, 248, 0 };
		this.gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		this.gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };

		frame.getContentPane().setLayout(this.gridBagLayout);

		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.anchor = GridBagConstraints.SOUTH;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.gridx = 5;
		gbc_txtrTrisflix.gridy = 0;
		frame.getContentPane().add(this.txtrTrisflix, gbc_txtrTrisflix);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 10, 10);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 2;

		frame.getContentPane().add(this.logIn, gbc_btnNewButton);

		GridBagConstraints gbc_btnNe = new GridBagConstraints();
		gbc_btnNe.insets = new Insets(0, 0, 5, 5);
		gbc_btnNe.gridx = 5;
		gbc_btnNe.gridy = 3;

		frame.getContentPane().add(this.newUser, gbc_btnNe);

		repaint(frame);

	}

	public void delete(JFrame frame) {// On retire les éléments de frame

		frame.getContentPane().remove(this.logIn);
		frame.getContentPane().remove(this.newUser);
		frame.getContentPane().remove(this.txtrTrisflix);

		repaint(frame);

	}

	public void repaint(JFrame frame) {// On rafraichit frame

		this.logIn.repaint();
		this.newUser.repaint();
		this.txtrTrisflix.repaint();
		frame.validate();
		frame.repaint();

	}

}
