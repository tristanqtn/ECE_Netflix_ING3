package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Modele.BDD_exploitant;
import Modele.BDD_interface;
import Vue.vue_administration;

public class Controleur_Admin implements ActionListener {

	private vue_administration vue;

	public Controleur_Admin() {
		vue = new vue_administration();
	}

	public void start(JFrame frame) {
		vue.initialize(frame);
		this.set_listeners();
	}
	
	public void end(JFrame frame) {
		vue.delete(frame);
	}

	private void set_listeners() {
		this.vue.get_button_afficher_bdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Controleur_Modele ctrl = new Controleur_Modele("root", "root", false);
				ctrl.afficher_documentaires();
				ctrl.afficher_films();
				ctrl.afficher_membres();
				ctrl.afficher_visionnages();
				ctrl.afficher_series();
				ctrl.afficher_saisons();
				ctrl.afficher_episodes();
			}
		});

		this.vue.get_button_creer_bdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					BDD_exploitant exploit = new BDD_exploitant("root", "root", false);
					exploit.BDD_suppression_schema();
					exploit.BDD_generation_schema();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}

			}
		});

		this.vue.get_button_nettoyer_bdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					BDD_exploitant exploit = new BDD_exploitant("root", "root", false);
					exploit.BDD_suppression_schema();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}

			}
		});

		this.vue.get_button_exec_requete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BDD_interface exploit = new BDD_interface("root", "root");
				exploit.executer_maj(vue.get_commande_sql());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public JButton getRetour() {
		return vue.getRetour();
	}

}
