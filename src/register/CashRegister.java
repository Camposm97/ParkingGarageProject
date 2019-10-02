package register;

import java.util.ArrayList;
import java.util.Date;

import history.DailyData;
import pLData.ParkingLot;
import pLData.Space;
import vehicleH.Vehicle;

public class CashRegister {

	private int totalSales;
	private int ticketCounter;
	private ArrayList<Ticket> ticketList;
	private DailyData todaysData;
	
	public CashRegister () {
		this.totalSales = 0;
		this.ticketCounter = 1;
		ticketList = new ArrayList<Ticket>();
	}
	public void addTicket (ParkingLot lot, Vehicle vehicle, int hours, boolean skipType) {
		int spaceNumber = lot.spaceFinder(vehicle.getVType(), skipType);
		
		//So this is using my spaceInserter method. We shouldn't have to add a ticket in once we have inserted a vehicle only when they leave
		
		
		Ticket ticket = new Ticket (lot.spaceInserter(vehicle, spaceNumber), spaceNumber, hours, this.ticketCounter); 
		ticketList.add(ticket);
		ticketCounter++;
		this.makeDailyDataEntry(spaceNumber);
	}
	public void closeTicket(ParkingLot lot, int ticketNumber, double payment) {
		Ticket ticket = ticketList.get(ticketNumber - 1);
		ticket.closeTicket(payment);
		lot.spaceRelease(ticket.getSpaceNumber());
		todaysData.logTransaction(ticket.getTicketString());
	}
	
	private void makeDailyDataEntry(int spaceNumber) {
		Date date = new Date();
		String entry = new String();
		entry += "New Ticket Opened: \n" 
				+ date.toString() + "\n"
				+ "Space Number : " + spaceNumber + "\n"
				+ "****************************************\n";
		todaysData.logTransaction(entry);
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

	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}
	
	
}
