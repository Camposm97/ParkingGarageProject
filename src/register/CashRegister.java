package register;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import history.DailyData;
import pLData.ParkingLot;
import pLData.Space;
import util.DataLoader;
import util.DataSaver;

public class CashRegister {

	private int totalSales;
	private int ticketCounter;
	private DailyData todaysData;
	
	public CashRegister () {
		this.totalSales = 0;
		this.ticketCounter = 1;
		this.loadData();
	}
	public void closeTicket(ParkingLot pL, String licensePlate) {
		int spaceID = pL.vehicleFinder(licensePlate);
		Space tSpace = pL.spaceRelease(spaceID);
		Ticket ticket = new Ticket(tSpace, spaceID);
		double payment;
		String sP;
		try {
				sP = JOptionPane.showInputDialog(
					"The charge of your ticket is $" + ticket.getExpectedCost());
				sP = sP.replaceAll("[$]", "");
		   payment = Double.parseDouble(sP);
		}catch(Exception e) {
			payment = 0;
		}
		double eP = ticket.getExpectedCost();
		if(payment < eP) {
			do {
				try {
						sP = JOptionPane.showInputDialog("This is not enough to cover the charge pay at least: $"
							+ ticket.getExpectedCost());
						sP = sP.replaceAll("[$]", "");
				payment = Double.parseDouble(sP);
				}catch(Exception e) {
					payment = 0;
					
				}
			}while(payment < eP);
		}
		totalSales += payment;
		ticket.closeTicket(payment);
		System.out.println(ticket.getTicketString());
		todaysData.logTransaction(ticket.getTicketString());
		todaysData.logTransaction("Total Sales: " + this.totalSales);
	}
	
	public void makeDailyDataEntry(int spaceNumber) {
		Date date = new Date();
		String entry = new String();
		entry += "New Ticket Opened: \n" 
				+ date.toString() + "\n"
				+ "Space Number : " + spaceNumber + "\n"
				+ "****************************************\n";
		todaysData.logTransaction(entry);
		
	}

	public void loadData() {
		LocalDate date = LocalDate.now();
		String adr = "resources/daily" + date.getMonthValue() + date.getDayOfMonth() + ".data";
		File file = new File(adr);
		boolean exists = file.exists();
		if (exists) {
			DailyData data = (DailyData)DataLoader.readObject(adr);
			this.todaysData = data;
		}
		else {
			DailyData data = new DailyData();
			this.todaysData = data;
			DataSaver.writeObject(data, adr);
		}	
	}
	public void saveDailyData() {
		this.todaysData.saveDailyData();
	}
	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public int getTicketCounter() {
		return ticketCounter;
	}

	public void setTicketCounter(int ticketCounter) {
		this.ticketCounter = ticketCounter;

	}
	public DailyData getTodaysData() {
		return todaysData;
	}
	public void setTodaysData(DailyData todaysData) {
		this.todaysData = todaysData;
	}
	
}
