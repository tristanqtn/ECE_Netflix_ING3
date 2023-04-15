/**
 * 
 */
package Controleur;

import javax.swing.JButton;
import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import Vue.vue_payement;

/**
 * @author François BONNET
 *
 */
public class Controleur_Payement {

	private vue_payement payement;

	public Controleur_Payement() {
		payement = new vue_payement();
	}

	public String getNumCB() {
		return payement.getNumCB();
	}

	public String getExpiration() {
		return payement.getExpiration();
	}

	public String getCryptogramme() {
		return payement.getCryptogramme();
	}

	public JButton_arrondi get_valider() {
		return payement.get_valider();
	}

	public JButton getRetour() {
		return payement.getRetour();
	}

	public void start(JFrame frame) {
		payement.initialize(frame);

	}

	public void end(JFrame frame) {
		payement.delete(frame);
	}

	/*
	 * public ArrayList<Component> getEnterToListen(){ return
	 * payement.getEnterToListen(); }
	 */

}
