package Main;

import java.util.ArrayList;

import Controleur.Controleur_Modele;
import Entite.Membre;
import Entite.Visionnage;

public class Tests {

	public static void main(String[] args) {
		Controleur_Modele ctrl = new Controleur_Modele("root", "root", false);
		ctrl.afficher_documentaires();
		ctrl.afficher_films();
		ctrl.afficher_membres();
		ctrl.afficher_visionnages();
		ctrl.afficher_series();
		ctrl.afficher_saisons();
		ctrl.afficher_episodes();

		ArrayList<String> prefe = new ArrayList<String>();
		prefe.add("Dessins animes");
		prefe.add("Combat");
		prefe.add("Japon");

		ctrl.sauver_nv_membre_BDD(new Membre(0, "Denson", "Sarujan", "sarujan@gmail.com", 1123456789,
				"1234567891234567", prefe, "saruLEbg!"));
		ctrl.sauver_nv_visionnage_BDD(new Visionnage(0, 3, 0, 0, 1, 2, 2, 20));

	}

}
