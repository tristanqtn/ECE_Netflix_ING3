package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class vue_connexion {

	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JTextArea txtrTrisflix;
	private JTextArea textArea;
	private JTextArea txtrMotDePasse;
	private GridBagLayout gridBagLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { JFrame
		 * frame=new JFrame(); frame.getContentPane().setForeground(new Color(64, 128,
		 * 128)); frame.getContentPane().setBackground(new Color(0, 0, 0));
		 * frame.setBounds(100, 100, 1150, 700);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); vue_connexion window =
		 * new vue_connexion(frame); frame.setVisible(true); } catch (Exception e) {
		 * e.printStackTrace(); } } });
		 */
	}

	public JButton getSoumettre() {
		return this.btnNewButton;
	}

	/**
	 * Create the application.
	 */
	public vue_connexion() {

		this.gridBagLayout = new GridBagLayout();
		this.txtrTrisflix = new JTextArea();
		this.lblNewLabel_1 = new JLabel("mail");
		this.textArea = new JTextArea();
		this.txtrMotDePasse = new JTextArea();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {

		this.gridBagLayout.columnWidths = new int[] { 0, 120, 183, 120, 0 };
		this.gridBagLayout.rowHeights = new int[] { 210, 50, 78, 129, 0, 248, 0 };
		this.gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		this.gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };

		frame.getContentPane().setLayout(this.gridBagLayout);

		this.txtrTrisflix.setForeground(new Color(255, 0, 0));
		this.txtrTrisflix.setBackground(new Color(0, 0, 0));
		this.txtrTrisflix.setEditable(false);
		this.txtrTrisflix.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 30));
		this.txtrTrisflix.setTabSize(20);
		this.txtrTrisflix.setText("tristflix");

		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.anchor = GridBagConstraints.SOUTH;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.gridx = 2;
		gbc_txtrTrisflix.gridy = 0;

		frame.getContentPane().add(this.txtrTrisflix, gbc_txtrTrisflix);

		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblNewLabel_1.setForeground(new Color(255, 255, 255));

		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;

		frame.getContentPane().add(this.lblNewLabel_1, gbc_lblNewLabel_1);

		this.textArea.setForeground(Color.WHITE);
		this.textArea.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 2;

		frame.getContentPane().add(this.textArea, gbc_textArea);

		this.txtrMotDePasse.setForeground(new Color(255, 255, 255));
		this.txtrMotDePasse.setToolTipText("");
		this.txtrMotDePasse.setBackground(new Color(0, 0, 0));
		this.txtrMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtrMotDePasse.setText("mot de passe ");

		GridBagConstraints gbc_txtrMotDePasse = new GridBagConstraints();
		gbc_txtrMotDePasse.anchor = GridBagConstraints.EAST;
		gbc_txtrMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_txtrMotDePasse.gridx = 1;
		gbc_txtrMotDePasse.gridy = 3;

		frame.getContentPane().add(this.txtrMotDePasse, gbc_txtrMotDePasse);

		this.passwordField = new JPasswordField();

		this.passwordField.setForeground(Color.WHITE);
		this.passwordField.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;

		frame.getContentPane().add(this.passwordField, gbc_passwordField);

		this.btnNewButton = new JButton("Soumettre");

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;

		frame.getContentPane().add(this.btnNewButton, gbc_btnNewButton);

	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.btnNewButton);
		frame.getContentPane().remove(this.lblNewLabel_1);
		frame.getContentPane().remove(this.passwordField);
		frame.getContentPane().remove(this.textArea);
		frame.getContentPane().remove(this.txtrMotDePasse);
		frame.getContentPane().remove(this.txtrTrisflix);
	}

}
