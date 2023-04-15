package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;

public class accueil {

	private JButton_arrondi recherche;
	private JButton_arrondi retour;
	private JButton_arrondi compte;
	private JPanel presentation;
	private JTextArea_arrondi titre;

	private JLabel label_recommendations;
	private JLabel label_en_cours;

	private JPanel panel_recommendations;
	private JPanel panel_en_cours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("FLOU-FLIX");

					frame.getContentPane().setForeground(new Color(64, 128, 128));
					frame.getContentPane().setBackground(new Color(0, 0, 0));
					frame.setBounds(100, 100, 1150, 700);
					frame.setMinimumSize(new Dimension(1150, 700));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					accueil vue = new accueil();
					frame.setVisible(true);
					vue.initialize(frame);
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
		recherche = new JButton_arrondi("Recherche");
		recherche.setBackground(Color.RED);
		recherche.setForeground(Color.WHITE);
		retour = new JButton_arrondi("New button");
		retour.setText("");
		compte = new JButton_arrondi("");
		presentation = new JPanel();
		presentation.setLayout(new BoxLayout(presentation, BoxLayout.Y_AXIS));
		presentation.setAlignmentY(Component.LEFT_ALIGNMENT);

		titre = new JTextArea_arrondi();

		label_recommendations = new JLabel("Recommendations");
		label_en_cours = new JLabel("En Cours");

		panel_en_cours = new JPanel();
		panel_en_cours.setBackground(Color.BLUE);
		panel_recommendations = new JPanel();
		panel_recommendations.setBackground(Color.RED);

		panel_en_cours.setLayout(new BoxLayout(panel_en_cours, BoxLayout.X_AXIS));
		panel_en_cours.setAlignmentX(Component.LEFT_ALIGNMENT);

		panel_recommendations.setLayout(new BoxLayout(panel_recommendations, BoxLayout.X_AXIS));
		panel_recommendations.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {

		label_recommendations.setForeground(Color.RED);
		label_en_cours.setForeground(Color.RED);

		retour.setBackground(Color.BLACK);
		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));

		presentation.setBackground(Color.BLACK);

		compte.setBackground(Color.DARK_GRAY);
		compte.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/profil.png").getPath()));

		titre.setText(" FLOU-FLIX ");
		titre.setTabSize(20);
		titre.setForeground(Color.RED);
		titre.setFont(new Font("Dialog", Font.BOLD, 50));
		titre.setEditable(false);
		titre.setBackground(Color.BLACK);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(recherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(17))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
										.addComponent(titre, GroupLayout.PREFERRED_SIZE, 291,
												GroupLayout.PREFERRED_SIZE)
										.addGap(336)))
						.addGap(10).addComponent(compte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addComponent(presentation, GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(compte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(37)
										.addComponent(titre, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addGap(29).addComponent(recherche, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(33).addComponent(presentation, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)));

		// panel_en_cours.setLayout(new BoxLayout(panel_en_cours, BoxLayout.X_AXIS));

		// panel_recommendations.setLayout(new BoxLayout(panel_recommendations,
		// BoxLayout.X_AXIS));
		presentation.add(label_en_cours);
		presentation.add(panel_en_cours);
		presentation.add(label_recommendations);
		presentation.add(panel_recommendations);

		panel_en_cours.add(new JButton());

		panel_recommendations.add(new JButton());

		frame.getContentPane().setLayout(groupLayout);
	}

	public JButton_arrondi getRetour() {
		return retour;
	}

	public JButton_arrondi get_recherche() {
		return this.recherche;
	}

	public JButton_arrondi get_compte() {
		return this.compte;
	}

	public void repaint(JFrame frame) {
		this.retour.repaint();
		this.recherche.repaint();
		this.compte.repaint();
		this.presentation.repaint();
		this.titre.repaint();

		frame.validate();
		frame.repaint();
	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.recherche);

		frame.getContentPane().remove(this.compte);
		frame.getContentPane().remove(this.presentation);
		frame.getContentPane().remove(this.titre);

		repaint(frame);
	}
}
