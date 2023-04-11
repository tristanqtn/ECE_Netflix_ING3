package Entite;

import java.util.ArrayList;
import java.util.Date;

public abstract class ContenuCinematographique {

	protected Integer ID;
	protected ArrayList<String> acteurs;
	protected ArrayList<String> genres;
	protected String realisateur;
	protected String titre;
	protected String description;
	protected double note;
	protected Date parution;
	protected int duree;
	protected String video;
	protected String affiche;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Date getparution() {
		return parution;
	}

	public void setparution(Date parution) {
		this.parution = parution;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getAffiche() {
		return this.affiche;
	}

	public void setAffiche(String affiche) {
		this.affiche = affiche;
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

	public double getNote() {
		return this.note;
	}

	public String getTitre() {
		return this.titre;
	}

	public String getDescription() {
		return this.description;
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

	public abstract String who_am_i();
}
