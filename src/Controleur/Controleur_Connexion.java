/**
 * 
 */
package Controleur;

import javax.swing.JButton;
import javax.swing.JFrame;

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

	public JButton getSoumettre() {
		return vue.getSoumettre();
	}

	public void start(JFrame frame) {
		vue.initialize(frame);
		frame.setVisible(true);
	}

	public void end(JFrame frame) {
		frame.setVisible(false);
		vue.delete(frame);
	}

}
