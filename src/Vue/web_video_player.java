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

    String url;

    public web_video_player(String path) {
        if (path != null) {
            url = path;
        }

    }

    public void play(boolean soustitre, boolean reprise, String qualite) {
        if (this.url != null) {
            try {

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
                if (soustitre) {
                    url += "?cc_load_policy=1";
                }
                System.out.println(url);
                URI final_url = new URI(url);
                Desktop.getDesktop().browse(final_url);
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}