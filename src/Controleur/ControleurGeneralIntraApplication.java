/**
 * 
 */
package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import ElementsVisuels.JButton_arrondi;
import Entite.ContenuCinematographique;
import Entite.Episode;
import Entite.Membre;
import Entite.Visionnage;
import Vue.vue_catalogue;
import Vue.vue_home_page;
import Vue.vue_page_compte;
import Vue.vue_previsualisation;
import Vue.vue_recherche;
import Vue.vue_timecode;
import Vue.web_video_player;

/**
 * @author Francois BONNET
 * 
 */
public class ControleurGeneralIntraApplication {

	private vue_previsualisation informations;
	private vue_home_page pageDAcceuil;
	private JFrame frame;
	private vue_page_compte parametre;
	private vue_recherche recherche;
	private vue_catalogue catalogue;
	private Membre user;
	private JRadioButton deconnexion;
	private vue_timecode timecode;
	private Controleur_Modele modele;

	public ControleurGeneralIntraApplication(JFrame frame, Membre user) {
		this.user = user;
		this.setFrame(frame);
		deconnexion = new JRadioButton();
		deconnexion.setSelected(false);
		pageDAcceuil = new vue_home_page(this.user);
		pageDAcceuil.initialize(frame);
		setPageDAcceuilListeners(frame);
	}

	public JRadioButton getDeconnexion() {
		return deconnexion;
	}

