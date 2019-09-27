package controller;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class CamposButton extends Button {
	public CamposButton(String text, int fontSize) {
		super(text);
		super.setFont(Font.font(fontSize));
	}
}
