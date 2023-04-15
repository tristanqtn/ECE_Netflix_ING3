package Entite;

import java.util.ArrayList;
import java.util.Date;

public class Film extends PublicationVideo {

	public Film() {
		this.acteurs = new ArrayList<String>();
		this.genres = new ArrayList<String>();
		this.description = "";
		this.realisateur = "";
		this.titre = "";
		this.duree = 0;
		this.note = 0;
		this.ID = 0;
		this.video = "";
		this.trailer = "";
		this.parution = new Date();
		this.affiche = "";
		this.nb_note = 0;
	}

	public Film(Serie copie) {
		this.acteurs = copie.getActeurs();
		this.genres = copie.getGenres();
		this.description = copie.getDescription();
		this.realisateur = copie.getRealisateur();
		this.titre = copie.getTitre();
		this.duree = copie.getDuree();
		this.note = copie.getNote();
		this.ID = copie.getID();
		this.video = copie.getVideo();
		this.trailer = copie.getTrailer();
		this.parution = copie.getparution();
		this.affiche = copie.getAffiche();
		this.nb_note = copie.getnb_note();
	}

	public Film(ArrayList<String> acteurs, ArrayList<String> genres, String realisateur, String titre,
			String description, double note, int duree, Integer ID, String video, String trailer, Date parution,
			String affiche, int nb_note) {
		this.acteurs = acteurs;
		this.genres = genres;
		this.description = description;
		this.realisateur = realisateur;
		this.titre = titre;
		this.duree = duree;
		this.note = note;
		this.ID = ID;
		this.video = video;
		this.trailer = trailer;
		this.parution = parution;
		this.affiche = affiche;
		this.nb_note = nb_note;
	}

	public String toString() {
		return (titre + " " + acteurs.toString() + " " + genres.toString() + " " + realisateur + " " + duree
				+ description + " " + " " + note + " " + ID + " " + video + " " + trailer + " " + parution.toString()
				+ " " + affiche + " " + nb_note);
	}

	public String who_am_i() {
		return "film";
	}

}
