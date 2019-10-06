package model;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

import history.DailyData;
import util.DataLoader;
import util.DataSaver;
import util.LightWork;
/**
 * CashRegister is coordinates the interaction between the garage and the point of sale. 
 * It closes tickets, takes in payments, and keeps logs of the transactions throughout the day
 * @author Chris DeMonte, Matt Guidi
 *
 */
public class CashRegister {

	/**
	 * ticketCounter keeps track of the total number of visitors that day
	 * todaysData holds logs of the transactions throughout the day
	 * activeUser is the user logged in to the cash register
	 */
	private int ticketCounter;
	private DailyData todaysData;
	private UserData activeUser;
	
	/**
	 * The constructor takes in the active user in the userDataManager, sets the ticket counter to 1, and atempts to load the DailyData for the current day
	 * @param activeUser comes from the UserDataManager
	 */
	public CashRegister (UserData activeUser) {
		this.ticketCounter = 1;
		this.activeUser = activeUser;
		this.loadData();
	}

	/**
	 * This method closes out an order, opens up a spot in the garage, and completes the transaction
	 * @param pL is the runtime instance of the parkinglot
	 * @param licensePlate is a string entered by the user
	 * @param s is a state abbreviation entered by the user
	 */
	public void closeTicket(ParkingLot pL, String licensePlate, State s) {
		int spaceID = pL.vehicleFinder(licensePlate, s);
		Space tSpace = pL.spaceRelease(spaceID);
		Ticket ticket = new Ticket(tSpace, spaceID, this.activeUser);
		double payment;
		String sP;
		String tP = String.format("%.2f", ticket.getExpectedCost());
		try {
			sP = JOptionPane.showInputDialog("The charge of your ticket is $" + tP);
			sP = sP.replaceAll("[$]", "");
			payment = Double.parseDouble(sP);
		} catch (Exception e) {
			payment = 0;
		}
		double eP = ticket.getExpectedCost();
		if (payment < eP) {
			do {
				try {
					sP = JOptionPane.showInputDialog("This is not enough to cover the charge pay at least: $" + tP);
					sP = sP.replaceAll("[$]", "");
					payment = Double.parseDouble(sP);
				} catch (Exception e) {
					payment = 0;

				}
			} while (payment < eP);
		}
		
		ticket.closeTicket(payment);
		todaysData.addToSales(payment);
		todaysData.logTransaction(ticket.getTicketString());
		todaysData.logTransaction("Total Sales: " + payment + "\n");
		
		this.saveDailyData();
	}

	/**
	 * Records the when a space is occupied by a new car
	 * @param spaceNumber is the space being filled
	 */
	public void makeDailyDataEntry(int spaceNumber) {
		Date date = new Date();
		String entry = new String();
		entry += "New Ticket Opened: \n" + date.toString() + "\n" + "Space Number : " + spaceNumber + "\n"
				+ "****************************************\n";
		todaysData.logTransaction(entry);

	}

	/**
	 * Reads a dailydata object stored in a file and sets the cashRegister's dailyData.
	 * If there is no file a new one is created.
	 */
	public void loadData() {
		LocalDate date = LocalDate.now();
		String src = LightWork.emitDailyLog(date);
		File file = new File(src);
		boolean exists = file.exists();
		if (exists) {
			DailyData data = (DailyData) DataLoader.readObject(src);
			this.todaysData = data;
		} else {
			DailyData data = new DailyData();
			this.todaysData = data;
			DataSaver.writeObject(data, src);
		}
	}

	/**
	 * saves the dailyData stored in the cashRegister to a file.
	 */
	public void saveDailyData() {
		this.todaysData.saveDailyData();
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
