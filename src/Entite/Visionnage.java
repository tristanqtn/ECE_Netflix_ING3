package Entite;

public class Visionnage {
	private int ID;
	private int ID_membre;
	private int ID_film;
	private int ID_documentaire;
	private int ID_serie;
	private int ID_saison;
	private int ID_episode;
	private int time_code; // si cet entier est à -1 le film a déjà été visionné par l'utilisateur

	public Visionnage(int ID, int ID_membre, int ID_film, int ID_documentaire, int ID_serie, int ID_saison,
			int ID_episode, int time_code) {
		this.ID = ID;
		this.ID_membre = ID_membre;
		this.ID_film = ID_film;
		this.ID_documentaire = ID_documentaire;
		this.ID_serie = ID_serie;
		this.ID_saison = ID_saison;
		this.ID_episode = ID_episode;
		this.time_code = time_code;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_membre() {
		return ID_membre;
	}

	public void setID_membre(int iD_membre) {
		ID_membre = iD_membre;
	}

	public int getID_film() {
		return ID_film;
	}

	public void setID_film(int iD_film) {
		ID_film = iD_film;
	}

	public int getID_documentaire() {
		return ID_documentaire;
	}

	public void setID_documentaire(int iD_documentaire) {
		ID_documentaire = iD_documentaire;
	}

	public int getID_serie() {
		return ID_serie;
	}

	public void setID_serie(int iD_serie) {
		ID_serie = iD_serie;
	}

	public int getID_saison() {
		return ID_saison;
	}

	public void setID_saison(int iD_saison) {
		ID_saison = iD_saison;
	}

	public int getID_episode() {
		return ID_episode;
	}

	public void setID_episode(int iD_episode) {
		ID_episode = iD_episode;
	}

	public String toString() {
		return (this.ID + "\t " + this.ID_membre + "\t " + this.ID_film + "\t " + this.ID_documentaire + "\t "
				+ this.ID_serie + "\t " + this.ID_saison + "\t " + this.ID_episode + "\t" + this.time_code);
	}

	private String convert_0_null(Integer valeur) {
		if (valeur == 0) {
			return ("null");
		} else {
			return valeur.toString();
		}
	}

	public String toString_sql_insert() {
		return (this.ID_membre + ", " + convert_0_null(this.ID_film) + ", " + convert_0_null(this.ID_documentaire)
				+ ", " + convert_0_null(this.ID_serie) + ", " + convert_0_null(this.ID_saison) + ", "
				+ convert_0_null(this.ID_episode) + " , " + this.time_code + ");");
	}

	public int getTime_code() {
		return time_code;
	}

	public void setTime_code(int time_code) {
		this.time_code = time_code;
	}
}
