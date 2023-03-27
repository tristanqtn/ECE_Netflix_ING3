package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDD_interface {

	private Connection connecteur;

	public BDD_interface(String utilisateur, String mdp) throws SQLException {
		// Registering the Driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			// Getting the connection
			String mysqlUrl = "jdbc:mysql://localhost";
			this.connecteur = DriverManager.getConnection(mysqlUrl, utilisateur, mdp);
			System.out.println("Connection established......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection get_connecteur() {
		return connecteur;
	}

	public ResultSet executer_requete(String requete) {
		// Statements allow to issue SQL queries to the database
		// Result set get the result of the SQL query
		ResultSet resultSet = null;
		try {
			java.sql.Statement statement = this.connecteur.createStatement();
			resultSet = statement.executeQuery(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;

	}

	public void executer_maj(String requete) {
		// Statements allow to issue SQL queries to the database
		// Result set get the result of the SQL query
		try {
			java.sql.Statement statement = this.connecteur.createStatement();
			statement.execute(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void executer_script_sql(String adresse) {
		String filePath = new File("").getAbsolutePath();
		String chemin_script = filePath + adresse;

		try {
			BDD_ScriptRunner sr = new BDD_ScriptRunner(connecteur, false, false);
			// Creating a reader object
			Reader reader = null;
			reader = new BufferedReader(new FileReader(chemin_script));
			try {
				sr.runScript(reader);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Running the script
	}
}
