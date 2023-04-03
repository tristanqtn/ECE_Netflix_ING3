/**
 * 
 */
package Controleur;

import javax.swing.JButton;
import javax.swing.JFrame;

import Vue.vue_accueil;

/**
 * @author François BONNET
 * 
 * Cette classe sert de controlleur pour la page de login de Flouflix. Elle vérifie les logins, 
 * ainsi que permet de changer de page, pour aller à la vue d'après.
 *
 */
public class Controleur_Login {
	
	private vue_accueil vue;
	
	public Controleur_Login() {
		vue=new vue_accueil();
	}
	
	public JButton getLogIn() {
		return vue.getLogIn();
	}
	
	public JButton getNewUser() {
		return vue.getNewUser();
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
