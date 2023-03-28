package Entite;

public abstract class PublicationVideo extends ContenuCinematographique {

	protected String trailer;

	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
}
