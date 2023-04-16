/**
 * 
 */
package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import ElementsVisuels.JButton_arrondi;
import Entite.Membre;
import Vue.vue_nouveau_compte;
import Vue.vue_payement;

/**
 * @author François BONNET
 *
 */
public class ControleurNouvelUtilisateurCreation {

	private vue_payement payement;
	private vue_nouveau_compte nouveauCompte;
	private Membre nvl_utilisateur;

	public ControleurNouvelUtilisateurCreation(JFrame frame) {
		nouveauCompte = new vue_nouveau_compte();
		setNouveauCompteListeners(frame);
		payement = new vue_payement();
		setPayementListeners(frame);
	}
	
	public void resetInformations() {
		nouveauCompte.resetInformations();
		payement.resetInformations();
	}

	public void start(JFrame frame) {//On affiche la vue d'informations
		nouveauCompte.initialize(frame);
	}

	public JButton getRetour() {//On retourne le bouton retour
		return nouveauCompte.getRetour();
	}

	public JButton_arrondi getPayement() {//On retourne le pouton payement
		return payement.get_valider();
	}

	public Membre getNewUser() {//On retourne le nouvel utilisateur créé

		ArrayList<String> preferences = new ArrayList<String>();
		if (nouveauCompte.getAction()) {//On ajoute les préférences selectionnées
			preferences.add("Action");
		}
		if (nouveauCompte.getRomantique()) {
			preferences.add("Romantique");
		}
		if (nouveauCompte.getDocumentaire()) {
			preferences.add("Documentaire");
		}
		if (nouveauCompte.getComedie()) {
			preferences.add("Comedie");
		}

		nvl_utilisateur = new Membre(0, nouveauCompte.getNom(), nouveauCompte.getPrenom(), nouveauCompte.getMail(),
				Long.valueOf(nouveauCompte.getTelephone()).longValue(), payement.getNumCB(), preferences,
				nouveauCompte.getMDP(), false, 0, 0, false, false, "HD"); // on crée un nouvel utilisateur

		return nvl_utilisateur;
	}

	public void setNouveauCompteListeners(final JFrame frame) {//On met les listeners sur la vue d'informations

		nouveauCompte.getPayement().addActionListener(new ActionListener() {//On listen pour le bouton de soumission de la vue d'informations

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isInformationValid()) {//Si suffisemment d'informations ont été rentrées
					nouveauCompte.delete(frame);
					payement.initialize(frame);
				} else {
					System.out.println("Des informations sont manquantes");
				}
			}

		});
	}

	public void setPayementListeners(final JFrame frame) {//on met les listeners sur la vue de payement
		payement.getRetour().addActionListener(new ActionListener() {//Si l'utilisateur clique sur le bouton retour

			@Override
			public void actionPerformed(ActionEvent e) {
				payement.delete(frame);
				nouveauCompte.initialize(frame);
			}

		});

	}

	public void end(JFrame frame) {
		payement.delete(frame);
	}

	public void end_user_info(JFrame frame) {
		nouveauCompte.delete(frame);
	}

	public boolean IsCbValid() {//On retourn vrai si les informations bancaires sont valides
		if (payement.isCryptogramValid() && payement.isExpirationDateValid()
				&& payement.isCbNumValid()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isInformationValid() {//On retourne vrai si les informations utilisateur sont valides
		if (nouveauCompte.isEmailValid() && nouveauCompte.isMDPValid()
				&& nouveauCompte.isNomValid() && nouveauCompte.isPrenomValid()
				&& nouveauCompte.isTelephoneValid()
				&& (nouveauCompte.getAction() || nouveauCompte.getComedie() || nouveauCompte.getDocumentaire()
						|| nouveauCompte.getRomantique())) {
			return true;
		}
		return false;
	}

}
