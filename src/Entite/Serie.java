package Entite;

import java.util.ArrayList;
import java.util.Date;

public class Serie extends PublicationVideo {

	private ArrayList<Saison> saisons;
	private int nbDeSaisons;

	public Serie() {
		this.setSaisons(new ArrayList<Saison>());
		this.acteurs = new ArrayList<String>();
		this.genres = new ArrayList<String>();
		this.description = "";
		this.realisateur = "";
		this.titre = "";
		this.setNbDeSaisons(0);
		this.duree = 0;
		this.note = 0;
		this.ID = 0;
		this.video = "";
		this.trailer = "";
		this.parution = new Date();
	}

	public Serie(Serie copie) {
		this.setSaisons(copie.getSaisons());
		this.acteurs = copie.getActeurs();
		this.genres = copie.getGenres();
		this.description = copie.getDescription();
		this.realisateur = copie.getRealisateur();
		this.titre = copie.getTitre();
		this.setNbDeSaisons(copie.getNbDeSaisons());
		this.duree = copie.getDuree();
		this.note = copie.getNote();
		this.ID = copie.getID();
		this.video = copie.getVideo();
		this.trailer = copie.getTrailer();
		this.parution = copie.getparution();
	}

	public Serie(int nbDeSaisons, ArrayList<Saison> saisons, ArrayList<String> acteurs, ArrayList<String> genres,
			String realisateur, String titre, String description, double note, int duree, Integer ID, String video,
			String trailer, Date parution) {
		this.setSaisons(saisons);
		this.acteurs = acteurs;
		this.genres = genres;
		this.description = description;
		this.realisateur = realisateur;
		this.titre = titre;
		this.setNbDeSaisons(nbDeSaisons);
		this.duree = duree;
		this.note = note;
		this.ID = ID;
		this.video = video;
		this.trailer = trailer;
		this.parution = parution;

		if (saisons == null) {
			this.saisons = new ArrayList<Saison>();
		}
	}

	public String toString() {
		return (titre + " " + acteurs.toString() + " " + genres.toString() + " " + realisateur + " " + duree
				+ description + " " + " " + note + " " + ID + " " + video + " " + parution.toString() + " "
				+ saisons.toString() + " " + nbDeSaisons);
	}

	public ArrayList<Saison> getSaisons() {
		return saisons;
	}

	public void setSaisons(ArrayList<Saison> saisons) {
		this.saisons = saisons;
	}

	public int getNbDeSaisons() {
		return nbDeSaisons;
	}

	public void setNbDeSaisons(int nbDeSaisons) {
		this.nbDeSaisons = nbDeSaisons;
	}

	public void ajouter_saison(Saison saison) {
		if (saison != null) {
			this.saisons.add(saison);
		}
	}

}
