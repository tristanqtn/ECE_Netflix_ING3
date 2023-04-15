package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;
import ElementsVisuels.JTextField_arrondi;

/**
 * 
 * @author Clément BROT
 *
 */

public class vue_recherche {

	private JTextField_arrondi txtRecherche;
	private JLabel lblRecherche;
	private JButton_arrondi btnAction;
	private JButton_arrondi btnAmour;
	private JButton_arrondi btnComedie;
	private JButton_arrondi btnDocumentaire;
	private JButton_arrondi retour;
	private JButton_arrondi boutonRecherche;
	private JTextArea_arrondi txtrTrisflix;

	public static void maint(String[] args) {
		JFrame frame = new JFrame("FLOU-FLIX");

		frame.getContentPane().setForeground(new Color(64, 128, 128));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1150, 700);
		frame.setMinimumSize(new Dimension(1150, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		vue_recherche recherche = new vue_recherche();

		recherche.initialize(frame);
	}

	public vue_recherche() {
		txtRecherche = new JTextField_arrondi();
		txtRecherche.setBackground(Color.BLACK);
		txtRecherche.setForeground(Color.WHITE);
		lblRecherche = new JLabel("Rechercher un contenu");
		btnAction = new JButton_arrondi("action");
		btnAction.setText("Action");
		btnAmour = new JButton_arrondi("amour");
		btnComedie = new JButton_arrondi("comédie");
		btnComedie.setText("Comédie");
		btnDocumentaire = new JButton_arrondi("documentaire");
		btnDocumentaire.setText("Documentaire");
		retour = new JButton_arrondi();
		boutonRecherche = new JButton_arrondi("Chercher");
		txtrTrisflix = new JTextArea_arrondi();

	}

	public String getRecherche() {
		return this.txtRecherche.getText();
	}

	public JButton_arrondi getButtonRecherche() {
		return this.boutonRecherche;
	}

	public JButton_arrondi getAction() {
		return this.btnAction;
	}

	public JButton_arrondi getAmour() {
		return this.btnAmour;
	}

	public JButton_arrondi getComedie() {
		return this.btnComedie;
	}

	public JButton_arrondi getDocumentaire() {
		return this.btnDocumentaire;
	}

	public JButton_arrondi getRetour() {
		return this.retour;
	}

	public void initialize(JFrame frame) {
		txtRecherche.setColumns(10);

		lblRecherche.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		lblRecherche.setForeground(Color.RED);

		btnAction.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		btnAction.setForeground(Color.WHITE);
		btnAction.setBackground(Color.RED);

		btnAmour.setText("Romantique");
		btnAmour.setForeground(Color.WHITE);
		btnAmour.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		btnAmour.setBackground(Color.RED);

		btnComedie.setForeground(Color.WHITE);
		btnComedie.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		btnComedie.setBackground(Color.RED);

		btnDocumentaire.setForeground(Color.WHITE);
		btnDocumentaire.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		btnDocumentaire.setBackground(Color.RED);

		boutonRecherche.setForeground(Color.WHITE);
		boutonRecherche.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		boutonRecherche.setBackground(Color.RED);

		retour.setBackground(Color.BLACK);
		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));
		txtrTrisflix.setText("  FLOU-FLIX ");
		txtrTrisflix.setTabSize(20);
		txtrTrisflix.setForeground(Color.RED);
		txtrTrisflix.setFont(new Font("Dialog", Font.BOLD, 50));
		txtrTrisflix.setEditable(false);
		txtrTrisflix.setBackground(Color.BLACK);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(1051, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(234).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(boutonRecherche, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnAction, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
												.addComponent(btnAmour, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(79)
												.addComponent(btnComedie, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(73).addComponent(btnDocumentaire, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(245, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblRecherche).addGap(41)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtRecherche, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
										.addComponent(txtrTrisflix, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
								.addGap(388)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(70).addComponent(txtrTrisflix, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
				.addGap(49)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRecherche, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(boutonRecherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(lblRecherche, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addGap(147)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDocumentaire, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnComedie, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAmour, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGap(204)));
		frame.getContentPane().setLayout(groupLayout);

		repaint(frame);
	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.btnAction);
		frame.getContentPane().remove(this.btnAmour);
		frame.getContentPane().remove(this.btnComedie);
		frame.getContentPane().remove(this.btnDocumentaire);
		frame.getContentPane().remove(this.lblRecherche);
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.txtRecherche);
		frame.getContentPane().remove(this.boutonRecherche);
		frame.getContentPane().remove(this.txtrTrisflix);

		repaint(frame);
	}

	public void repaint(JFrame frame) {

		this.btnAction.repaint();
		this.btnAmour.repaint();
		this.btnComedie.repaint();
		this.btnDocumentaire.repaint();
		this.lblRecherche.repaint();
		this.retour.repaint();
		this.txtRecherche.repaint();
		this.boutonRecherche.repaint();
		this.txtrTrisflix.repaint();

		frame.validate();
		frame.repaint();

	}
}