package register;

import pLData.Space;
import userData.UserData;

public class Ticket {
	
	private Space space;
	private int spaceNumber;
	private double expectedHours;
	// Let's make this static! That way it's the same across the board
	private static int ticketNumberC = 1;
	private int ticketID;
	private boolean open;
	private double payment;
	private UserData activeUser;
	
	
	// We're going to make a Ticket object the moment they leave. That way it's a one
	// and done kind of deal. All they need to give us is their spaceNumber and we can find the rest!
	
	public Ticket (Space space, int spaceID, UserData activeUser) {
		
		this.space = space;
		this.spaceNumber = spaceID;
		this.expectedHours = (((System.currentTimeMillis() * this.space.getTimeModifier())
								- this.space.getTimeA()) / 3600000);
		this.payment =  getExpectedCost();
		//System.out.println("The payment I calculated is " + this.payment);
		this.open = true;
		this.activeUser = activeUser;
		this.ticketID = ticketNumberC++;
	
	}
	
	public String getTicketString() {
		String str = new String();
		String eC = String.format("%.2f", this.getExpectedCost());
		str += "\n****************************************\n" 
				+ "Ticket : " + this.ticketID + "\n" +
				"Attendant : " + this.activeUser.getFirstName() + 
				"\n****************************************\n"
				+ "Vehicle Type : " + space.getVehicleParked().getVTypeS() + "\n"
				+ "State: " + space.getVehicleParked().getVehicleState().toString() + "\n"
				+ "Plate Number : " + space.getVehicleParked().getLicensePlate() + "\n"
				+ "Space : " + spaceNumber + "\n"
				+ "Rate : " + space.getSpecialRate() + "\n"
				+ "Expected Cost : " + eC + "\n";
		if (open == true) {
			str += "Ticket not paid yet\n";
		}
		else {
			String tP = String.format("%.2f", this.payment);
			String xC = String.format("%.2f", (this.payment - this.getExpectedCost()));
			str += "Ticket Paid\nTotal : " + tP + "\n" 
				  +"Extra change : " + xC
					+ "\n****************************************\n"; 
			
		}
		return str;
	}
	public void closeTicket(double payment) {
		
		this.payment = payment;
		
		this.open = false;
	}
	
	public double getExpectedCost() {
		double d = (100 / (this.spaceNumber + 1))*
				(this.space.getSpecialRate() * this.expectedHours);
		d = Math.round(d *100.0)/100.0;
		return d;
		
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
