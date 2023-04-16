package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controleur.Controleur_Modele;
import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;
import ElementsVisuels.ModernScrollPane;
import Entite.ContenuCinematographique;
import Entite.Documentaire;
import Entite.Episode;
import Entite.Film;
import Entite.Membre;
import Entite.Visionnage;

public class accueil {

	private JButton_arrondi recherche;
	private JButton_arrondi retour;
	private JButton_arrondi compte;
	private ModernScrollPane presentationScroll;
	private JPanel presentation;
	private JTextArea_arrondi titre;

	private ArrayList<ArrayList<ContenuCinematographique>> contenus;
	private ArrayList<String> categories;
	private ArrayList<ArrayList<JButton>> recomendations;
	private ArrayList<JPanel> panels;
	private ArrayList<ModernScrollPane> panelsScroll;
	private ArrayList<JLabel> labels;

	private Controleur_Modele modele;
	private Membre user;

	/**
	 * Create the application.
	 */
	public accueil(Membre user) {
		modele = new Controleur_Modele("root", "root", false);
		this.user = user;
		recherche = new JButton_arrondi("Recherche");
		recherche.setBackground(Color.RED);
		recherche.setForeground(Color.WHITE);
		retour = new JButton_arrondi("New button");
		retour.setText("");
		compte = new JButton_arrondi("");
		presentation = new JPanel();
		presentation.setLayout(new BoxLayout(presentation, BoxLayout.Y_AXIS));
		presentation.setAlignmentY(Component.LEFT_ALIGNMENT);
		presentationScroll = new ModernScrollPane(presentation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		recomendations = new ArrayList<ArrayList<JButton>>();
		contenus = new ArrayList<ArrayList<ContenuCinematographique>>();
		categories = new ArrayList<String>();
		panels = new ArrayList<JPanel>();
		panelsScroll = new ArrayList<ModernScrollPane>();
		labels = new ArrayList<JLabel>();

		titre = new JTextArea_arrondi();

	}

	public Vector<ContenuCinematographique> findFilms(Membre user) {// On va déterminer ici les films contenus dans les
		// JPanels et les noms de
		// catégories proposées
		Vector<Visionnage> visio = modele.getVisionnages();
		Vector<Documentaire> docu = modele.getDocumentaires();
		Vector<Film> films = modele.getFilms();
		Vector<Episode> episodes = modele.getEpisodes();

		Vector<ContenuCinematographique> en_cours = new Vector<ContenuCinematographique>();
		for (int i = 0; i < visio.size(); i++) {
			if (visio.get(i).getID_membre() == user.getID() && visio.get(i).getTime_code() > 0) {
				if (visio.get(i).getID_documentaire() != 0) {
					for (int j = 0; j < docu.size(); j++) {
						if (docu.get(j).getID() == visio.get(i).getID_documentaire()) {
							en_cours.add(docu.get(j));
						}
					}
				}
				if (visio.get(i).getID_film() != 0) {
					for (int j = 0; j < films.size(); j++) {
						if (films.get(j).getID() == visio.get(i).getID_film()) {
							en_cours.add(films.get(j));
						}
					}
				}
				if (visio.get(i).getID_episode() != 0 && visio.get(i).getID_saison() != 0
						&& visio.get(i).getID_serie() != 0) {
					for (int j = 0; j < episodes.size(); j++) {
						if (episodes.get(j).getID() == visio.get(i).getID_episode()
								&& episodes.get(j).getID_saison() == visio.get(i).getID_saison()
								&& episodes.get(j).getID_serie() == visio.get(i).getID_serie()) {
							en_cours.add(episodes.get(j));
						}
					}
				}
			}
		}
		return en_cours;

	}

	public void setRecomandations() {
		int listeSize = 5;
		ArrayList<JButton> liste;
		ArrayList<ContenuCinematographique> listeContenus;
		Vector<ContenuCinematographique> vu = findFilms(user);

		ArrayList<Integer> listesSizes = new ArrayList<Integer>();
		listesSizes.add(vu.size());
		for (int i = 0; i < (listeSize - 1); i++) {
			listesSizes.add(modele.getFilms().size());
		}

		for (int j = 0; j < listeSize; j++) {
			liste = new ArrayList<JButton>();
			listeContenus = new ArrayList<ContenuCinematographique>();
			categories.add("Films");
			if (j == 0) {
				for (int i = 0; i < listesSizes.get(j); i++) {
					liste.add(new JButton(""));
					listeContenus.add(vu.get(i));
					System.out.println(vu.get(i).getAffiche());
					liste.get(i).setIcon(new ImageIcon(vu.get(i).getAffiche()));
					liste.get(i).setBorder(javax.swing.BorderFactory.createEmptyBorder());
				}
			} else {
				for (int i = 0; i < listesSizes.get(j); i++) {
					liste.add(new JButton(""));
					listeContenus.add(modele.getFilms().get(i));
					System.out.println(modele.getFilms().get(i).getAffiche());
					liste.get(i).setIcon(new ImageIcon(modele.getFilms().get(i).getAffiche()));
					liste.get(i).setBorder(javax.swing.BorderFactory.createEmptyBorder());
				}
			}
			recomendations.add(liste);
			contenus.add(listeContenus);
		}

		for (int j = 0; j < listeSize; j++) {
			JLabel label = new JLabel("label");
			JPanel panel = new JPanel();
			label.setForeground(Color.RED);
			label.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));
			labels.add(label);
			ModernScrollPane panelScroll = new ModernScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			panelScroll.setMaximumSize(new Dimension(1100, 500));
			panelScroll.setMinimumSize(new Dimension(1100, 500));
			panelScroll.setViewportView(panel);
			panelScroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			panel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			panel.setBackground(Color.BLACK);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.setAlignmentX(Component.LEFT_ALIGNMENT);
			panels.add(panel);
			panelsScroll.add(panelScroll);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {

		retour.setBackground(Color.BLACK);
		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));

