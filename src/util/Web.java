package util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Web {
	public static final String CAMPOS_GITHUB = "https://github.com/Camposm97";
	public static final String DEMONTE_GITHUB = "https://github.com/chrisdemonte";
	public static final String GUIDI_GITHUB = "https://github.com/sayhimatt";
	
	public static void browse(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
