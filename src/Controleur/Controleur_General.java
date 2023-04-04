/**
 * 
 */
package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

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
	private Controleur_Nouveau_Compte nouveauCompte;
	private Controleur_Modele modele;
	private Controleur_Admin admin;

	public Controleur_General(JFrame frame, boolean reset_bdd) {
		modele = new Controleur_Modele("root", "root", reset_bdd);
		login = new Controleur_Login();
		connexion = new Controleur_Connexion();
		nouveauCompte = new Controleur_Nouveau_Compte();
		admin = new Controleur_Admin();

		login.start(frame);
		this.setLogInListeners(frame);

	}

	public void setLogInListeners(JFrame frame) {
		login.getLogIn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("log in");
				login.end(frame);
				connexion.start(frame);
				setConnexionListeners(frame);

			}

		});

		login.getNewUser().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("new user");
				login.end(frame);
				nouveauCompte.start(frame);
				setNouveauCompteListeners(frame);
			}

		});
	}

	public void setConnexionListeners(JFrame frame) {

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
							admin.start(frame);
						} else {
							System.out.println("Logged as " + modele.getMembres().get(i).getPrenom());
						}

					}

				}
			}

		});
	}

	public void setNouveauCompteListeners(JFrame frame) {

		nouveauCompte.getPayement().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("payement");

			}

		});
	}

}