		setRecomandations();

		presentation.setBackground(Color.BLACK);
		presentation.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		presentationScroll.setBackground(Color.BLACK);
		presentationScroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());

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
				.addComponent(presentationScroll, GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE));
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
						.addGap(33).addComponent(presentationScroll, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)));

		// panel_en_cours.setLayout(new BoxLayout(panel_en_cours, BoxLayout.X_AXIS));

		// panel_recommendations.setLayout(new BoxLayout(panel_recommendations,
		// BoxLayout.X_AXIS));
		presentationScroll.setViewportView(presentation);
		for (int i = 0; i < this.panelsScroll.size(); i++) {
			presentation.add(labels.get(i));
			presentation.add(this.panelsScroll.get(i));
			presentation.add(Box.createRigidArea(new Dimension(0, 30)));
		}
		for (int j = 0; j < recomendations.size(); j++) {
			for (int i = 0; i < recomendations.get(j).size(); i++) {
				recomendations.get(j).get(i).setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
				recomendations.get(j).get(i).setBackground(Color.BLACK);
				panels.get(j).add(recomendations.get(j).get(i));
				if (i < (recomendations.get(j).size() - 1)) {
					panels.get(j).add(Box.createRigidArea(new Dimension(5, 0)));
				}
			}
		}

		frame.getContentPane().setLayout(groupLayout);
	}

	public JButton_arrondi getRetour() {
		return retour;
	}

	public JButton_arrondi getRecherche() {
		return this.recherche;
	}

	public JButton_arrondi getCompte() {
		return this.compte;
	}

	public ArrayList<ArrayList<JButton>> getFilms() {
		return this.recomendations;
	}

	public ContenuCinematographique getRecomandation(int i, int j) {
		return this.contenus.get(i).get(j);
	}

	public void repaint(JFrame frame) {
		this.retour.repaint();
		this.recherche.repaint();
		this.compte.repaint();
		this.presentation.repaint();
		this.titre.repaint();
		this.presentationScroll.repaint();

		for (int i = 0; i < this.labels.size(); i++) {
			this.labels.get(i).repaint();
		}
		for (int i = 0; i < this.panels.size(); i++) {
			panels.get(i).repaint();
		}
		for (int i = 0; i < this.panelsScroll.size(); i++) {
			panelsScroll.get(i).repaint();
		}
		for (int i = 0; i < this.recomendations.size(); i++) {
			for (int j = 0; j < this.recomendations.get(i).size(); j++) {
				this.recomendations.get(i).get(j).repaint();
			}
		}

		frame.validate();
		frame.repaint();
	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.recherche);
		frame.getContentPane().remove(this.compte);
		frame.getContentPane().remove(this.presentationScroll);
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.titre);

		repaint(frame);
	}
}
