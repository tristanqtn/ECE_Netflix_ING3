package Controleur;

import java.sql.SQLException;
import java.util.Vector;

import Entite.Documentaire;
import Entite.Episode;
import Entite.Film;
import Entite.Membre;
import Entite.Saison;
import Entite.Serie;
import Modele.BDD_exploitant;

/**
 * 
 * @author tristan querton
 * 
 *         Cette classe utilise un exploitant de BDD pour gerer les
 *         bibliothèques de videos. Dès sa construction elle utilise le modele
 *         pour exploiter la BDD
 * 
 *         Le constructeur propose une fonction de RESET de la BDD qui la
 *         supprime et la regenere pour eviter les problème d'insertion.
 * 
 *
 */

public class Controleur_Modele {

	private BDD_exploitant exploit = null;

	private Vector<Membre> membres;
	private Vector<Documentaire> documentaires;
	private Vector<Film> films;
	private Vector<Serie> series;

	// les classes saisons ne devraient pas être utilisée en dehors de la classe
	// controleur modele car ces obj sont deja contenus dans le vecteur de series
	private Vector<Saison> saisons;
	private Vector<Episode> episodes;

	// CONSTRUCTEUR DU CONTROLEUR DE MODELE
	public Controleur_Modele(String utilisateur, String mdp, boolean reset) {
		try {
			this.exploit = new BDD_exploitant(utilisateur, mdp, reset); // initialisation de l'interface de BDD

			// RECUPERATION DES DONNES DE LA BASE
			this.documentaires = exploit.extraire_documentaires_BDD();
			this.membres = exploit.extraire_membre_BDD();
			this.films = exploit.extraire_films_BDD();
			this.series = exploit.extraire_series_BDD();
			this.saisons = exploit.extraire_saisons_BDD();
			this.episodes = exploit.extraire_episodes_BDD();

			assembleur_serie(this.series, this.saisons, this.episodes); // formation de l'arborescence
																		// series/saisons/episodes

		} catch (SQLException e) {
			// gestion des exceptions
			e.printStackTrace();
		}
	}

	// FONCTION QUI REUNI LES EPISODES DANS LES SAISONS ET LES SAISONS DANS LES
	// SERIES
	private void assembleur_serie(Vector<Serie> series, Vector<Saison> saisons, Vector<Episode> episodes) {
		for (int i = 0; i < episodes.size(); i++) {// parcours des episodes
			for (int j = 0; j < saisons.size(); j++) {// parcours des saisons
				if (episodes.get(i).getID_saison() == saisons.get(j).getID()) {// si l'episode appartient à la saison
					episodes.get(i).setID_serie(saisons.get(j).getIDserie()); // modification de l'ID de serie de
																				// l'episode
					saisons.get(j).ajouter_episode(episodes.get(i)); // ajout de l'episode dans la saison
				}
			}
		}
		for (int i = 0; i < saisons.size(); i++) {// parcours des saisons
			for (int j = 0; j < series.size(); j++) {// parcours des series
				if (saisons.get(i).getIDserie() == series.get(j).getID()) {// si la saison appartient à la serie
					series.get(j).ajouter_saison(saisons.get(i)); // ajout de la saison dans la serie
				}
			}
		}
	}

	public Vector<Membre> getMembres() {
		return membres;
	}

	public void setMembres(Vector<Membre> membres) {
		this.membres = membres;
	}

	public Vector<Documentaire> getDocumentaires() {
		return documentaires;
	}

	public void setDocumentaires(Vector<Documentaire> documentaires) {
		this.documentaires = documentaires;
	}

	public Vector<Film> getFilms() {
		return films;
	}

	public void setFilms(Vector<Film> films) {
		this.films = films;
	}

	public Vector<Serie> getSeries() {
		return series;
	}

	public void setSeries(Vector<Serie> series) {
		this.series = series;
	}

	// AFFICHGE DOCUMENTAIRES
	public void afficher_documentaires() {
		System.out.println("\nDOCUMENTAIRES\n");
		for (int i = 0; i < documentaires.size(); i++) {
			System.out.println(documentaires.get(i).toString());
		}
	}

	// AFFICHGE MEMBRES
	public void afficher_membres() {
		System.out.println("\nMEMBRES\n");
		for (int i = 0; i < membres.size(); i++) {
			System.out.println(membres.get(i).toString());
		}
	}

	// AFFICHGE FILMS
	public void afficher_films() {
		System.out.println("\nFILMS\n");
		for (int i = 0; i < films.size(); i++) {
			System.out.println(films.get(i).toString());
		}
	}

	// AFFICHGE SERIES
	public void afficher_series() {
		System.out.println("\nSERIES\n");
		for (int i = 0; i < series.size(); i++) {
			System.out.println(series.get(i).toString());
		}
	}

	// AFFICHGE SAISONS
	public void afficher_saisons() {
		System.out.println("\nSAISONS\n");
		for (int i = 0; i < saisons.size(); i++) {
			System.out.println(saisons.get(i).toString());
		}
	}

	// AFFICHGE EPISODES
	public void afficher_episodes() {
		System.out.println("\nEPISODES\n");
		for (int i = 0; i < episodes.size(); i++) {
			System.out.println(episodes.get(i).toString());
		}
	}

	// FONCTION D'AJOUT D'UN NOUVEAU MEMBRE DANS LA BDD
	public void sauver_nv_membre_BDD(Membre nv_membre) {
		exploit.ajouter_membre_BDD(nv_membre);
	}
}
