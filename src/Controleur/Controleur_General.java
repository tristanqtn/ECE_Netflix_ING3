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

/**
 * @author François BONNET
 * 
 *         Cette classe est le controleur général et organise tout les
 *         controleurs pour relier les vues, les modes et les actions de
 *         l'utilisateur
 *
 */
public class Controleur_General {

	private Controleur_Login login;
	private Controleur_Connexion connexion;
	// private Controleur_Nouveau_Compte nouveauCompte;
	private Controleur_Modele modele;
	private Controleur_Admin admin;
	private ControleurGeneralIntraApplication general2;
	// private Controleur_Payement payement;
	private ControleurNouvelUtilisateurCreation creation;

	public Controleur_General(JFrame frame, boolean reset_bdd) {
		modele = new Controleur_Modele("root", "root", reset_bdd);
		login = new Controleur_Login();
		frame.setVisible(true);
		login.start(frame);
		this.setLogInListeners(frame);

	}

	public void setLogInListeners(final JFrame frame) {
		login.getLogIn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("log in");
				login.end(frame);
				connexion = new Controleur_Connexion();
				connexion.start(frame);
				setConnexionListeners(frame);

			}

		});

		login.getNewUser().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("new user");
				login.end(frame);
				creation = new ControleurNouvelUtilisateurCreation();
				creation.start(frame);
				setCreationListeners(frame);
			}

		});

	}

	public void setConnexionListeners(final JFrame frame) {
		modele = new Controleur_Modele("root", "root", false);
		connexion.getSoumettre().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("soumettre");
				String mail = connexion.get_mail(), mdp = connexion.get_password();
				System.out.println(modele.getMembres().size());

				for (int i = 0; i < modele.getMembres().size(); i++) {
					if (modele.getMembres().get(i).getAdresse_mail().equals(mail)
							&& modele.getMembres().get(i).getPassword().equals(mdp)) {

						if (modele.getMembres().get(i).getAdmin()) {
							connexion.end(frame);
							admin = new Controleur_Admin();
							admin.start(frame);
							setAdminListeners(frame);
						} else {
							System.out.println("Logged as " + modele.getMembres().get(i).getPrenom());
							connexion.end(frame);
							setGeneral2(new ControleurGeneralIntraApplication(frame, modele.getMembres().get(i)));
							/*
							 * getGeneral2().getDeconnexion().addActionListener(new ActionListener() {
							 * 
							 * @Override public void actionPerformed(ActionEvent e) {
							 * System.out.println("Deconnexion"); login = new Controleur_Login();
							 * login.start(frame); setLogInListeners(frame); }
							 * 
							 * });
							 */
							getGeneral2().getDeconnexion().addChangeListener(new ChangeListener() {

								@Override
								public void stateChanged(ChangeEvent e) {
									System.out.println("Deconnexion");
									login = new Controleur_Login();
									login.start(frame);
									setLogInListeners(frame);
								}

							});
						}

					}

				}
			}

		});

		connexion.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				connexion.end(frame);
				login = new Controleur_Login();
				login.start(frame);
				setLogInListeners(frame);
			}

		});
	}

	public void setAdminListeners(final JFrame frame) {
		admin.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				login = new Controleur_Login();
				admin.end(frame);
				login.start(frame);
				setLogInListeners(frame);
			}

		});
	}

	public ControleurGeneralIntraApplication getGeneral2() {
		return general2;
	}

	public void setGeneral2(ControleurGeneralIntraApplication general2) {
		this.general2 = general2;
	}

	public void setCreationListeners(final JFrame frame) {
		creation.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				creation.end_user_info(frame);
				login = new Controleur_Login();
				login.start(frame);
				setLogInListeners(frame);
			}

		});

		creation.getPayement().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {// Ici le compte a été créé
				if (creation.IsCbValid()) {
					System.out.println("in creation");
					creation.end(frame);
					login = new Controleur_Login();
					login.start(frame);
					setLogInListeners(frame);
					Membre nouvelUtilisateur = creation.getNewUser();
					System.out.println(nouvelUtilisateur.toString());
					modele.sauver_nv_membre_BDD(nouvelUtilisateur);
					modele.recharger_membres();
					modele.afficher_membres();
				} else {
					System.out.println("Il manque des informations");
				}

			}

		});

		/*
		 * ArrayList<Component> list =creation.getEnterToListen(); for(int
		 * i=0;i<list.size();i++) { list.get(i).addKeyListener(new KeyListener() {
		 * 
		 * @Override public void keyTyped(KeyEvent e) {
		 * 
		 * }
		 * 
		 * @Override public void keyPressed(KeyEvent e) { if(e.getKeyCode()==10)
		 * {///Entrée if (creation.IsCbValid()) { System.out.println("in creation");
		 * creation.end(frame); login = new Controleur_Login(); login.start(frame);
		 * setLogInListeners(frame); Membre nouvelUtilisateur = creation.getNewUser();
		 * System.out.println(nouvelUtilisateur.toString());
		 * modele.sauver_nv_membre_BDD(nouvelUtilisateur); modele.recharger_membres();
		 * modele.afficher_membres(); } else {
		 * System.out.println("Il manque des informations"); } } }
		 * 
		 * @Override public void keyReleased(KeyEvent e) {
		 * 
		 * }
		 * 
		 * }); }
		 */

	}

}
