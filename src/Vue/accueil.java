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
import javax.swing.JTextArea;

public class accueil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil window = new accueil();
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
	public accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1150, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 120, 101, 126, 248, 59, 75, 50, 150, -185, 0 };
		gridBagLayout.rowHeights = new int[] { 210, 50, 78, 129, 248, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
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
		gbc_txtrTrisflix.gridx = 5;
		gbc_txtrTrisflix.gridy = 0;
		frame.getContentPane().add(txtrTrisflix, gbc_txtrTrisflix);

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 10, 10);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 2;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		JButton btnNe = new JButton("New User");
		btnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNe.setForeground(new Color(255, 255, 255));
		btnNe.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		btnNe.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnNe = new GridBagConstraints();
		gbc_btnNe.insets = new Insets(0, 0, 5, 5);
		gbc_btnNe.gridx = 5;
		gbc_btnNe.gridy = 3;
		frame.getContentPane().add(btnNe, gbc_btnNe);
	}

}
