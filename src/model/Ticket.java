package model;
/**
 * The ticket class is used to close and format a nice string that'll be used
 * to help inform the driver of their charge and be logged in the data to be viewed
 * @author Matt Guidi, Chris Demonte
 *
 */
public class Ticket {
	
	private Space space;
	private int spaceNumber;
	private double expectedMinutes;
	// Let's make this static! That way it's the same across the board
	private static int ticketNumberC = 1;
	private int ticketID;
	private boolean open;
	private double payment;
	private UserData activeUser;
	
	/**
	 * 
	 * @param space Holds a lot of the data calculated for payment. Copy of actual space
	 * @param spaceID Used for logging where they were parked (for proximity charge)
	 * @param activeUser Used for logging who helped check this user out
	 */
	public Ticket (Space space, int spaceID, UserData activeUser) {
		
		this.space = space;
		this.spaceNumber = spaceID;
		this.expectedMinutes = (double)(((System.currentTimeMillis()- this.space.getTimeA()) * this.space.getTimeModifier()));
		this.expectedMinutes = (double)(this.expectedMinutes / 60000.0);
		this.payment =  getExpectedCost();
		//System.out.println("The payment I calculated is " + this.payment);
		this.open = true;
		this.activeUser = activeUser;
		this.ticketID = ticketNumberC++;
	
	}
	/**
	 * 
	 * @return Returns a nice receipt of their transaction and details about their stay
	 */
	public String getTicketString() {
		String str = new String();
		String mP = String.format("%.2f", this.getExpectedMinutes());
		str += "\n****************************************\n" 
				+ "Ticket : " + this.ticketID + "\n" +
				"Attendant : " + this.activeUser.getFirstName() + this.activeUser.getLastName().charAt(0) + 
				"\n****************************************\n"
				+ "Vehicle Type : " + space.getVehicleParked().getVTypeS() + "\n"
				+ "State: " + space.getVehicleParked().getVehicleState().toString() + "\n"
				+ "Plate Number : " + space.getVehicleParked().getLicensePlate() + "\n"
				+ "Space : " + spaceNumber + "\n"
				+ "Rate : " + space.getSpecialRate() + "\n"
				+ "Minutes Parked : " + mP + " minutes\n"
				+ "Expected Cost : $" + this.getExpectedCost() + "\n";
		if (open == true) {
			str += "Ticket not paid yet\n";
		}
		else {
			String tP = String.format("%.2f", this.payment);
			String xC = String.format("%.2f", (this.payment - this.getExpectedCost()));
			str += "Total Paid: $" + tP + "\n" 
				  +"Extra change : $" + xC
					+ "\n****************************************\n"; 
			
		}
		return str;
	}
	/**
	 * Closes the ticket and logs the amount of money the driver paid
	 * @param payment Money the driver paid NOT the cost!
	 */
	public void closeTicket(double payment) {
		
		this.payment = payment;
		
		this.open = false;
	}
	/**
	 * Calculates an expected cost based on the special rate and proximity from the entrance
	 * @return returns the cost to charge the customer in the form of a double
	 */
	public double getExpectedCost() {
		double d = (100 / (this.spaceNumber + 1.0));
		d = d * (this.space.getSpecialRate() * this.expectedMinutes);
		String eC = String.format("%.2f", d);
		d = Double.parseDouble(eC);
		return d;
		
	}
	/**
	 * 
	 * @return Gives the space being used to calculate data
	 */
	public Space getSpace() {
		return space;
	}
	/**
	 * 
	 * @param space sets the space being used for the ticket
	 */
	public void setSpace(Space space) {
		this.space = space;
	}
	/**
	 * 
	 * @return returns the parking space's number in the parking lot array
	 */
	public int getSpaceNumber() {
		return spaceNumber;
	}
	/**
	 * 
	 * @param spaceNumber Modifies the space number passed in
	 */
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	/**
	 * 
	 * @return Gives the expected hours calculated in the form of a double
	 */
	public double getExpectedMinutes() {
		return expectedMinutes;
	}
	/**
	 * 
	 * @param expectedHours Set the expected hours to this integer 
	 */
	public void setExpectedMinutes(int expectedMinutes) {
		this.expectedMinutes = (double)expectedMinutes;
	}
	/**
	 * 
	 * @return Get the ID of the ticket in the form of an integer
	 */
	public int getTicketID() {
		return ticketID;
	}
	/**
	 * 
	 * @param ticketNumber This integer will be set to the new ticket number for this ticket
	 */
	public void setTicketNumber(int ticketNumber) {
		this.ticketID = ticketNumber;
	}
	/**
	 * 
	 * @return Returns true if the ticket is open (Driver hasn't paid yet)
	 */
	public boolean isOpen() {
		return this.isOpen();
	}
	
	

}
