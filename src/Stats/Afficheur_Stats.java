package Stats;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

import Entite.Membre;

/**
 * 
 * @author Tristan Querton
 * 
 *         Cette classe est responsable de l'affichage des statisques de
 *         visionnage de l'application
 * 
 *         Utilise les classes open-source Bar.java / ColorIcon.java /
 *         HistogramPanel.java de Camickr
 *
 */
public class Afficheur_Stats {

	// CONSTRUCTEUR
	public Afficheur_Stats(Vector<Membre> membres) {
		afficher_statistiques_temps_visionnage(membres);
		afficher_statistiques_nb_contenus_vu(membres);
	}

	// FONCTION D'AFFICHE DU GRAPHE DE TEMPS DE VISIONNAGE
	public void afficher_statistiques_temps_visionnage(Vector<Membre> membres) {
		HistogramPanel panel = new HistogramPanel();// création du panel
		for (int i = 0; i < membres.size(); i++) {// pour chaque membres
			if (membres.get(i).getAdmin() == false)// si l'utilisateur n'est pas admin
				panel.addHistogramColumn(membres.get(i).getPrenom(), (membres.get(i).getTemps_visionnage() / 60),
						Color.RED);// ajout
									// d'une
									// colonne
									// pour
									// l'utilisateur
									// et
									// sa
									// stat
		}

		panel.layoutHistogram();// constitution du graphe

		JFrame frame = new JFrame("Statistique de temps visionnage");// creation de la frame additionnelle
		frame.add(panel);// ajout du panel
		// AFFICHAGE DE LA FENETRE GRAPHE
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}

	// FONCTION D'AFFICHE DU GRAPHE DU NOMBRE DE CONTENUS VISIONNES
	public void afficher_statistiques_nb_contenus_vu(Vector<Membre> membres) {
		HistogramPanel panel = new HistogramPanel(); // création du panel
		for (int i = 0; i < membres.size(); i++) {// pour chaque membres
			if (membres.get(i).getAdmin() == false)// si l'utilisateur n'est pas admin
				panel.addHistogramColumn(membres.get(i).getPrenom(), membres.get(i).getNb_film_vu(), Color.RED); // ajout
																													// d'une
																													// colonne
																													// pour
																													// l'utilisateur
																													// et
																													// sa
																													// stat
		}

		panel.layoutHistogram(); // constitution du graphe

		JFrame frame = new JFrame("Statistique du nombre de contenus vus"); // creation de la frame additionnelle
		frame.add(panel);// ajout du panel
		// AFFICHAGE DE LA FENETRE GRAPHE
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}
}
