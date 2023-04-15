/**
 * 
 */
package Controleur;

import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import Vue.vue_accueil;

/**
 * @author François BONNET
 * 
 *         Cette classe sert de controlleur pour la page de login de Flouflix.
 *         Elle vérifie les logins, ainsi que permet de changer de page, pour
 *         aller à la vue d'après.
 *
 */
public class Controleur_Login {

	private vue_accueil vue;

	public Controleur_Login() {
		vue = new vue_accueil();
	}

	public JButton_arrondi getLogIn() {
		return vue.getLogIn();
	}

	public JButton_arrondi getNewUser() {
		return vue.getNewUser();
	}

	public void start(JFrame frame) {
		vue.initialize(frame);
	}

	public void end(JFrame frame) {
		vue.delete(frame);
	}

}
