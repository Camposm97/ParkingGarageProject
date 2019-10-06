package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSaver {
	public static boolean writeObject(Object o, String src) {
		try {
			File file = new File(src);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			System.out.println("Successfully saved Object to: " + file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
