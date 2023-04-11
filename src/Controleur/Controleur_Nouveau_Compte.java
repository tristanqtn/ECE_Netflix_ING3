/**
 * 
 */
package Controleur;

import javax.swing.JButton;
import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import Vue.vue_nouveau_compte;

/**
 * @author François BONNET
 * 
 * cette classe s'occupe de l'affichage et le désaffichage de la vue de la création d'un nouveau compte.
 *
 */
public class Controleur_Nouveau_Compte {
	
	private vue_nouveau_compte vue;

	public Controleur_Nouveau_Compte() {
		vue = new vue_nouveau_compte();
	}
	
	public void start(JFrame frame) {
		vue.initialize(frame);
	}
	
	public void end(JFrame frame) {
		vue.delete(frame);
	}
	
	public JButton_arrondi getPayement() {
		return vue.getPayement();
	}
	
	public JButton getRetour() {
		return vue.getRetour();
	}
	
}
