package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextField_arrondi;
import Entite.ContenuCinematographique;
import Entite.Documentaire;
import Entite.Film;
import Entite.Serie;

public class vue_previsualisation {
	private JTextField_arrondi realisateur;
	private JTextField_arrondi acteurs;
	private JTextField_arrondi genre;
	private JTextField_arrondi parution;
	private JButton_arrondi film;
	private JButton_arrondi btnNewButton;
	private JButton_arrondi affiche;
	private JTextPane presentation;
	private ContenuCinematographique contenu;
	private JButton_arrondi retour;
	private JTextArea titre;

	public vue_previsualisation(ContenuCinematographique contenu) {
		this.contenu = contenu;

		titre = new JTextArea();
		titre.setWrapStyleWord(true);
		titre.setBackground(Color.BLACK);
		titre.setForeground(Color.RED);
		titre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titre.setText(this.contenu.getTitre());
		realisateur = new JTextField_arrondi("Réalisateur : " + this.contenu.getRealisateur());
		realisateur.setEditable(false);
		ArrayList<String> acteursList = this.contenu.getActeurs();
		String buffer = "Acteurs : ";
		for (int i = 0; i < acteursList.size(); i++) {
			buffer += acteursList.get(i);
			if ((i + 1) < acteursList.size()) {
				buffer += ", ";
			}
		}
		acteurs = new JTextField_arrondi(buffer);
		acteurs.setEditable(false);
		ArrayList<String> GenresList = this.contenu.getGenres();
		buffer = "Genres : ";
		for (int i = 0; i < GenresList.size(); i++) {
			buffer += GenresList.get(i);
			if ((i + 1) < GenresList.size()) {
				buffer += ", ";
			}
		}
		genre = new JTextField_arrondi(buffer);
		genre.setEditable(false);
		parution = new JTextField_arrondi("Parution : " + this.contenu.getparution().toString());
		parution.setEditable(false);

		presentation = new JTextPane();
		presentation.setBackground(Color.BLACK);
		presentation.setForeground(Color.WHITE);
		presentation.setEditable(false);
		String buffer1 = String.format("%.2f", contenu.getNote());
		presentation.setText("Description : " + this.contenu.getDescription() + "\n\nDurée (min) : "
				+ this.contenu.getDuree() + "\n\nNote (/10) : " + buffer1);
		affiche = new JButton_arrondi();
		affiche.setForeground(Color.BLACK);

		ImageIcon imageIcon = new ImageIcon(this.contenu.getAffiche()); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(387, 495, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		affiche.setBackground(Color.BLACK);
		affiche.setIcon(imageIcon);
		film = new JButton_arrondi("Visionner ");
		film.setBackground(Color.RED);
		film.setForeground(Color.WHITE);
		btnNewButton = new JButton_arrondi("Visionner Trailer");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		retour = new JButton_arrondi();

	}

	public JButton_arrondi get_retour() {
		return retour;
	}

	public JButton_arrondi getVisionner() {
		return film;
	}

	public JButton_arrondi getTrailer() {
		return btnNewButton;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {

		realisateur.setForeground(Color.WHITE);
		realisateur.setBackground(Color.BLACK);
		realisateur.setColumns(10);

		acteurs.setForeground(Color.WHITE);
		acteurs.setBackground(Color.BLACK);
		acteurs.setColumns(10);

		genre.setForeground(Color.WHITE);
		genre.setBackground(Color.BLACK);
		genre.setColumns(10);

		parution.setForeground(Color.WHITE);
		parution.setBackground(Color.BLACK);
		parution.setColumns(10);

		retour.setBackground(Color.BLACK);

		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));
		retour.setBackground(new Color(0, 0, 0));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(retour, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(presentation, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
										.addComponent(genre, 330, 330, Short.MAX_VALUE)
										.addComponent(acteurs, 330, 330, Short.MAX_VALUE)
										.addComponent(realisateur, 330, 330, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(film, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(parution, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
								.addGap(293)
								.addComponent(affiche, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
								.addGap(64))
						.addGroup(groupLayout.createSequentialGroup().addGap(338)
								.addComponent(titre, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGap(436)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(retour, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(affiche, GroupLayout.PREFERRED_SIZE, 495,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(realisateur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(acteurs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(genre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(parution, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addComponent(presentation, GroupLayout.PREFERRED_SIZE, 237,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(film, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(59))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(28)
						.addComponent(titre, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGap(592)));
		frame.getContentPane().setLayout(groupLayout);

		repaint(frame);

	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.acteurs);
		frame.getContentPane().remove(this.affiche);
		frame.getContentPane().remove(this.btnNewButton);
		frame.getContentPane().remove(this.film);
		frame.getContentPane().remove(this.genre);
		frame.getContentPane().remove(this.parution);
		frame.getContentPane().remove(this.realisateur);
		frame.getContentPane().remove(this.presentation);
		frame.getContentPane().remove(this.titre);
		frame.getContentPane().remove(this.retour);
		repaint(frame);
	}

	public void set_information_film(Film contenu) {
		this.presentation.setText("Description : " + contenu.getDescription() + "\n\n Duree : " + contenu.getDuree()
				+ "\n\n Note : " + contenu.getNote());
		this.acteurs.setText("Acteurs : " + contenu.getActeurs().toString());
		this.genre.setText("Genres : " + contenu.getGenres().toString());
		this.realisateur.setText("Realisateurs : " + contenu.getRealisateur());
		this.titre.setText(contenu.getTitre());
		this.parution.setText("Parution : " + contenu.getparution());
		String buffer = String.format("%.2f", contenu.getNote());
		this.presentation.setText("Description : " + contenu.getDescription() + "\n\n Duree : " + contenu.getDuree()
				+ "\n\n Note : " + buffer);

	}

	public void set_information_documentaire(Documentaire contenu) {

		this.presentation.setText("Description : " + contenu.getDescription() + "\n\n Duree : " + contenu.getDuree()
				+ "\n\n Note : " + contenu.getNote());
		this.acteurs.setText("Acteurs : " + contenu.getActeurs().toString());
		this.genre.setText("Genres : " + contenu.getGenres().toString());
		this.realisateur.setText("Realisateurs : " + contenu.getRealisateur());
		this.titre.setText(contenu.getTitre());
		this.parution.setText("Parution : " + contenu.getparution());
		this.presentation.setText("Description : " + contenu.getDescription() + "\n\n Duree : " + contenu.getDuree()
				+ "\n\n Note : " + contenu.getNote());

	}

	public void set_information_episode(Serie contenu, int num_saison, int num_episode) {

		this.presentation.setText("Saison : " + contenu.getSaisons().get(num_saison - 1).getNum_saison() + " / "
				+ contenu.getNbDeSaisons() + "Episode : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getNumeroDEpisode()
				+ " / " + contenu.getSaisons().get(num_saison - 1).getNbDEpisode() + "\n\nDescription : "
				+ contenu.getDescription() + "\n\n Duree : " + contenu.getDuree() + "\n\n Note : " + contenu.getNote());

		this.acteurs.setText("Acteurs : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getActeurs().toString());

		this.genre.setText("Genres : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getGenres().toString());

		this.realisateur.setText("Realisateurs : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getRealisateur());

		this.titre.setText(contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getTitre());

		this.parution.setText("Parution : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getparution());

		this.presentation.setText("Description : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getDescription()
				+ "\n\n Duree : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getDuree()
				+ "\n\n Note : "
				+ contenu.getSaisons().get(num_saison - 1).getEpisodes().get(num_episode - 1).getNote());
	}

	public void repaint(JFrame frame) {
		this.acteurs.repaint();
		this.affiche.repaint();
		this.btnNewButton.repaint();
		this.film.repaint();
		this.genre.repaint();
		this.parution.repaint();
		this.realisateur.repaint();
		this.presentation.repaint();
		this.retour.repaint();

		frame.validate();
		frame.repaint();
	}

	public ContenuCinematographique get_contenu() {
		return contenu;
	}
}