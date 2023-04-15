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

/**
 * 
 * @author tristan querton
 * 
 *         Cette classe est basée sur l'exploitation de la classe Connection des
 *         bibliothèque de gestion mySQL JAVA. On y trouve toutes les fonctions
 *         pour assurer la connection au SERVICE LOCAL mySQL et l'execution de
 *         requetes et/ou MAJ des BDD.
 * 
 *         CETTE CLASSE NE DOIT PAS ETRE UTILISEE PAR AUTRE CHOSE QU'UNE CLASSE
 *         BDD_EXPLOITANT
 *
 */

public class BDD_interface {

	private Connection connecteur;

	// CONSTRUCTEUR DE L'INTERFACE DE BDD
	public BDD_interface(String utilisateur, String mdp) {

		try {
			// enregistrement du driver de connection java vers BDD
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// connection à la base
			String mysqlUrl = "jdbc:mysql://localhost"; // chemin vers la BDD
			this.connecteur = DriverManager.getConnection(mysqlUrl, utilisateur, mdp); // connection avec le profil
																						// renseigné en parametre
			System.out.println("Connexion au service mySQL reussi ......"); // message de valitation
		} catch (SQLException e) {
			// gestion des exceptions
			e.printStackTrace();
		}

	}

	// GETTER DU CONNECTEUR VERS BDD
	public Connection get_connecteur() {
		return connecteur;
	}

	// FONCTION D'EXECUTION DE REQUETES DE LA BDD
	public ResultSet executer_requete(String requete) {
		// reception de la requete en parametre
		// les requetes sur la BDD renvoient des ResultSet
		ResultSet resultSet = null; // initialisation du resultat de la requete
		try {
			java.sql.Statement statement = this.connecteur.createStatement(); // creation du nv statement SQL
			resultSet = statement.executeQuery(requete); // execution de la requete reçu en string par le statement
		} catch (SQLException e) {
			// gestion des exceptions
			e.printStackTrace();
		}
		return resultSet; // rendu du resultat de la requete
	}

	// FONCTION D'EXECUTION DE MISE A JOUR DE LA BDD
	public void executer_maj(String requete) {
		// reception de la requete en parametre
		// les MAJ de BDD ne renvoient pas de ResultSet
		try {
			java.sql.Statement statement = this.connecteur.createStatement(); // creation du nv statement SQL
			statement.execute(requete); // execution de la requete reçu en string par le statement
		} catch (SQLException e) {
			// gestion des exceptions
			e.printStackTrace();
		}

	}

	// FONCTION PERMETTANT L'EXECUTION DE SCRIPT SQL DEPUIS UN FICHIER .SQL
	public void executer_script_sql(String adresse) {

		// recuperation de la position actuel de l'application dans l'arborescence
		String filePath = new File("").getAbsolutePath();
		String chemin_script = filePath + adresse; // generation de l'addresse completer du fichier .sql

		try {
			BDD_ScriptRunner sr = new BDD_ScriptRunner(connecteur, false, false); // creation d'un executeur de script
			Reader reader = null; // initialisation du lecteur de fichiers
			reader = new BufferedReader(new FileReader(chemin_script)); // lecture complete du fichier .sql
			try {
				sr.runScript(reader); // execution du script lu par le reader par l'executeur
			} catch (IOException | SQLException e) {
				// gestion des exceptions
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// gestion des exceptions
			e.printStackTrace();
		}
	}
}
