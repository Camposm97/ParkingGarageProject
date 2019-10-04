package register;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import history.DailyData;
import pLData.ParkingLot;
import pLData.Space;
import util.DataLoader;
import util.DataSaver;
import vehicleH.Vehicle;

public class CashRegister {

	private int totalSales;
	private int ticketCounter;
	private DailyData todaysData;
	private ParkingLot lot;
	
	public CashRegister () {
		this.totalSales = 0;
		this.ticketCounter = 1;
	}
	public void closeTicket(ParkingLot pL, String licensePlate) {
		int spaceID = pL.vehicleFinder(licensePlate);
		Space tSpace = pL.spaceRelease(spaceID);
		Ticket ticket = new Ticket(tSpace, spaceID);
		double payment = Double.parseDouble(JOptionPane.showInputDialog(
				"The charge of your ticket " + ticket.getExpectedCost()));
		double eP = ticket.getExpectedCost();
		if(payment < eP) {
			do {
				payment = Double.parseDouble(JOptionPane.showInputDialog("This is not enough to cover the charge pay at least: "
						+ ticket.getExpectedCost()));
			}while(payment < eP);
		}
		this.loadData();
	}
	/*public void addTicket (ParkingLot lot, Vehicle vehicle, int hours, boolean skipType) {
		int spaceNumber = lot.spaceFinder(vehicle.getVType(), skipType);
		
		//So this is using my spaceInserter method. We shouldn't have to add a ticket in once we have inserted a vehicle only when they leave
		
		
		Ticket ticket = new Ticket(); 
		ticketList.add(ticket);
		ticketCounter++;
		this.makeDailyDataEntry(spaceNumber);
	}
	
	public void checkOut(String plateNo,  double payment) {
		Ticket ticket = new Ticket(lot.sp);
>>>>>>> 4bda4dd4102cdeba01a26606d12f182c2bc78050
		ticket.closeTicket(payment);
		todaysData.logTransaction(ticket.getTicketString());
<<<<<<< HEAD
		this.totalSales++;
		this.ticketCounter++;
	}
	/*
=======
	}
	*/
	private void makeDailyDataEntry(int spaceNumber) {
		Date date = new Date();
		String entry = new String();
		entry += "New Ticket Opened: \n" 
				+ date.toString() + "\n"
				+ "Space Number : " + spaceNumber + "\n"
				+ "****************************************\n";
		todaysData.logTransaction(entry);
	}

	public void loadData() {
		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("MMdd");
		String adr = "/resources/daily" + form.format(date) + ".data";
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
}
