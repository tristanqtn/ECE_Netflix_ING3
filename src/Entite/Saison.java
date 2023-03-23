package Entite;

import java.util.ArrayList;

public class Saison {

	private ArrayList<Episode> episodes;
	private int nbDEpisode;

	public Saison() {
		this.episodes = new ArrayList<Episode>();
		this.nbDEpisode = 0;
	}

	public Saison(Saison copie) {
		this.episodes = copie.getEpisodes();
		this.nbDEpisode = copie.getNbDEpisode();
	}

	public Saison(ArrayList<Episode> episodes, int nbDEpisode) {
		this.episodes = episodes;
		this.nbDEpisode = nbDEpisode;
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

}
