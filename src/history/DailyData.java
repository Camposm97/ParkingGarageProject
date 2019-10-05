package history;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import pLData.ParkingLot;
import util.DataSaver;

public class DailyData implements Serializable{

	private static final long serialVersionUID = -2995963835008199289L;
	ArrayList<String> salesLog;
	ArrayList<String> garageLog;
	
	public DailyData() {
		salesLog = new ArrayList<String>();
		garageLog = new ArrayList<String>();
		this.startLogs();
	}

	private void startLogs() {
		Date date = new Date();
		String openRegister = new String ("Register Opened: " + date.toString());
		salesLog.add(openRegister);
		String openParkingLot = new String ("Parking Lot Opened " + date.toString());
		garageLog.add(openParkingLot);
	}
	
	public void logTransaction (String transaction) {
		salesLog.add(transaction);
	}
	public void logGarage(ParkingLot lotData) {
		Date date = new Date();
		garageLog.add(date.toString() + "\n" + lotData.toString());
	}

	@Override
	public String toString() {
		Date date = new Date();
		String output = new String();
		output += "Garage Log : " + date.toString() + "\n";
		output += "****************************************\n"
				+ "\tSales\n"
				+ "****************************************\n";
		for (int i = 0; i < salesLog.size(); i++) {
			output += salesLog.get(i);
		}
		output += "\n****************************************\n"
				+ "\tGarage\n"
				+ "****************************************\n";
		for (int i = 0; i < garageLog.size(); i++) {
			output += garageLog.get(i);
			output += "\n****************************************\n";
		}
	
		return output;
	}
	public void saveDailyData() {
		LocalDate date = LocalDate.now();
		String adr = "resources/daily" + date.getMonthValue() + date.getDayOfMonth() + ".data";
		DataSaver.writeObject(this, adr);
	}
}
