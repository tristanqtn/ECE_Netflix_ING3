package Main;

import java.sql.SQLException;

import Modele.BDD_exploitant;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BDD_exploitant exploit = null;
		try {
			exploit = new BDD_exploitant("root", "H!Jsihcl7YfTtp+SvKgo", true);
			exploit.toString();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
