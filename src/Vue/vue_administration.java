package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;

/**
 * 
 * @author Tristan Querton
 * 
 *         Cette vue est permet aux administrateur d'executer des modifications
 *         sur le BDD du prj
 *
 */

public class vue_administration implements ActionListener {

	private boolean b_effacer_bdd = false;
	private boolean b_recreer_bdd = false;
	private boolean b_afficher_bdd = false;
	private String sql_commande = null;

	private JButton_arrondi exec_requete;
	private JTextField textfield_commande;
	private JLabel textfield_demande;
	private JButton_arrondi nettoyer_bdd;
	private JButton_arrondi afficher_bdd;
	private JButton_arrondi creer_bdd;
	private JButton_arrondi retour;
	private JTextArea_arrondi txtrTrisflix;

	// GETTERS
	public JButton_arrondi get_button_creer_bdd() {
		return this.creer_bdd;
	}

	public JButton_arrondi get_button_nettoyer_bdd() {
		return this.nettoyer_bdd;
	}

	public JButton_arrondi get_button_exec_requete() {
		return this.exec_requete;
	}

	public JButton_arrondi get_button_afficher_bdd() {
		return this.afficher_bdd;
	}

	public String get_commande_sql() {
		return this.textfield_commande.getText();
	}

	public JButton getRetour() {
		return this.retour;
	}

	// CONSTRUCTEUR - allocation des éléments visuels
	public vue_administration() {
		exec_requete = new JButton_arrondi("New button");
		exec_requete.setText("Executer");
		afficher_bdd = new JButton_arrondi("New button");
		afficher_bdd.setText("Afficher Statistiques");
		creer_bdd = new JButton_arrondi("New button");
		creer_bdd.setText("Creer BDD");
		textfield_commande = new JTextField();
		textfield_demande = new JLabel("Requete : ");
		nettoyer_bdd = new JButton_arrondi("New button");
		nettoyer_bdd.setText("Nettoyer BDD");
		txtrTrisflix = new JTextArea_arrondi();
		retour = new JButton_arrondi();
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame frame = new JFrame("FLOU-FLIX");
//					frame.getContentPane().setBackground(Color.BLACK);
//					frame.setBounds(100, 100, 1150, 700);
//					frame.setMinimumSize(new Dimension(1150, 700));
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//					vue_administration vue = new vue_administration();
//					frame.setVisible(true);
//					vue.initialize(frame);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	// initialisation - placemement et configuration des éléments visuels
	public void initialize(JFrame frame) {

		retour.setBackground(Color.BLACK);
		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));

		exec_requete.addActionListener(this);
		nettoyer_bdd.addActionListener(this);
		creer_bdd.addActionListener(this);
		afficher_bdd.addActionListener(this);

		exec_requete.setBackground(Color.RED);
		exec_requete.setForeground(Color.WHITE);

		textfield_commande.setForeground(Color.WHITE);
		textfield_commande.setBackground(Color.BLACK);
		textfield_commande.setColumns(10);

		textfield_demande.setForeground(Color.RED);

		nettoyer_bdd.setBackground(Color.RED);
		nettoyer_bdd.setForeground(Color.WHITE);

		retour.setBackground(Color.BLACK);

		txtrTrisflix.setText("         ADMINISTATEUR");
		txtrTrisflix.setTabSize(20);
		txtrTrisflix.setForeground(Color.RED);
		txtrTrisflix.setFont(new Font("Dialog", Font.BOLD, 50));
		txtrTrisflix.setEditable(false);
		txtrTrisflix.setBackground(Color.BLACK);

		afficher_bdd.setBackground(Color.RED);
		afficher_bdd.setForeground(Color.WHITE);

		creer_bdd.setBackground(Color.RED);
		creer_bdd.setForeground(Color.WHITE);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(retour, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 83,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addGap(268)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(nettoyer_bdd, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(creer_bdd, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(149))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(textfield_demande).addGap(18)
														.addComponent(textfield_commande, GroupLayout.PREFERRED_SIZE,
																426, GroupLayout.PREFERRED_SIZE)
														.addGap(18)))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(afficher_bdd, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(exec_requete, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(254).addComponent(txtrTrisflix,
								GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)))
				.addGap(243)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(retour, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
				.addComponent(
						txtrTrisflix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(56)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nettoyer_bdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(creer_bdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(afficher_bdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(97)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textfield_commande, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textfield_demande, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(exec_requete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(276)));
		frame.getContentPane().setLayout(groupLayout);
		repaint(frame);
	}

	// GETTERS & SETTERS
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

	// gestion input clavier
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

	// suppression des éléments visuels
	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.afficher_bdd);
		frame.getContentPane().remove(this.creer_bdd);
		frame.getContentPane().remove(this.exec_requete);
		frame.getContentPane().remove(this.nettoyer_bdd);
		frame.getContentPane().remove(this.textfield_commande);
		frame.getContentPane().remove(this.textfield_demande);
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.txtrTrisflix);
		frame.getContentPane().remove(this.retour);
		repaint(frame);
	}

	// re-affichage des éléments graphiques
	public void repaint(JFrame frame) {
		this.afficher_bdd.repaint();
		this.creer_bdd.repaint();
		this.exec_requete.repaint();
		this.nettoyer_bdd.repaint();
		this.retour.repaint();
		this.textfield_commande.repaint();
		this.textfield_demande.repaint();
		this.txtrTrisflix.repaint();
		frame.validate();
		frame.repaint();
	}
}
