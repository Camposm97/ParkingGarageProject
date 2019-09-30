package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImgUtil {
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
