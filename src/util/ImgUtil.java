package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	
	public static Image loadImg(String url) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Image(fis);
	}

	public static ImageView loadImgV(String url) {
		return new ImageView(loadImg(url));
	}
}
