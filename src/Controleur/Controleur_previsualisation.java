package Controleur;

import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import Entite.ContenuCinematographique;
import Vue.vue_previsualisation;

public class Controleur_previsualisation {
	private vue_previsualisation vue;
	private ContenuCinematographique contenu;

	public Controleur_previsualisation(JFrame frame, ContenuCinematographique contenu) {
		vue = new vue_previsualisation(contenu);
		this.contenu = contenu;
		vue.initialize(frame);
	}

	public JButton_arrondi get_trailer() {
		return this.vue.getTrailer();
	}

	public JButton_arrondi get_retour() {
		return this.vue.get_retour();
	}

	public JButton_arrondi get_video() {
		return this.vue.getVisionner();
	}

	public ContenuCinematographique getContenu() {
		return contenu;
	}

}
