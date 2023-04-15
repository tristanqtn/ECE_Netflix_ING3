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

public class web_video_player {

	URI url;

	public web_video_player(String path) {
		if (path != null) {
			try {
				this.url = new URI(path);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public URI get_url() {
		return this.url;
	}

	public void set_url(URI path) {
		this.url = path;
	}

	public void play() {
		if (this.url != null) {
			try {
				Desktop.getDesktop().browse(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}