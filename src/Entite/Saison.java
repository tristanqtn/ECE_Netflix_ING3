package Entite;

import java.util.ArrayList;

public class Saison {

	private int ID;
	private ArrayList<Episode> episodes;
	private int num_saison;
	private int nbDEpisode;
	private int IDserie;

	public Saison() {
		this.episodes = new ArrayList<Episode>();
		this.nbDEpisode = 0;
		this.IDserie = 0;
		this.num_saison = 0;
	}

	public Saison(Saison copie) {
		this.episodes = copie.getEpisodes();
		this.nbDEpisode = copie.getNbDEpisode();
		this.IDserie = copie.getIDserie();
		this.num_saison = copie.getNum_saison();
	}

	public Saison(ArrayList<Episode> episodes, int nbDEpisode, int ID, int IDserie, int num_saison) {
		this.episodes = episodes;
		this.nbDEpisode = nbDEpisode;
		this.ID = ID;
		this.IDserie = IDserie;
		this.num_saison = num_saison;

		if (episodes == null) {
			this.episodes = new ArrayList<Episode>();
		}

	}

	public ArrayList<Episode> getEpisodes() {
		return this.episodes;
	}

	public int getNbDEpisode() {
		return this.nbDEpisode;
	}

	public void setEpisodes(ArrayList<Episode> episodes) {
		this.episodes = episodes;
	}

	public void setNbDEpisode(int nbDEpisode) {
		this.nbDEpisode = nbDEpisode;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public int getIDserie() {
		return IDserie;
	}

	public void setIDserie(int iDserie) {
		IDserie = iDserie;
	}

	public int getNum_saison() {
		return num_saison;
	}

	public void setNum_saison(int num_saison) {
		this.num_saison = num_saison;
	}

	public String toString() {
		return (episodes.toString() + " " + num_saison + " " + nbDEpisode + " " + IDserie + " " + ID);
	}

	public void ajouter_episode(Episode episode) {
		if (episode != null) {
			this.episodes.add(episode);
		}
	}
}
