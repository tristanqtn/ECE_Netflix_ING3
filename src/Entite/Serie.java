package Entite;

import java.util.ArrayList;

public class Serie extends PublicationVideo {

	private ArrayList<Saison> saisons;
	private int nbDeSaisons;
	private int episodeEnCours;

	public Serie() {
		this.saisons = new ArrayList<Saison>();
		this.acteurs = new ArrayList<String>();
		this.genres = new ArrayList<String>();
		this.description = "";
		this.realisateur = "";
		this.titre = "";
		this.episodeEnCours = 0;
		this.nbDeSaisons = 0;
		this.timecode = 0;
		this.duree = 0;
		this.note = 0;
		this.visionne = false;
	}

	public Serie(Serie copie) {
		this.saisons = copie.getSaisons();
		this.acteurs = copie.getActeurs();
		this.genres = copie.getGenres();
		this.description = copie.getDescription();
		this.realisateur = copie.getRealisateur();
		this.titre = copie.getTitre();
		this.episodeEnCours = copie.getEpisodeEnCours();
		this.nbDeSaisons = copie.getNbDeSaisons();
		this.timecode = copie.getTimecode();
		this.duree = copie.getDuree();
		this.note = copie.getNote();
		this.visionne = copie.getVisionne();
	}

	public Serie(int nbDeSaisons, int episodeEnCours, ArrayList<Saison> saisons, ArrayList<String> acteurs,
			ArrayList<String> genres, String realisateur, String titre, String description, double note, int duree,
			int timecode, boolean visionne) {
		this.saisons = saisons;
		this.acteurs = acteurs;
		this.genres = genres;
		this.description = description;
		this.realisateur = realisateur;
		this.titre = titre;
		this.episodeEnCours = episodeEnCours;
		this.nbDeSaisons = nbDeSaisons;
		this.timecode = timecode;
		this.duree = duree;
		this.note = note;
		this.visionne = visionne;
	}

	public boolean getVisionne() {
		return this.visionne;
	}

	public String getRealisateur() {
		return this.realisateur;
	}

	public ArrayList<String> getActeurs() {
		return this.acteurs;
	}

	public ArrayList<String> getGenres() {
		return this.genres;
	}

	public int getDuree() {
		return this.duree;
	}

	public int getTimecode() {
		return this.timecode;
	}

	public double getNote() {
		return this.note;
	}

	public String getTitre() {
		return this.titre;
	}

	public String getDescription() {
		return this.description;
	}

	public int getNbDeSaisons() {
		return this.nbDeSaisons;
	}

	public int getEpisodeEnCours() {
		return this.episodeEnCours;
	}

	public ArrayList<Saison> getSaisons() {
		return this.saisons;
	}

	public void setVisionne(boolean visionne) {
		this.visionne = visionne;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public void setActeurs(ArrayList<String> acteurs) {
		this.acteurs = acteurs;
	}

	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setTimecode(int timecode) {
		this.timecode = timecode;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNbDeSaisons(int nbDeSaisons) {
		this.nbDeSaisons = nbDeSaisons;
	}

	public void setEpisodeEnCours(int episodeEnCours) {
		this.episodeEnCours = episodeEnCours;
	}

	public void setSaisons(ArrayList<Saison> saisons) {
		this.saisons = saisons;
	}

	public String toString() {
		return ("La série nomméz " + this.titre + " dure " + this.duree + " et a été réalisée en majorité par "
				+ this.realisateur + ".\nDescription: " + this.description);
	}

}
