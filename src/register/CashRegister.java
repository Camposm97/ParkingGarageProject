package register;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import history.DailyData;
import pLData.ParkingLot;
import pLData.Space;
import vehicleH.Vehicle;

public class CashRegister {

	private int totalSales;
	private int ticketCounter;
	private DailyData todaysData;
	
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
		ticket.closeTicket(payment);
		todaysData.logTransaction(ticket.getTicketString());
		this.totalSales++;
		this.ticketCounter++;
	}
	/*
	private void makeDailyDataEntry(int spaceNumber) {
		Date date = new Date();
		String entry = new String();
		entry += "New Ticket Opened: \n" 
				+ date.toString() + "\n"
				+ "Space Number : " + spaceNumber + "\n"
				+ "****************************************\n";
		todaysData.logTransaction(entry);
	}*/

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
