package Modele;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BDD_exploitant exploit = null;
		try {
			exploit = new BDD_exploitant("root", "H!Jsihcl7YfTtp+SvKgo", true);
			exploit.afficher_films();
			exploit.afficher_documentaires();
			exploit.afficher_membres();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
