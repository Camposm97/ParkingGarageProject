package util;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CamposFX {
	public VBox loadVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		for (Node n : nodes)
			vBox.getChildren().add(n);
		return vBox;
	}
	
	public HBox loadHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		for (Node n : nodes)
			hBox.getChildren().add(n);
		return hBox;
	}
}
