package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class login {

	private JFrame frame;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(64, 128, 128));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 1150, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 120, 183, 120, 0 };
		gridBagLayout.rowHeights = new int[] { 210, 50, 78, 129, 0, 248, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JTextArea txtrTrisflix = new JTextArea();
		txtrTrisflix.setForeground(new Color(255, 0, 0));
		txtrTrisflix.setBackground(new Color(0, 0, 0));
		txtrTrisflix.setEditable(false);
		txtrTrisflix.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 30));
		txtrTrisflix.setTabSize(20);
		txtrTrisflix.setText("tristflix");
		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.anchor = GridBagConstraints.SOUTH;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.gridx = 2;
		gbc_txtrTrisflix.gridy = 0;
		frame.getContentPane().add(txtrTrisflix, gbc_txtrTrisflix);

		lblNewLabel_1 = new JLabel("mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 2;
		frame.getContentPane().add(textArea, gbc_textArea);

		JTextArea txtrMotDePasse = new JTextArea();
		txtrMotDePasse.setForeground(new Color(255, 255, 255));
		txtrMotDePasse.setToolTipText("");
		txtrMotDePasse.setBackground(new Color(0, 0, 0));
		txtrMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrMotDePasse.setText("mot de passe ");
		GridBagConstraints gbc_txtrMotDePasse = new GridBagConstraints();
		gbc_txtrMotDePasse.anchor = GridBagConstraints.EAST;
		gbc_txtrMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_txtrMotDePasse.gridx = 1;
		gbc_txtrMotDePasse.gridy = 3;
		frame.getContentPane().add(txtrMotDePasse, gbc_txtrMotDePasse);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		frame.getContentPane().add(passwordField, gbc_passwordField);

		btnNewButton = new JButton("Soumettre");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

}
