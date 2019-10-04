package view;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import history.DailyData;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import util.DataLoader;
import util.DataSaver;

public class HistoryPane {
	
	VBox container; 
	DatePicker datePicker;
	TextArea text; 
	DailyData dailyData;
	
	public HistoryPane() {
		this.generateLayout();
		this.loadText(LocalDate.now());
	}
	public HistoryPane(DailyData data) {
		this.generateLayout();
		this.dailyData = data;
		this.text.setText(dailyData.toString());
	}

	private void generateLayout() {
		container = new VBox();
		text = new TextArea();	
		text.setEditable(false);
		datePicker = new DatePicker();
		datePicker.setOnAction(e->{
			this.loadText(this.datePicker.getValue());
		});
		container.getChildren().addAll(datePicker, text);	
	}	

	private void loadText(LocalDate date) {
		SimpleDateFormat form = new SimpleDateFormat("MMdd");
		String adr = "/resources/daily" + form.format(date) + ".data";
		File file = new File(adr);
		boolean exists = file.exists();
		if (exists) {
			DailyData data = (DailyData)DataLoader.readObject(adr);
			this.dailyData = data;
			this.text.setText(dailyData.toString());
		}
		else {
			this.text.setText("There is no data for this day.");
		}	
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public TextArea getText() {
		return text;
	}

	public void setText(TextArea text) {
		this.text = text;
	}

}
