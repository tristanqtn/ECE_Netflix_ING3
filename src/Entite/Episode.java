package Entite;

import java.util.ArrayList;

public class Episode extends ContenuCinematographique {

	private ArrayList<String> apparitionsDePersonnage;
	private int numeroDEpisode;

	public Episode() {
		this.apparitionsDePersonnage = new ArrayList<String>();
		this.acteurs = new ArrayList<String>();
		this.genres = new ArrayList<String>();
		this.description = "";
		this.realisateur = "";
		this.titre = "";
		this.numeroDEpisode = 0;
		this.timecode = 0;
		this.duree = 0;
		this.note = 0;
		this.visionne = false;
	}

	public Episode(Episode copie) {
		this.apparitionsDePersonnage = copie.getApparitionsDePersonnage();
		this.acteurs = copie.getActeurs();
		this.genres = copie.getGenres();
		this.description = copie.getDescription();
		this.realisateur = copie.getRealisateur();
		this.titre = copie.getTitre();
		this.numeroDEpisode = copie.getNumeroDEpisode();
		this.timecode = copie.getTimecode();
		this.duree = copie.getDuree();
		this.note = copie.getNote();
		this.visionne = copie.getVisionne();
	}

	public Episode(ArrayList<String> apparitionsDePersonnage, int numeroDEpisode, ArrayList<String> acteurs,
			ArrayList<String> genres, String realisateur, String titre, String description, double note, int duree,
			int timecode, boolean visionne) {
		this.apparitionsDePersonnage = apparitionsDePersonnage;
		this.acteurs = acteurs;
		this.genres = genres;
		this.description = description;
		this.realisateur = realisateur;
		this.titre = titre;
		this.numeroDEpisode = numeroDEpisode;
		this.timecode = timecode;
		this.duree = duree;
		this.note = note;
		this.visionne = visionne;
	}

	public ArrayList<String> getApparitionsDePersonnage() {
		return this.apparitionsDePersonnage;
	}

	public int getNumeroDEpisode() {
		return this.numeroDEpisode;
	}

	public void setApparitionsDePersonnage(ArrayList<String> apparitionsDePersonnage) {
		this.apparitionsDePersonnage = apparitionsDePersonnage;
	}

	public void setNumeroDEpisode(int numeroDEpisode) {
		this.numeroDEpisode = numeroDEpisode;
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

	public String toString() {
		return ("L'épisode nommé " + this.titre + " dure " + this.duree + " et a été réalisé par " + this.realisateur
				+ ".\nDescription: " + this.description);
	}

}
