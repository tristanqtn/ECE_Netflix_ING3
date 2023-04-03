package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class vue_accueil {

	/**
	 * Launch the application.
	 */

	private JButton logIn;
	private JButton newUser;
	private JTextArea txtrTrisflix;
	private GridBagLayout gridBagLayout;

	public static void main(String[] args) {
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { JFrame
		 * frame=new JFrame(); frame.getContentPane().setBackground(new Color(0, 0, 0));
		 * frame.setBounds(100, 100, 1150, 700);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); vue_accueil window =
		 * new vue_accueil(); this.initialize(frame); } catch (Exception e) {
		 * e.printStackTrace(); } } });
		 */
	}

	public JButton getLogIn() {
		return this.logIn;
	}

	public JButton getNewUser() {
		return this.newUser;
	}

	/**
	 * Create the application.
	 */
	public vue_accueil() {

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {

		this.gridBagLayout = new GridBagLayout();
		this.gridBagLayout.columnWidths = new int[] { 0, 0, 120, 101, 126, 248, 59, 75, 50, 150, -185, 0 };
		this.gridBagLayout.rowHeights = new int[] { 210, 50, 78, 129, 248, 0 };
		this.gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		this.gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };

		frame.getContentPane().setLayout(this.gridBagLayout);

		this.txtrTrisflix = new JTextArea();
		this.txtrTrisflix.setForeground(new Color(255, 0, 0));
		this.txtrTrisflix.setBackground(new Color(0, 0, 0));
		this.txtrTrisflix.setEditable(false);
		this.txtrTrisflix.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 30));
		this.txtrTrisflix.setTabSize(20);
		this.txtrTrisflix.setText("tristflix");

		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.anchor = GridBagConstraints.SOUTH;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.gridx = 5;
		gbc_txtrTrisflix.gridy = 0;
		frame.getContentPane().add(this.txtrTrisflix, gbc_txtrTrisflix);

		this.logIn = new JButton("Log In");
		this.logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.logIn.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		this.logIn.setBackground(new Color(255, 0, 0));
		this.logIn.setForeground(new Color(255, 255, 255));

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 10, 10);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 2;

		frame.getContentPane().add(this.logIn, gbc_btnNewButton);

		this.newUser = new JButton("New User");
		this.newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.newUser.setForeground(new Color(255, 255, 255));
		this.newUser.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		this.newUser.setBackground(new Color(255, 0, 0));

		GridBagConstraints gbc_btnNe = new GridBagConstraints();
		gbc_btnNe.insets = new Insets(0, 0, 5, 5);
		gbc_btnNe.gridx = 5;
		gbc_btnNe.gridy = 3;

		frame.getContentPane().add(this.newUser, gbc_btnNe);
	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.logIn);
		frame.getContentPane().remove(this.newUser);
		frame.getContentPane().remove(this.txtrTrisflix);
	}

}
