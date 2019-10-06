package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 * Writes the given object to a file
 * @author Michael Campos
 *
 */
public class DataSaver {
	/**
	 * 
	 * @param o Object to be written into the file
	 * @param src The filepath for FileOutPutStream to use
	 * @return returns true if successful
	 */
	public static boolean writeObject(Object o, String src) {
		try {
			File file = new File(src);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
