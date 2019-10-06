package control;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Gives a constructor where you can set the text of the label and set the font size.  
 * @author Michael Campos
 */
public class MyLabel extends Label {
	public MyLabel(String text, int fontSize) {
		super(text);
		super.setFont(Font.font(fontSize));
	}
}