	private void setPageDAcceuilListeners(JFrame frame) {
		modele = new Controleur_Modele("root", "root", false);
		pageDAcceuil.getCompte().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Compte");
				parametre = new vue_page_compte(user);
				pageDAcceuil.delete(frame);
				parametre.initialize(frame);
				setParametreListeners(frame);
			}

		});

		ArrayList<ArrayList<JButton_arrondi>> liste = pageDAcceuil.getFilms();
		for (int j = 0; j < liste.size(); j++) {
			for (int i = 0; i < liste.get(j).size(); i++) {
				final ContenuCinematographique contenu = pageDAcceuil.getRecomandation(j, i);// On récupère le film
				liste.get(j).get(i).addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Film");
						informations = new vue_previsualisation(contenu);
						pageDAcceuil.delete(frame);
						informations.initialize(frame);
						setPrevisualisationListeners(frame);
					}

				});
			}
		}

		pageDAcceuil.getRecherche().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Rechercher");
				recherche = new vue_recherche();
				pageDAcceuil.delete(frame);
				recherche.initialize(frame);
				setRechercheListeners(frame);
			}
		});

		pageDAcceuil.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Deco");
				pageDAcceuil.delete(frame);
				deconnexion.setSelected(true);
			}

		});
	}

	private void setPrevisualisationListeners(JFrame frame) {
		informations.getVisionner().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Visionner");
				web_video_player player = new web_video_player(informations.get_contenu().getVideo());
				player.play();
				timecode = new vue_timecode(informations.get_contenu());
				informations.delete(frame);
				timecode.initialize(frame);
				setTimecodeListeners(frame);
			}

		});

		informations.getTrailer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Trailer");
				web_video_player player = new web_video_player(informations.get_contenu().getTrailer());
				player.play();
			}

		});
		informations.get_retour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				informations.delete(frame);
				pageDAcceuil = new vue_home_page(user);
				pageDAcceuil.initialize(frame);
				setPageDAcceuilListeners(frame);

			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setParametreListeners(JFrame frame) {
		parametre.getEffacer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Effacer");
				pageDAcceuil = new vue_home_page(user);
				parametre.delete(frame);
				pageDAcceuil.initialize(frame);
				setPageDAcceuilListeners(frame);
			}

		});

		parametre.getSauvegarder().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sauvegarder");
				System.out.print("Qualite: ");
				System.out.println(parametre.getQuality());
				System.out.print("Reprise: ");
				System.out.println(parametre.getReprise());
				System.out.print("Sous-titres: ");
				System.out.println(parametre.getSousTitres());
				System.out.println("HomePage");
				pageDAcceuil = new vue_home_page(user);
				parametre.delete(frame);
				pageDAcceuil.initialize(frame);
				setPageDAcceuilListeners(frame);

			}

		});

		parametre.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pageDAcceuil = new vue_home_page(user);
				parametre.delete(frame);
				pageDAcceuil.initialize(frame);
				setPageDAcceuilListeners(frame);
			}

		});
	}

	private void setRechercheListeners(JFrame frame) {

		recherche.getAction().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");
			}

		});

		recherche.getAmour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Amour");
			}

		});

		recherche.getComedie().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("comedie");
			}

		});

		recherche.getDocumentaire().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Documentaire");
			}

		});

		recherche.getButtonRecherche().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bouton Recherche");
				catalogue = new vue_catalogue(modele, user, recherche.getRecherche());
				recherche.delete(frame);
				catalogue.initialize(frame);
				setCatalogueListeners(frame);
			}

		});

		recherche.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				pageDAcceuil = new vue_home_page(user);
				recherche.delete(frame);
				pageDAcceuil.initialize(frame);
				setPageDAcceuilListeners(frame);
			}

		});

	}

	public void setCatalogueListeners(JFrame frame) {
		catalogue.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("retour");
				recherche = new vue_recherche();
				catalogue.delete(frame);
				recherche.initialize(frame);
				setRechercheListeners(frame);
			}

		});
	}

	public void setTimecodeListeners(JFrame frame) {
		timecode.getRetour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				informations = new vue_previsualisation(timecode.getContenu());
				timecode.delete(frame);
				informations.initialize(frame);
				setPrevisualisationListeners(frame);
			}

		});

		timecode.get_retour_catalogue().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Vector<Visionnage> visio = modele.getVisionnages();
				Visionnage nouveau = null;
				if (timecode.getContenu().who_am_i() == "documentaire"
						&& timecode.get_film_fini().isSelected() == false) {
					String split[] = timecode.get_time_code().getText().split(":");
					int TIME_code = Integer.parseInt(split[0]);

					nouveau = new Visionnage(0, user.getID(), 0, timecode.getContenu().getID(), 0, 0, 0, TIME_code);

				}

				if (timecode.getContenu().who_am_i() == "documentaire"
						&& timecode.get_film_fini().isSelected() == true) {

					nouveau = new Visionnage(0, user.getID(), 0, timecode.getContenu().getID(), 0, 0, 0, -1);

				}

				if (timecode.getContenu().who_am_i() == "film" && timecode.get_film_fini().isSelected() == false) {
					String split[] = timecode.get_time_code().getText().split(":");
					int TIME_code = Integer.parseInt(split[0]);
					nouveau = new Visionnage(0, user.getID(), timecode.getContenu().getID(), 0, 0, 0, 0, TIME_code);

				}

				if (timecode.getContenu().who_am_i() == "film" && timecode.get_film_fini().isSelected() == true) {
					nouveau = new Visionnage(0, user.getID(), timecode.getContenu().getID(), 0, 0, 0, 0, -1);

				}

				if (timecode.getContenu().who_am_i() == "episode" && timecode.get_film_fini().isSelected() == false) {
					String split[] = timecode.get_time_code().getText().split(":");
					int TIME_code = Integer.parseInt(split[0]);
					Episode episode = (Episode) timecode.getContenu();
					nouveau = new Visionnage(0, user.getID(), 0, 0, episode.getID_serie(), episode.getID_saison(),
							episode.getID(), TIME_code);
				}

				if (timecode.getContenu().who_am_i() == "episode" && timecode.get_film_fini().isSelected() == true) {
					Episode episode = (Episode) timecode.getContenu();
					nouveau = new Visionnage(0, user.getID(), 0, 0, episode.getID_serie(), episode.getID_saison(),
							episode.getID(), -1);

				}

				boolean seen = false;
				for (int i = 0; i < visio.size(); i++) {
					if (((visio.get(i).getID_membre() == nouveau.getID_membre())
							&& visio.get(i).getID_film() == nouveau.getID_film())
							|| ((visio.get(i).getID_membre() == nouveau.getID_membre())
									&& visio.get(i).getID_documentaire() == nouveau.getID_documentaire())
							|| ((visio.get(i).getID_membre() == nouveau.getID_membre())
									&& visio.get(i).getID_episode() == nouveau.getID_episode()
									&& visio.get(i).getID_saison() == nouveau.getID_saison()
									&& visio.get(i).getID_serie() == nouveau.getID_serie())) {// film deja visionner
						seen = true;
					}

				}
				if (seen) {
					String split[] = timecode.get_time_code().getText().split(":");
					modele.maj_visionnage_BDD(timecode.getContenu(), user, Integer.parseInt(split[0]),
							timecode.get_film_fini().isSelected());
				}
				if (!seen) {
					modele.sauver_nv_visionnage_BDD(nouveau);
				}

				if (timecode.get_film_fini().isSelected() == false) {
					String split[] = timecode.get_time_code().getText().split(":");
					int TIME_code = Integer.parseInt(split[0]);
					modele.maj_contenu_BDD_note(timecode.getContenu(),
							Double.parseDouble(timecode.get_note().getText()), user, TIME_code,
							timecode.get_film_fini().isSelected());
				} else {
					modele.maj_contenu_BDD_note(timecode.getContenu(),
							Double.parseDouble(timecode.get_note().getText()), user, timecode.getContenu().getDuree(),
							timecode.get_film_fini().isSelected());
				}

				pageDAcceuil = new vue_home_page(user);
				timecode.delete(frame);
				pageDAcceuil.initialize(frame);
				setPageDAcceuilListeners(frame);
			}

		});
	}

}
