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

/**
 * @author François BONNET
 *
 */
public class ControleurNouvelUtilisateurCreation {

	private Controleur_Payement payement;
	private Controleur_Nouveau_Compte nouveauCompte;
	private Membre nvl_utilisateur;

	public ControleurNouvelUtilisateurCreation() {
		nouveauCompte = new Controleur_Nouveau_Compte();
		payement = new Controleur_Payement();
	}

	public void start(JFrame frame) {
		nouveauCompte.start(frame);
		setNouveauCompteListeners(frame);
	}

	public JButton getRetour() {
		return nouveauCompte.getRetour();
	}

	public JButton_arrondi getPayement() {
		return payement.get_valider();
	}

	public Membre getNewUser() {

		ArrayList<String> preferences = new ArrayList<String>();
		if (nouveauCompte.getAction()) {
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
				Long.valueOf(nouveauCompte.getTelephone()).longValue(), "1234567891234567", preferences,
				nouveauCompte.getMDP(), false, 0, 0, false, false, "HD"); // remplacer par num de
		// carte
		nvl_utilisateur.setNum_cb(payement.getNumCB()); // valeur de CB à recuperer depuis le payement

		return nvl_utilisateur;
	}

	public void setNouveauCompteListeners(final JFrame frame) {

		nouveauCompte.getPayement().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!nouveauCompte.getMail().isBlank() && !nouveauCompte.getMDP().isBlank()
						&& !nouveauCompte.getNom().isBlank() && !nouveauCompte.getPrenom().isBlank()
						&& !nouveauCompte.getTelephone().isBlank()
						&& (nouveauCompte.getAction() || nouveauCompte.getComedie() || nouveauCompte.getDocumentaire()
								|| nouveauCompte.getRomantique())) {
					nouveauCompte.end(frame);
					payement.start(frame);
					setPayementListeners(frame);
				} else {
					System.out.println("Des informations sont manquantes");
				}
			}

		});

		/*
		 * ArrayList<Component> list =nouveauCompte.getEnterToListen(); for(int
		 * i=0;i<list.size();i++) { final int rank=i; list.get(i).addKeyListener(new
		 * KeyListener() {
		 * 
		 * @Override public void keyTyped(KeyEvent e) {
		 * 
		 * }
		 * 
		 * @Override public void keyPressed(KeyEvent e) { if(e.getKeyCode()==10)
		 * {///Entrée if (!nouveauCompte.getMail().isBlank() &&
		 * !nouveauCompte.getMDP().isBlank() && !nouveauCompte.getNom().isBlank() &&
		 * !nouveauCompte.getPrenom().isBlank() &&
		 * !nouveauCompte.getTelephone().isBlank() && (nouveauCompte.getAction() ||
		 * nouveauCompte.getComedie() || nouveauCompte.getDocumentaire() ||
		 * nouveauCompte.getRomantique())) { nouveauCompte.end(frame);
		 * payement.start(frame); setPayementListeners(frame); } else {
		 * System.out.println("Des informations sont manquantes"); } } }
		 * 
		 * @Override public void keyReleased(KeyEvent e) {
		 * 
		 * }
		 * 
		 * }); }
		 */
	}

	public void setPayementListeners(final JFrame frame) {
		payement.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				payement.end(frame);
				nouveauCompte.start(frame);
				setNouveauCompteListeners(frame);
			}

		});

	}

	public void end(JFrame frame) {
		payement.end(frame);
	}

	public void end_user_info(JFrame frame) {
		nouveauCompte.end(frame);
	}

	public boolean IsCbValid() {
		if (!payement.getCryptogramme().isBlank() && !payement.getExpiration().isBlank()
				&& !payement.getNumCB().isBlank()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public ArrayList<Component> getEnterToListen(){ return
	 * payement.getEnterToListen(); }
	 */

}
