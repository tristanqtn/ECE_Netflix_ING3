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
import javax.swing.JTextField;

public class vue_administration implements ActionListener {

	private JFrame frame;
	private JTextField textfield_commande;
	private JTextField textfield_demande;

	private JButton creer_bdd;
	private JButton nettoyer_bdd;
	private JButton exec_requete;
	private JButton afficher_bdd;

	private boolean b_effacer_bdd = false;
	private boolean b_recreer_bdd = false;
	private boolean b_afficher_bdd = false;
	private String sql_commande = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vue_administration window = new vue_administration();
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
	public vue_administration() {
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
		txtrTrisflix.setText("Administrator Menu");
		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.anchor = GridBagConstraints.SOUTH;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.gridx = 5;
		gbc_txtrTrisflix.gridy = 0;
		frame.getContentPane().add(txtrTrisflix, gbc_txtrTrisflix);

		nettoyer_bdd = new JButton("Nettoyer BDD");
		nettoyer_bdd.addActionListener(this);

		nettoyer_bdd.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		nettoyer_bdd.setBackground(new Color(255, 0, 0));
		nettoyer_bdd.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_nettoyer_bdd = new GridBagConstraints();
		gbc_nettoyer_bdd.insets = new Insets(0, 0, 10, 10);
		gbc_nettoyer_bdd.gridx = 3;
		gbc_nettoyer_bdd.gridy = 1;
		frame.getContentPane().add(nettoyer_bdd, gbc_nettoyer_bdd);

		creer_bdd = new JButton("Recreer BDD");
		creer_bdd.addActionListener(this);
		creer_bdd.setForeground(new Color(0, 0, 0));
		creer_bdd.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 10));
		creer_bdd.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_creer_bdd = new GridBagConstraints();
		gbc_creer_bdd.insets = new Insets(0, 0, 5, 5);
		gbc_creer_bdd.gridx = 5;
		gbc_creer_bdd.gridy = 1;
		frame.getContentPane().add(creer_bdd, gbc_creer_bdd);

		afficher_bdd = new JButton("Afficher BDD");
		afficher_bdd.addActionListener(this);
		afficher_bdd.setForeground(Color.BLACK);
		afficher_bdd.setFont(new Font("Dialog", Font.BOLD, 10));
		afficher_bdd.setBackground(Color.RED);
		GridBagConstraints gbc_afficher_bdd = new GridBagConstraints();
		gbc_afficher_bdd.insets = new Insets(0, 0, 5, 5);
		gbc_afficher_bdd.gridx = 7;
		gbc_afficher_bdd.gridy = 1;
		frame.getContentPane().add(afficher_bdd, gbc_afficher_bdd);

		textfield_demande = new JTextField();
		textfield_demande.setEditable(false);
		textfield_demande.setForeground(Color.WHITE);
		textfield_demande.setBackground(new Color(0, 0, 0));
		textfield_demande.setText("Commande à executer");
		GridBagConstraints gbc_txtCommandeExecuter = new GridBagConstraints();
		gbc_txtCommandeExecuter.insets = new Insets(0, 0, 5, 5);
		gbc_txtCommandeExecuter.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCommandeExecuter.gridx = 4;
		gbc_txtCommandeExecuter.gridy = 3;
		frame.getContentPane().add(textfield_demande, gbc_txtCommandeExecuter);
		textfield_demande.setColumns(10);

		textfield_commande = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(textfield_commande, gbc_textField);
		textfield_commande.setColumns(10);

		exec_requete = new JButton("Executer");
		exec_requete.addActionListener(this);

		exec_requete.setForeground(Color.BLACK);
		exec_requete.setFont(new Font("Dialog", Font.BOLD, 10));
		exec_requete.setBackground(Color.RED);
		GridBagConstraints gbc_exec_requete = new GridBagConstraints();
		gbc_exec_requete.insets = new Insets(0, 0, 5, 5);
		gbc_exec_requete.gridx = 6;
		gbc_exec_requete.gridy = 3;
		frame.getContentPane().add(exec_requete, gbc_exec_requete);
	}

	public boolean isEffacer_bdd() {
		return b_effacer_bdd;
	}

	public void setEffacer_bdd(boolean bool) {
		b_effacer_bdd = bool;
	}

	public boolean isRecreer_bdd() {
		return b_recreer_bdd;
	}

	public void setRecreer_bdd(boolean bool) {
		b_effacer_bdd = bool;
	}

	public boolean isAfficher_bdd() {
		return b_afficher_bdd;
	}

	public void setAfficher_bdd(boolean bool) {
		b_effacer_bdd = bool;
	}

	public String getSql_commande() {
		return sql_commande;
	}

	public void setSql_commande(String string) {
		sql_commande = string;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.afficher_bdd) {
			System.out.println("Afficher BDD");
			this.b_afficher_bdd = true;
		}
		if (e.getSource() == this.nettoyer_bdd) {
			System.out.println("Nettoyer BDD");
			this.b_effacer_bdd = true;
		}
		if (e.getSource() == this.creer_bdd) {
			System.out.println("Creer BDD");
			this.b_recreer_bdd = true;
		}
		if (e.getSource() == this.exec_requete) {
			System.out.println("Executer BDD" + this.textfield_commande.getText());
			this.sql_commande = this.textfield_commande.getText();
		}
	}

}
