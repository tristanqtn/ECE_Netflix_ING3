/**
 * 
 */
package Controleur;

import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import Vue.vue_connexion;

/**
 * @author François BONNET
 * 
 *         Cette classe s'occupe de la vue d'un nouveau compte et de gérer les
 *         actions de l'utilisateur
 *
 */
public class Controleur_Connexion {

	private vue_connexion vue;

	public Controleur_Connexion() {
		vue = new vue_connexion();
	}

	public JButton_arrondi getSoumettre() {
		return vue.getSoumettre();
	}
	public JButton_arrondi getRetour() {
		return vue.get_retour();
	}

	public void start(JFrame frame) {
		vue.initialize(frame);
	}

	public void end(JFrame frame) {
		vue.delete(frame);
	}

	public String get_password() {
		return vue.get_password();
	}

	public String get_mail() {
		return vue.get_mail();
	}

}
