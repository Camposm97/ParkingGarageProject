package util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class stores the URLs of everyone who worked on this project and provides one method to open them.
 * @author Camposm97
 */
public class Web {
	public static final String CAMPOS_GITHUB = "https://github.com/Camposm97";
	public static final String DEMONTE_GITHUB = "https://github.com/chrisdemonte";
	public static final String GUIDI_GITHUB = "https://github.com/sayhimatt";
	
	/**
	 * Takes the given String and attempts to open the URL using
	 * the system's default browser.
	 * @param url
	 */
	public static void browse(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
