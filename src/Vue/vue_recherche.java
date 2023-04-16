package Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;
import ElementsVisuels.JTextField_arrondi;

/**
 * 
 * @author tristan querton
 *
 *         Cette vue permet à l'utilisateur de cherche un films / docu /episode
 *         selon un titre (complet ou partiel) et selon des catégories
 *
 */

public class vue_recherche {

	private JTextField_arrondi txtRecherche;
	private JLabel lblRecherche;
	private JButton_arrondi retour;
	private JButton_arrondi boutonRecherche;
	private JTextArea_arrondi txtrTrisflix;
	private JComboBox<String> comboBox;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame frame_1 = new JFrame("FLOU-FLIX");
//
//					frame_1.getContentPane().setForeground(new Color(64, 128, 128));
//					frame_1.getContentPane().setBackground(new Color(0, 0, 0));
//					frame_1.setBounds(100, 100, 1150, 700);
//					frame_1.setMinimumSize(new Dimension(1150, 700));
//					frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//					vue_recherche vue = new vue_recherche();
//					frame_1.setVisible(true);
//					vue.initialize(frame_1);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	// CONSTRUCTEUR - allocation des éléments visuels
	public vue_recherche() {
		txtRecherche = new JTextField_arrondi();
		txtRecherche.setBackground(Color.BLACK);
		txtRecherche.setForeground(Color.WHITE);
		lblRecherche = new JLabel("Rechercher un contenu");
		retour = new JButton_arrondi();
		boutonRecherche = new JButton_arrondi("Chercher");
		txtrTrisflix = new JTextArea_arrondi();
		comboBox = new JComboBox<String>();

	}

	// GETTERS
	public String getRecherche() {
		return this.txtRecherche.getText();
	}

	public JButton_arrondi getButtonRecherche() {
		return this.boutonRecherche;
	}

	public String getDropDownMenuChoice() {
		return this.comboBox.getItemAt(this.comboBox.getSelectedIndex());
	}

	public JButton_arrondi getRetour() {
		return this.retour;
	}

	// initialisation - placemement et configuration des éléments visuels
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(JFrame frame) {
		txtRecherche.setColumns(10);

		lblRecherche.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		lblRecherche.setForeground(Color.RED);

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

		comboBox.setBackground(Color.BLACK);
		comboBox.setForeground(Color.RED);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Tout", "Action", "Comedie", "Romantique", "Armée",
				"Thriller", "Science-Fiction", "Sport", "Culture", "Documentaire", "Animalier", "Drame" }));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(1051, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(169).addComponent(lblRecherche).addGap(72)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(txtRecherche, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
										.addGap(82)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 159,
												GroupLayout.PREFERRED_SIZE)
										.addGap(181))
								.addGroup(
										groupLayout.createSequentialGroup()
												.addComponent(txtrTrisflix, GroupLayout.DEFAULT_SIZE, 318,
														Short.MAX_VALUE)
												.addGap(422))))
				.addGroup(groupLayout
						.createSequentialGroup().addGap(508).addComponent(boutonRecherche, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(533, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(115).addComponent(txtrTrisflix, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
				.addGap(64)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRecherche, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecherche, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(boutonRecherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(250)));
		frame.getContentPane().setLayout(groupLayout);

		repaint(frame);
	}

	// suppression des éléments visuels
	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.comboBox);
		frame.getContentPane().remove(this.lblRecherche);
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.txtRecherche);
		frame.getContentPane().remove(this.boutonRecherche);
		frame.getContentPane().remove(this.txtrTrisflix);

		repaint(frame);
	}

	// re-affichage des éléments graphiques
	public void repaint(JFrame frame) {
		this.lblRecherche.repaint();
		this.retour.repaint();
		this.comboBox.repaint();
		this.txtRecherche.repaint();
		this.boutonRecherche.repaint();
		this.txtrTrisflix.repaint();

		frame.validate();
		frame.repaint();

	}

	// gestion des input
	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}