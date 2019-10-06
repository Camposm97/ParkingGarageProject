package view;

import java.io.File;
import java.time.LocalDate;

import history.DailyData;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import util.DataLoader;
import util.LightWork;
/**
 * This GUI element displays text that is stored in the project directory, using a date picker to select data created on certain days
 * @author chris demonte
 *
 */
public class HistoryPane {
	/**
	 * @param container is the parent container of the gui elements
	 * @param datePicker lets you pick the date
	 * @param taLog is the text area display for the data
	 * @param DailyData is the object container for the data that will be displayed
	 */
	private VBox container;
	private DatePicker datePicker;
	private TextArea taLog;
	private DailyData dailyData;

	public HistoryPane() {
		this.generateLayout();
		this.loadText(LocalDate.now());
	}

	/**
	 * Uses dailydata to fill the text area
	 * @param data
	 */
	public HistoryPane(DailyData data) {
		this.generateLayout();
		this.dailyData = data;
		this.taLog.setText(dailyData.toString());
	}

	/**
	 * generates the layer with the date picker on top and the text area on the bottom
	 */
	private void generateLayout() {
		taLog = new TextArea();
		taLog.setEditable(false);
		datePicker = new DatePicker();
		datePicker.setOnAction(e -> {
			this.loadText(this.datePicker.getValue());
		});
		container = LightWork.loadVBox(datePicker, taLog);
		container.setPadding(LightWork.DEFAULT_INSETS);
		container.setAlignment(Pos.CENTER);
	}

	/**
	 * Loads the date file using the file loader util
	 * @param date
	 */
	private void loadText(LocalDate date) {
		String src = LightWork.emitDailyLog(date);
		File file = new File(src);
		if (file.exists()) {
			DailyData data = (DailyData) DataLoader.readObject(src);
			this.dailyData = data;
			this.taLog.setText(dailyData.toString());
		} else {
			this.taLog.setText("There is no data for this day.");
		}
	}

	public VBox getContainer() {
		return container;
	}

	public TextArea getTaLog() {
		return taLog;
	}
}
