package Controleur;

/**
 * 
 * @author tristan querton
 * 
 *         Ce controleur gère la vue d'administration. C'est ici des les requetes faites par l'administrateur sont executées
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Modele.BDD_exploitant;
import Modele.BDD_interface;
import Stats.Afficheur_Stats;
import Vue.vue_administration;

public class Controleur_Admin {

	private vue_administration vue;

	public Controleur_Admin() {
		vue = new vue_administration();
		this.set_listeners();
	}

	public void start(JFrame frame) {//On affiche la vue administrateur
		vue.initialize(frame);
	}

	public void end(JFrame frame) {//On désaffiche la vue administrateur
		vue.delete(frame);
	}

	private void set_listeners() {//On ajoute les listeners
		this.vue.get_button_afficher_bdd().addActionListener(new ActionListener() {// affichage de la base de données et des stats
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Controleur_Modele ctrl = new Controleur_Modele("root", "root", false); // requetage SQL
				// AFFICHAGE
				ctrl.afficher_documentaires();
				ctrl.afficher_films();
				ctrl.afficher_membres();
				ctrl.afficher_visionnages();
				ctrl.afficher_series();
				ctrl.afficher_saisons();
				ctrl.afficher_episodes();
				@SuppressWarnings("unused")
				Afficheur_Stats stats = new Afficheur_Stats(ctrl.getMembres()); // création d'un afficheur de
																				// statistiques
			}
		});

		this.vue.get_button_creer_bdd().addActionListener(new ActionListener() {// creation de la BDD
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					BDD_exploitant exploit = new BDD_exploitant("root", "root", false);
					exploit.BDD_suppression_schema(); // suppression du schema
					exploit.BDD_generation_schema(); // creation du schema
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}

			}
		});

		this.vue.get_button_nettoyer_bdd().addActionListener(new ActionListener() {
			// suppression de la BDD
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					BDD_exploitant exploit = new BDD_exploitant("root", "root", false);
					exploit.BDD_suppression_schema(); // suppression du schema
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}

			}
		});

		this.vue.get_button_exec_requete().addActionListener(new ActionListener() {
			// executer une requete SQL
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BDD_interface exploit = new BDD_interface("root", "root"); // creation de l'interface SQL
				exploit.executer_maj(vue.get_commande_sql()); // execution de la requete
			}
		});
	}

	public JButton getRetour() {// btn retour
		return vue.getRetour();
	}

}
