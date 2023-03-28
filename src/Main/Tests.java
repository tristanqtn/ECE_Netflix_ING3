package Main;

import java.sql.SQLException;
import java.util.Vector;

import Entite.Documentaire;
import Entite.Film;
import Entite.Membre;
import Modele.BDD_exploitant;

public class Tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BDD_exploitant exploit = null;
		try {
			exploit = new BDD_exploitant("root", "H!Jsihcl7YfTtp+SvKgo", false);

			Vector<Documentaire> vect_1 = exploit.extraire_documentaires_BDD();
			Vector<Membre> vect_2 = exploit.extraire_membre_BDD();
			Vector<Film> vect_3 = exploit.extraire_films_BDD();
//			Vector<Serie> vect_4 = exploit.extraire_series_BDD();
//			Vector<Saison> vect_5 = exploit.extraire_saisons_BDD();
//			Vector<Episode> vect_6 = exploit.extraire_episodes_BDD();

			System.out.println("DOCUMENTAIRES");
			for (int i = 0; i < vect_1.size(); i++) {
				System.out.println(vect_1.get(i).toString());
			}

			System.out.println("MEMBRES");
			for (int i = 0; i < vect_2.size(); i++) {
				System.out.println(vect_2.get(i).toString());
			}

			System.out.println("FILMS");
			for (int i = 0; i < vect_3.size(); i++) {
				System.out.println(vect_3.get(i).toString());
			}

			exploit.ajouter_membre_BDD(vect_2.get(0));

//			System.out.println("SERIES");
//			for (int i = 0; i < vect_4.size(); i++) {
//				System.out.println(vect_4.get(i).toString());
//			}
//
//			System.out.println("SAISONS");
//			for (int i = 0; i < vect_5.size(); i++) {
//				System.out.println(vect_5.get(i).toString());
//			}
//
//			System.out.println("EPISODES");
//			for (int i = 0; i < vect_6.size(); i++) {
//				System.out.println(vect_6.get(i).toString());
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
