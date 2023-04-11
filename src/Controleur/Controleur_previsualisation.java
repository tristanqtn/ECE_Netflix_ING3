package Controleur;

import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import Entite.ContenuCinematographique;
import Vue.vue_previsualisation;

public class Controleur_previsualisation {
	private vue_previsualisation vue;

	public Controleur_previsualisation(JFrame frame, ContenuCinematographique contenu) {
		vue = new vue_previsualisation();
		vue.initialize();
	}

	public JButton_arrondi get_trailer() {
		return this.vue.get_trailer();
	}

	public JButton_arrondi get_retour() {
		return this.vue.get_retour();
	}

	public JButton_arrondi get_video() {
		return this.vue.get_video();
	}

}
