package register_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pLData.Space;
import register.Ticket;
import vehicleH.Vehicle;
import vehicleH.VehicleType;

class TicketT {
	
	public Space spaceTest = new Space(VehicleType.CAR);
	public Vehicle v1 = new Vehicle("123-4567",VehicleType.CAR, "N/A");
	@Test
	void testTicketCreation() throws InterruptedException {
		spaceTest.vehicleInsertion(v1);
		// Now that a vehicle is inserted this can be used to calculate some #
		Thread.sleep(1);
		Ticket t1 = new Ticket(spaceTest, 0);
		
		System.out.println(t1.getExpectedCost());
		t1.closeTicket(300);
		assertEquals(t1.isOpen(), false);
		
	}
	

}
