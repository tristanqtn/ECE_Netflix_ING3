package Vue;

/**
 * @author Tristan Querton
 *
 * Vue permettant d'afficher les résultats d'une recherche
 *
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
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

public class vue_catalogue {
	private JButton_arrondi retour;
	private JTextArea_arrondi titre;

	private ArrayList<ContenuCinematographique> contenus;
	private ArrayList<JButton> results;

	private Controleur_Modele modele;
	private Membre user;

	private ModernScrollPane scrollPane;
	private GroupLayout groupLayout;
	private JPanel panel;
	private String search;
	private String category;

	// CONSTRUCTEUR - allocation des éléments visuels
	public vue_catalogue(Controleur_Modele modele,Membre user, String search, String category) {
		this.modele=modele;
		this.user = user;
		this.search=search;
		this.category=category;
		retour = new JButton_arrondi("New button");
		retour.setText("");

		results = new ArrayList<JButton>();
		contenus = getResults(this.search,this.category);

		titre = new JTextArea_arrondi();
		panel = new JPanel();
		scrollPane = new ModernScrollPane(panel);
		configure();

	}
	
	public void setButtons() {//On crée les boutons contenant les affiches des contenus
		for(int i=0;i<contenus.size();i++) {
			JButton button =new JButton();
			button.setIcon(new ImageIcon(contenus.get(i).getAffiche()));
			button.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			button.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
			button.setBackground(Color.BLACK);
			results.add(button);
		}
	}

	public boolean findInArray(ArrayList<String> array, String string) {//on retourne vrai si on trouvbe la string dans l'array
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).equals(string)) {
				return true;
			}
		}
		return false;
	}
	
	public void addDocumentaireWithPreferences(Vector<Documentaire> documentaires, ArrayList<String> prefe, ArrayList<ContenuCinematographique> results) {
		for (int j = 0; j < documentaires.size(); j++) {// On ajoute les docu dont les genres match les preferences
			for (int i = 0; i < prefe.size(); i++) {
				if (findInArray(documentaires.get(j).getGenres(), prefe.get(i))) {
					results.add(documentaires.get(j));
					break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
				}
			}
		}
	}
	
	public void addRestOfDocumentaire(Vector<Documentaire> documentaires, ArrayList<ContenuCinematographique> results) {
		boolean found;
		for (int j = 0; j < documentaires.size(); j++) {// On ajoute les docu non ajouté avant
			found = false;
			for (int i = 0; i < results.size(); i++) {
				if (documentaires.get(j).getTitre().equals(results.get(i).getTitre())) {
					found = true;
				}
			}
			if (!found) {// S'il n'a pas été ajouté avant on le rajoute maintenant
				results.add(documentaires.get(j));
			}
		}
	}
	public void addFilmWithPreferences(Vector<Film> films, ArrayList<String> prefe, ArrayList<ContenuCinematographique> results) {
		for (int j = 0; j < films.size(); j++) {// On ajoute les docu dont les genres match les preferences
			for (int i = 0; i < prefe.size(); i++) {
				if (findInArray(films.get(j).getGenres(), prefe.get(i))) {
					results.add(films.get(j));
					break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
				}
			}
		}
	}
	
	public void addRestOfFilm(Vector<Film> films, ArrayList<ContenuCinematographique> results) {
		boolean found;
		for (int j = 0; j < films.size(); j++) {// On ajoute les docu non ajouté avant
			found = false;
			for (int i = 0; i < results.size(); i++) {
				if (films.get(j).getTitre().equals(results.get(i).getTitre())) {
					found = true;
				}
			}
			if (!found) {// S'il n'a pas été ajouté avant on le rajoute maintenant
				results.add(films.get(j));
			}
		}
	}
	public void addSerieWithPreferences(Vector<Serie> series, ArrayList<String> prefe, ArrayList<ContenuCinematographique> results) {
		for (int j = 0; j < series.size(); j++) {// On ajoute les docu dont les genres match les preferences
			for (int i = 0; i < prefe.size(); i++) {
				if (findInArray(series.get(j).getGenres(), prefe.get(i))) {
					results.add(series.get(j));
					break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
				}
			}
		}
	}
	
	public void addRestOfSerie(Vector<Serie> series, ArrayList<ContenuCinematographique> results) {
		boolean found;
		for (int j = 0; j < series.size(); j++) {// On ajoute les docu non ajouté avant
			found = false;
			for (int i = 0; i < results.size(); i++) {
				if (series.get(j).getTitre().equals(results.get(i).getTitre())) {
					found = true;
				}
			}
			if (!found) {// S'il n'a pas été ajouté avant on le rajoute maintenant
				results.add(series.get(j));
			}
		}
	}
	
	public void FiltersContenus(Vector<Documentaire> documentaires, Vector<Serie> series, Vector<Film> films) {
		for (int i = films.size() - 1; i >= 0; i--) {// On trie les films par rapport à la recherche
			if (!films.get(i).getTitre().contains(search)) {
				films.remove(i);
			}
		}
		for (int i = series.size() - 1; i >= 0; i--) {// On trie les series par rapport à la recherche
			if (!series.get(i).getTitre().contains(search)) {
				series.remove(i);
			}
		}
		for (int i = documentaires.size() - 1; i >= 0; i--) {// On trie les documentaires par rapport à la recherche
			if (!documentaires.get(i).getTitre().contains(search)) {
				documentaires.remove(i);
			}
		}
	}

	public ArrayList<ContenuCinematographique> getResults(String search, String category) {//On réalise l'algorithme de recherche et on stocke les films à afficher
		System.out.println("in results with catgory: "+category+" with search; "+search);
		ArrayList<ContenuCinematographique> results = new ArrayList<ContenuCinematographique>();
		Vector<Film> films = modele.getFilms();
		Vector<Documentaire> documentaires = modele.getDocumentaires();
		Vector<Serie> series = modele.getSeries();

		this.FiltersContenus(documentaires, series, films);


		if(category.equals("Tout")) {//L'utilisateur n'a pas selectionné de catégorie particulière
			ArrayList<String> prefe = user.getPreferences();
			System.out.println("Tout");
			if (findInArray(prefe, "Documentaire")) {//L'utilisateur a comme préférence documentaire
				System.out.println("Documentaire");
				this.addDocumentaireWithPreferences(documentaires, prefe, results);
				this.addRestOfDocumentaire(documentaires, results);
				this.addSerieWithPreferences(series, prefe, results);
				this.addFilmWithPreferences(films, prefe, results);
				this.addRestOfSerie(series, results);
				this.addRestOfFilm(films, results);
			} else {
				System.out.println("else");
				this.addSerieWithPreferences(series, prefe, results);
				this.addFilmWithPreferences(films, prefe, results);
				this.addDocumentaireWithPreferences(documentaires, prefe, results);
				this.addRestOfSerie(series, results);
				this.addRestOfFilm(films, results);
				this.addRestOfDocumentaire(documentaires, results);
			}
		}else {
			System.out.println("else");
			ArrayList<String> prefe = new ArrayList<String>();
			prefe.add(category);
			if (findInArray(prefe, "Documentaire")) {//L'utilisateur a comme préférence documentaire
				System.out.println("Documentaire");
				this.addDocumentaireWithPreferences(documentaires, prefe, results);
				this.addSerieWithPreferences(series, prefe, results);
				this.addFilmWithPreferences(films, prefe, results);
			} else {
				System.out.println("else");
				this.addSerieWithPreferences(series, prefe, results);
				this.addFilmWithPreferences(films, prefe, results);
				this.addDocumentaireWithPreferences(documentaires, prefe, results);
			}
		}
		
			
		for (int i = 0; i < results.size(); i++) {//On affiche les résultats
			System.out.print("Titre : " + results.get(i).getTitre() + " genre: [");
			String buffer = "";
			for (int j = 0; j < results.get(i).getGenres().size(); j++) {
				buffer += results.get(i).getGenres().get(j);
				if (j < (results.get(i).getGenres().size() - 1)) {
					buffer += ", ";
				}
			}
			System.out.println(buffer + "]");
		}
		return results;
	}
	
	public void configure() {//On configure les éléments
		retour.setBackground(Color.BLACK);
		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));

		setButtons();

		titre.setText(" FLOU-FLIX ");
		titre.setTabSize(20);
		titre.setForeground(Color.RED);
		titre.setFont(new Font("Dialog", Font.BOLD, 50));
		titre.setEditable(false);
		titre.setBackground(Color.BLACK);

		panel.setBackground(Color.BLACK);
		panel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollPane.setViewportView(panel);
		scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.setLayout(new GridLayout(0, 7, 10, 10));
		
		for(int i=0;i<results.size();i++) {
			panel.add(results.get(i));
		}
	}

	// initialisation - placemement des éléments visuels
	public void initialize(JFrame frame) {

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
				.addComponent(titre, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE).addGap(419))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(37).addComponent(titre,
										GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
						.addGap(72).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)));

		
		
		frame.getContentPane().setLayout(groupLayout);
		
		repaint(frame);
	}

	// GETTERS
	public JButton_arrondi getRetour() {
		return retour;
	}

	public ArrayList<JButton> getContenus() {
		return this.results;
	}

	public ContenuCinematographique getRecomandation(int i) {
		return this.contenus.get(i);
	}

	// re-affichage des éléments graphiques
	public void repaint(JFrame frame) {
		this.retour.repaint();
		this.titre.repaint();
		this.scrollPane.repaint();
		this.panel.repaint();
		
		for(int i=0;i<results.size();i++) {
			this.results.get(i).repaint();
		}

		frame.validate();
		frame.repaint();
	}

	// suppression des éléments visuels
	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.titre);
		frame.getContentPane().remove(this.scrollPane);
		frame.getContentPane().remove(this.panel);

		repaint(frame);
	}

	// GETTERS & SETTERS
	public GroupLayout getGroupLayout() {
		return groupLayout;
	}

	public void setGroupLayout(GroupLayout groupLayout) {
		this.groupLayout = groupLayout;
	}
}