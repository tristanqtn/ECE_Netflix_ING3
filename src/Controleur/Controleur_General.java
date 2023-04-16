/**
 * 
 */
package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Entite.Membre;
import Vue.vue_accueil;
import Vue.vue_connexion;

/**
 * @author François BONNET
 * 
 *         Cette classe est le controleur général et organise tout les
 *         controleurs pour relier les vues, les modes et les actions de
 *         l'utilisateur
 *
 */
public class Controleur_General {

	private vue_accueil login;
	private vue_connexion connexion;
	private Controleur_Modele modele;
	private Controleur_Admin admin;
	private ControleurGeneralIntraApplication general2;
	private ControleurNouvelUtilisateurCreation creation;

	public Controleur_General(JFrame frame, boolean reset_bdd) {
		modele = new Controleur_Modele("root", "root", reset_bdd);
		login = new vue_accueil();
		setLogInListeners(frame);
		creation = new ControleurNouvelUtilisateurCreation(frame);
		setCreationListeners(frame);
		connexion = new vue_connexion();
		setConnexionListeners(frame);
		admin = new Controleur_Admin();
		setAdminListeners(frame);
		frame.setVisible(true);
		login.initialize(frame);

	}

	public void setLogInListeners(final JFrame frame) {//On ajouter les listeners aux éléments de la vue LogIn
		login.getLogIn().addActionListener(new ActionListener() {//L'utilisateur veut se connecter

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("log in");
				login.delete(frame);
				connexion.initialize(frame);
				modele = new Controleur_Modele("root", "root", false);
			}

		});

		login.getNewUser().addActionListener(new ActionListener() {//L'utilisateur veut créer un nouvel utilisateur

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("new user");
				login.delete(frame);
				creation.start(frame);
			}

		});

	}

	public void setConnexionListeners(final JFrame frame) {//On ajouter les listeners aux éléments de la vue de connection
		connexion.getSoumettre().addActionListener(new ActionListener() {//L'utilisateur a cliqué sur le bouton pour se connecter
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("soumettre");
				String mail = connexion.get_mail(), mdp = connexion.get_password();
				System.out.println(modele.getMembres().size());

				for (int i = 0; i < modele.getMembres().size(); i++) {//On parcourt les utilisateurs dans la base de données
					if (modele.getMembres().get(i).getAdresse_mail().equals(mail)
							&& modele.getMembres().get(i).getPassword().equals(mdp)) {////Si le mail et le mot de passe correspondent à l'utilisateur dans la base de données

						if (modele.getMembres().get(i).getAdmin()) {//On regarde si l'utilisateur est un administrateur et on dirige vers la page administrateur
							connexion.delete(frame);
							connexion.resetInformations();
							admin.start(frame);
							setAdminListeners(frame);
						} else {//On redirige vers la page de recommandations
							System.out.println("Logged as " + modele.getMembres().get(i).getPrenom());
							connexion.delete(frame);
							connexion.resetInformations();
							setGeneral2(new ControleurGeneralIntraApplication(frame, modele.getMembres().get(i)));
							getGeneral2().getDeconnexion().addChangeListener(new ChangeListener() {

								@Override
								public void stateChanged(ChangeEvent e) {//On met un listener sur un JRadioButton abstrait pout détecter la déconnexion
									System.out.println("Deconnexion");
									login.initialize(frame);
								}

							});
						}

					}

				}
			}

		});

		connexion.get_retour().addActionListener(new ActionListener() {//Fleche retour

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				connexion.delete(frame);
				connexion.resetInformations();
				login.initialize(frame);
			}

		});
	}

	public void setAdminListeners(final JFrame frame) {//On ajouter les listeners aux éléments de la vue administrateur
		admin.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				admin.end(frame);
				login.initialize(frame);
			}

		});
	}

	public ControleurGeneralIntraApplication getGeneral2() {//retourne l'objet de controleur général intra application
		return general2;
	}

	public void setGeneral2(ControleurGeneralIntraApplication general2) {//set l'objet de controleur général intra application
		this.general2 = general2;
	}

	public void setCreationListeners(final JFrame frame) {//On ajouter les listeners aux éléments de la vue de création de compte
		creation.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				creation.end_user_info(frame);
				creation.resetInformations();
				login.initialize(frame);
			}

		});

		creation.getPayement().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {// Ici le compte a été créé
				if (creation.IsCbValid()) {
					System.out.println("in creation");
					creation.end(frame);
					login.initialize(frame);
					Membre nouvelUtilisateur = creation.getNewUser();
					System.out.println(nouvelUtilisateur.toString());
					modele.sauver_nv_membre_BDD(nouvelUtilisateur);
					modele.recharger_membres();
					modele.afficher_membres();
					creation.resetInformations();
				} else {
					System.out.println("Il manque des informations");
				}

			}

		});

	}

}
