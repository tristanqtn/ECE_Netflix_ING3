package Vue;
/*
* @author Francois Bonnet
*
*
*/
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
import Entite.Serie;
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
		configure();

	}
	
	public void configure() {//On configure les éléments

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
	}

	public Vector<ContenuCinematographique> findFilms(Membre user) {// On va déterminer ici les films contenus dans les
																	// JPanels et les noms de catégories proposées
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

	public ArrayList<ContenuCinematographique> getContenus() {//On mets tous les contenuCinematographique dans un seul array
		ArrayList<ContenuCinematographique> contenus = new ArrayList<ContenuCinematographique>();
		Vector<Serie> series = modele.getSeries();
		for (int i = 0; i < series.size(); i++) {
			contenus.add(series.get(i));
		}
		Vector<Film> films = modele.getFilms();
		for (int i = 0; i < films.size(); i++) {
			contenus.add(films.get(i));
		}
		Vector<Documentaire> documentaires = modele.getDocumentaires();
		for (int i = 0; i < documentaires.size(); i++) {
			contenus.add(documentaires.get(i));
		}
		return contenus;
	}

	public boolean containsString(ArrayList<String> array, String string) {//On retourne vrai si la string est contenue dans l'array
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).equals(string)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<ContenuCinematographique> getContenusWithPreference(ArrayList<ContenuCinematographique> contenus,
			String category) {//on retourne un array de contenus dont un genre est le meme que category
		ArrayList<ContenuCinematographique> results = new ArrayList<ContenuCinematographique>();
		for (int i = 0; i < contenus.size(); i++) {
			if (containsString(contenus.get(i).getGenres(), category)) {
				results.add(contenus.get(i));
			}
		}
		return results;
	}

	public void setRecomandations() {//On réalise l'algorithme de recommandations et on les stocke dans les variables
		ArrayList<JButton> liste;
		ArrayList<ContenuCinematographique> listeContenus;
		Vector<ContenuCinematographique> vu = findFilms(user);
		ArrayList<ContenuCinematographique> contenusTotaux = getContenus();
		ArrayList<ContenuCinematographique> contenusTries;
		Vector<Film> films = modele.getFilms();
		Vector<Serie> series = modele.getSeries();
		ArrayList<Integer> listesSizes = new ArrayList<Integer>();

		if (vu.size() > 0) {// on met les contenus à continuer
			categories.add("Continuer à regarder");
			listesSizes.add(vu.size());
			liste = new ArrayList<JButton>();
			listeContenus = new ArrayList<ContenuCinematographique>();
			for (int i = 0; i < vu.size(); i++) {
				JButton button2 = new JButton("");
				button2.setIcon(new ImageIcon(vu.get(i).getAffiche()));
				button2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				button2.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
				button2.setBackground(Color.BLACK);
				liste.add(button2);
				listeContenus.add(vu.get(i));
				System.out.println(vu.get(i).getAffiche());
			}
			recomendations.add(liste);
			contenus.add(listeContenus);
		}
		for (int i = 0; i < user.getPreferences().size(); i++) {// On met les préférences de l'utilisateur
			contenusTries = getContenusWithPreference(contenusTotaux, user.getPreferences().get(i));
			categories.add(user.getPreferences().get(i));
			listesSizes.add(contenusTries.size());
			liste = new ArrayList<JButton>();
			listeContenus = new ArrayList<ContenuCinematographique>();
			for (int j = 0; j < contenusTries.size(); j++) {
				liste.add(new JButton(""));
				listeContenus.add(contenusTries.get(j));
				System.out.println(contenusTries.get(j).getAffiche());
				liste.get(j).setIcon(new ImageIcon(contenusTries.get(j).getAffiche()));
				liste.get(j).setBorder(javax.swing.BorderFactory.createEmptyBorder());
			}
			recomendations.add(liste);
			contenus.add(listeContenus);
		}

		if (contenus.size() <= 2) {
			// On met des films
			categories.add("Films");
			listesSizes.add(films.size());
			liste = new ArrayList<JButton>();
			listeContenus = new ArrayList<ContenuCinematographique>();
			for (int j = 0; j < films.size(); j++) {
				liste.add(new JButton(""));
				listeContenus.add(films.get(j));
				System.out.println(films.get(j).getAffiche());
				liste.get(j).setIcon(new ImageIcon(films.get(j).getAffiche()));
				liste.get(j).setBorder(javax.swing.BorderFactory.createEmptyBorder());
			}
			recomendations.add(liste);
			contenus.add(listeContenus);

			// On met des series
			categories.add("Series");
			listesSizes.add(series.size());
			liste = new ArrayList<JButton>();
			listeContenus = new ArrayList<ContenuCinematographique>();
			for (int j = 0; j < series.size(); j++) {
				liste.add(new JButton(""));
				listeContenus.add(series.get(j));
				System.out.println(series.get(j).getAffiche());
				liste.get(j).setIcon(new ImageIcon(series.get(j).getAffiche()));
				liste.get(j).setBorder(javax.swing.BorderFactory.createEmptyBorder());
			}
			recomendations.add(liste);
			contenus.add(listeContenus);
		}

		for (int j = 0; j < contenus.size(); j++) {//On ajoute le nombre de panels correspondants 
			JLabel label = new JLabel(this.categories.get(j));
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
	public void initialize(JFrame frame) {//On affiche la vue dans frame

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

		
		presentationScroll.setViewportView(presentation);//On ajoute les panelsScroll
		for (int i = 0; i < this.panelsScroll.size(); i++) {
			presentation.add(labels.get(i));
			presentation.add(this.panelsScroll.get(i));
			presentation.add(Box.createRigidArea(new Dimension(0, 30)));
		}
		for (int j = 0; j < recomendations.size(); j++) {//On ajoute les panels dans panelsScroll
			for (int i = 0; i < recomendations.get(j).size(); i++) {
				panels.get(j).add(recomendations.get(j).get(i));//On ajoute les boutons avec les affiches
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

	public void repaint(JFrame frame) {//On rafraichit la vue
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

	public void delete(JFrame frame) {//On retire les éléments de frame
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.recherche);
		frame.getContentPane().remove(this.compte);
		frame.getContentPane().remove(this.presentationScroll);
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.titre);

		repaint(frame);
	}
}
