package register;

import pLData.Space;

public class Ticket {
	
	private Space space;
	private int spaceNumber;
	private int expectedHours;
	private int ticketNumber;
	private boolean open;
	private double payment;
	
	public Ticket (Space space, int spaceNumber, int hours, int ticketNumber) {
		this.space = space;
		this.spaceNumber = spaceNumber;
		this.expectedHours = hours;
		this.ticketNumber = ticketNumber;
		this.open = true;
		this.payment = 0;
	}
	
	public String getTicketString() {
		String str = new String();
		str += "****************************************\n" 
				+ "Ticket : " + this.ticketNumber + "\n" +
				"****************************************\n"
				+ "Vehicle Type : " + space.getVehicleParked().getVTypeS() + "\n"
				+ "Plate Number : " + space.getVehicleParked().getLicensePlate() + "\n"
				+ "Space : " + spaceNumber + "\n"
				+ "Rate : " + space.getSpecialRate() + "\n"
				+ "Expected Cost : " + this.getExpectedCost() + "\n";
		if (open == true) {
			str += "Ticket not paid yet\n";
		}
		else {
			str += "Ticket Paid\nTotal : " + this.payment + "\n" 
					+ "****************************************\n"; 
		}
		return str;
	}
	public void closeTicket(double payment) {
		this.payment = payment;
		this.open = false;
	}
	
	public double getExpectedCost() {
		return  this.space.getSpecialRate() * (double)this.expectedHours;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public int getSpaceNumber() {
		return spaceNumber;
	}

	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	public int getExpectedHours() {
		return expectedHours;
	}

	public void setExpectedHours(int expectedHours) {
		this.expectedHours = expectedHours;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}
	

}
