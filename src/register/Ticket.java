package register;

import pLData.Space;
import pLData.ParkingLot;

public class Ticket {
	
	private Space space;
	private int spaceNumber;
	private double expectedHours;
	// Let's make this static! That way it's the same across the board
	private static int ticketNumberC = 0;
	private int ticketID;
	private boolean open;
	private double payment;
	
	
	// We're going to make a Ticket object the moment they leave. That way it's a one
	// and done kind of deal. All they need to give us is their spaceNumber and we can find the rest!
	
	public Ticket (Space space, int spaceID) {
		
		this.space = space;
		this.spaceNumber = spaceID;
		this.expectedHours = ((double)(System.currentTimeMillis() * this.space.getTimeModifier())
								- this.space.getTimeA()) / 3600000;
		this.payment =  getExpectedCost();
		System.out.println("The payment I calculated is " + this.payment);
		this.open = true;
		this.ticketID = ticketNumberC++;
	
	}
	
	public String getTicketString() {
		String str = new String();
		str += "****************************************\n" 
				+ "Ticket : " + this.ticketID + "\n" +
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
		System.out.println(this.expectedHours);
		return  (100 / (this.spaceNumber + 1))*
				(this.space.getSpecialRate() * this.expectedHours);
		
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

	public double getExpectedHours() {
		return expectedHours;
	}

	public void setExpectedHours(int expectedHours) {
		this.expectedHours = expectedHours;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketID = ticketNumber;
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
