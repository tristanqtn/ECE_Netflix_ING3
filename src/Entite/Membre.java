package Entite;

import java.util.ArrayList;

public class Membre {

	private Integer ID;
	private String nom;
	private String prenom;
	private String adresse_mail;
	private long telephone;
	private String num_cb;
	private ArrayList<String> preferences;
	private String password;
	private Boolean admin;

	public Membre() {
		this.ID = 0;
		this.num_cb = "";
		this.telephone = 0;

		this.nom = "";
		this.prenom = "";
		this.adresse_mail = "";
		this.preferences = null;
		this.password = "";
		this.setAdmin(false);
	}

	public Membre(int ID, String nom, String prenom, String adresse_mail, long telephone, String num_cb,
			ArrayList<String> preferences, String mdp, boolean admin) {
		this.ID = ID;
		this.num_cb = num_cb;
		this.telephone = telephone;

		this.nom = nom;
		this.prenom = prenom;
		this.adresse_mail = adresse_mail;
		this.preferences = preferences;
		this.password = mdp;
		this.setAdmin(admin);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse_mail() {
		return adresse_mail;
	}

	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}

	public String getNum_cb() {
		return num_cb;
	}

	public void setNum_cb(String num_cb) {
		this.num_cb = num_cb;
	}

	public String toString() {
		return (this.ID + " " + this.num_cb + " " + this.telephone + " " + this.nom + " " + this.prenom + " "
				+ this.adresse_mail + " " + this.password + " " + this.preferences.toString() + this.admin);
	}

	public String toString_sql_insert() {
		return ("\"" + this.nom + "\", \"" + this.prenom + "\", \"" + this.adresse_mail + "\", " + this.telephone + ", "
				+ this.num_cb + ", \"" + get_preferences_format() + "\", \"" + this.password + "\", false);");
	}

	private String get_preferences_format() {
		String rendu = "";
		for (int i = 0; i < this.preferences.size(); i++) {
			rendu += this.preferences.get(i);
			if (i < this.preferences.size() - 1)
				rendu += " ; ";
		}
		return rendu;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
