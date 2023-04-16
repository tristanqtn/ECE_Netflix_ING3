package Vue;

/**
 * 
 * @author tristan querton

 * 
 * Cette classe permet de lancer un video dans le browser de l'ordinateur
 *
 */

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//CLASSE RESPONSABLE DU LANCEMENT DES FILMS DANS LE BROWSER PAR DEFAUT
public class web_video_player {

	String url; // url vers la video

	// CONSTRUCTEUR
	public web_video_player(String path) {
		if (path != null) {
			url = path;
		}
	}

	// FONCTION DE LANCEMENT DE LA VIDEO
	public void play(boolean soustitre, boolean reprise, String qualite) {
		if (this.url != null) {// si url bien définie
			try {
				// CONFIGURATION DE LA QUALITE
				if (qualite == "720p") {
					url += "?vq=hd720";
				}
				if (qualite == "HD") {
					url += "?vq=hd1440";
				}
				if (qualite == "360p") {
					url += "?vq=medium";
				}
				if (qualite == "1080p") {
					url += "?vq=hd1080";
				}
				// ACTIVATION DES SOUSTITRES
				if (soustitre) {
					url += "?cc_load_policy=1";
				}

				URI final_url = new URI(url); // conversion de la string en URI
				Desktop.getDesktop().browse(final_url); // lancement de la recherche
			} catch (IOException | URISyntaxException e) {
				// exception
				e.printStackTrace();
			}
		}
	}
}