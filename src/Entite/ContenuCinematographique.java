package Entite;

import java.util.ArrayList;

public abstract class ContenuCinematographique {

	// Mettre le mp4
	protected ArrayList<String> acteurs;
	protected ArrayList<String> genres;
	protected String realisateur;
	protected String titre;
	protected String description;
	protected double note;
	protected int duree;
	protected int timecode;
	protected boolean visionne;

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
		return ("Le contenu cinematographique nommé " + this.titre + " dure " + this.duree + " et a été réalisé par "
				+ this.realisateur + ".\nDescription: " + this.description);
	}
}
