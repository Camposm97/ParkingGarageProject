package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Purpose of this class is to store the paths of the images in the "images" folder
 * and to provide methods to load them in using JavaFX.
 * @author Michael Campos
 */
public class ImgUtil {
	public static final String EXIT_ICON = "images/exit.png";
	public static final String GITHUB_ICON = "images/github.png";
	public static final String HEAVY_WORK = "images/heavy_work.gif";
	public static final String LIGHT_WORK = "images/light_work.gif";
	public static final String INSERT_ICON = "images/insert.png";
	public static final String DELETE_ICON = "images/delete.png";
	public static final String USER_ICON = "images/user.png";
	public static final String WORK_ICON = "images/work.png";
	public static final String HISTORY_ICON = "images/history.png";
	public static final String GARAGE_ICON = "images/garage.png";
	public static final String JAVADOC_ICON = "images/javadoc.png";
	
	/**
	 * Returns an Image using the parameter (url) as a File. If the path to the file does not exist
	 * then the method will return null.
	 * @param url The path to grab the image
	 * @return Image Returns the image found at the path
	 */
	public static Image loadImg(String url) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return new Image(fis);
	}
	
	/**
	 * Uses loadImg(String url) to return an ImageView.  
	 * @param url The path to grab the image
	 * @return ImageView Returns Image in this form for GUI application
	 */
	public static ImageView loadImgV(String url) {
		return new ImageView(loadImg(url));
	}
}
