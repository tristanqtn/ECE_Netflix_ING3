package Vue;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controleur.Controleur_Modele;
import ElementsVisuels.JButton_arrondi;
import Entite.ContenuCinematographique;
import Entite.Documentaire;
import Entite.Film;
import Entite.Membre;
import Entite.Serie;

/*
 * 
 * @author Clement BROT
 */

public class vue_catalogue {

	private JPanel panel;
	private JButton_arrondi btnNewButton_4;
	private JLabel lblNewLabel;
	private JButton retour;
	private JButton_arrondi btnNewButton;
	private Controleur_Modele modele;
	private Membre user;
	private String search;

	public vue_catalogue(Controleur_Modele modele, Membre user, String search) {
		this.search = search;
		this.user = user;
		this.modele = modele;
		panel = new JPanel();
		btnNewButton_4 = new JButton_arrondi("");
		lblNewLabel = new JLabel("catalogue");
		retour = new JButton("Retour");
		btnNewButton = new JButton_arrondi("");
	}

	public JButton getRetour() {
		return retour;
	}

	public boolean findInArray(ArrayList<String> array, String string) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).equals(string)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<ContenuCinematographique> getResults(String search) {
		ArrayList<ContenuCinematographique> results = new ArrayList<ContenuCinematographique>();
		Vector<Film> films = modele.getFilms();
		Vector<Documentaire> documentaires = modele.getDocumentaires();
		Vector<Serie> series = modele.getSeries();

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

		ArrayList<String> prefe = user.getPreferences();

		boolean found;

		if (findInArray(prefe, "Documentaire")) {
			for (int j = 0; j < documentaires.size(); j++) {// On ajoute les docu dont les genres match les preferences
				for (int i = 0; i < prefe.size(); i++) {
					if (findInArray(documentaires.get(j).getGenres(), prefe.get(i))) {
						results.add(documentaires.get(j));
						break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
					}
				}
			}
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
			for (int j = 0; j < series.size(); j++) {// On ajoute les séries dont les genres match les preferences
				for (int i = 0; i < prefe.size(); i++) {
					if (findInArray(series.get(j).getGenres(), prefe.get(i))) {
						results.add(series.get(j));
						break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
					}
				}
			}
			for (int j = 0; j < films.size(); j++) {// On ajoute les films dont les genres match les preferences
				for (int i = 0; i < prefe.size(); i++) {
					if (findInArray(films.get(j).getGenres(), prefe.get(i))) {
						results.add(films.get(j));
						break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
					}
				}
			}
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
		} else {
			for (int j = 0; j < series.size(); j++) {// On ajoute les séries dont les genres match les preferences
				for (int i = 0; i < prefe.size(); i++) {
					if (findInArray(series.get(j).getGenres(), prefe.get(i))) {
						results.add(series.get(j));
						break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
					}
				}
			}
			for (int j = 0; j < films.size(); j++) {// On ajoute les films dont les genres match les preferences
				for (int i = 0; i < prefe.size(); i++) {
					if (findInArray(films.get(j).getGenres(), prefe.get(i))) {
						results.add(films.get(j));
						break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
					}
				}
			}
			for (int j = 0; j < documentaires.size(); j++) {// On ajoute les docu dont les genres match les preferences
				for (int i = 0; i < prefe.size(); i++) {
					if (findInArray(documentaires.get(j).getGenres(), prefe.get(i))) {
						results.add(documentaires.get(j));
						break;// On sort de la boucle de prefe pour ne pas ajouter le docu plusieurs fois
					}
				}
			}
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
		for (int i = 0; i < results.size(); i++) {
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

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {

		getResults(this.search);

		panel.setBackground(Color.BLACK);

		btnNewButton_4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/profil.png").getPath()));
		btnNewButton_4.setBackground(Color.DARK_GRAY);

		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 25));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE).addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(27).addComponent(retour)
						.addPreferredGap(ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addGap(341)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addGap(50)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(34)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(retour).addComponent(btnNewButton_4,
														GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		btnNewButton.setBackground(Color.BLACK);
		// **************************modulable **************************************//
		btnNewButton
				.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/affiche/titanic.jpg").getPath()));
		// **************************************************************************//
		panel.add(btnNewButton);
		frame.getContentPane().setLayout(groupLayout);

		repaint(frame);
	}

	/*
	 * private JPanel panel; private JButton_arrondi btnNewButton_4; private JLabel
	 * lblNewLabel; private JButton retour; private JButton_arrondi btnNewButton;
	 */

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.panel);
		frame.getContentPane().remove(this.btnNewButton_4);
		frame.getContentPane().remove(this.lblNewLabel);
		frame.getContentPane().remove(this.retour);

		repaint(frame);
	}

	public void repaint(JFrame frame) {
		this.panel.repaint();
		this.btnNewButton_4.repaint();
		this.lblNewLabel.repaint();
		this.retour.repaint();

		frame.validate();
		frame.repaint();
	}
}