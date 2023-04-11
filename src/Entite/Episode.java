package Entite;

import java.util.ArrayList;
import java.util.Date;

public class Episode extends ContenuCinematographique {

	private int numeroDEpisode;
	private int ID_serie;
	private int ID_saison;

	public Episode() {
		this.setNumeroDEpisode(0);
		this.acteurs = new ArrayList<String>();
		this.genres = new ArrayList<String>();
		this.description = "";
		this.realisateur = "";
		this.titre = "";
		this.duree = 0;
		this.note = 0;
		this.ID = 0;
		this.video = "";
		this.parution = new Date();
		this.ID_saison = 0;
		this.ID_serie = 0;
		this.affiche = "";
	}

	public Episode(Episode copie) {
		this.acteurs = copie.getActeurs();
		this.genres = copie.getGenres();
		this.description = copie.getDescription();
		this.realisateur = copie.getRealisateur();
		this.titre = copie.getTitre();
		this.duree = copie.getDuree();
		this.note = copie.getNote();
		this.ID = copie.getID();
		this.video = copie.getVideo();
		this.parution = copie.getparution();
		this.numeroDEpisode = copie.getNumeroDEpisode();
		this.ID_saison = copie.getID_saison();
		this.ID_serie = copie.getID_serie();
		this.affiche = copie.getAffiche();
	}

	public Episode(int numeroDEpisode, ArrayList<String> acteurs, ArrayList<String> genres, String realisateur,
			String titre, String description, double note, int duree, Integer ID, String video, String trailer,
			Date parution, int IDserie, int IDsaison, String affiche) {
		this.acteurs = acteurs;
		this.genres = genres;
		this.description = description;
		this.realisateur = realisateur;
		this.titre = titre;
		this.setNumeroDEpisode(numeroDEpisode);
		this.duree = duree;
		this.note = note;
		this.ID = ID;
		this.video = video;
		this.parution = parution;
		this.ID_saison = IDsaison;
		this.ID_serie = IDserie;
		this.affiche = affiche;
	}

	public int getNumeroDEpisode() {
		return numeroDEpisode;
	}

	public void setNumeroDEpisode(int numeroDEpisode) {
		this.numeroDEpisode = numeroDEpisode;
	}

	public int getID_saison() {
		return ID_saison;
	}

	public void setID_saison(int iD_saison) {
		ID_saison = iD_saison;
	}

	public int getID_serie() {
		return ID_serie;
	}

	public void setID_serie(int iD_serie) {
		ID_serie = iD_serie;
	}

	public String toString() {
		return (titre + " " + acteurs.toString() + " " + genres.toString() + " " + realisateur + " " + duree + " "
				+ description + " " + note + " " + ID + " " + video + " " + parution.toString() + " " + ID_saison + " "
				+ ID_serie + " " + numeroDEpisode + " " + affiche);
	}

	public String who_am_i() {
		return "episode";
	}

}
