package pL_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Space;
import model.Vehicle;
import model.VehicleType;
import model.*;

class SpaceT {
	public Space spaceTruck = new Space(VehicleType.TRUCK);
	public Vehicle v1 = new Vehicle("123-1234", VehicleType.CAR, "NY");
	@Test
	void testArrivalTime() {
		// Makes sure that the time we recorded is in the past compared to the current
		assertNotEquals(System.currentTimeMillis(), spaceTruck.getTimeA());
	}
	@Test
	void testInsertion() {
		// Insert a vehicle into the spot then see what we get
		spaceTruck.vehicleInsertion(v1);
		assertEquals(spaceTruck.getVehicleParked(), v1);
		
	}
	@Test
	void testDeletion() {
		spaceTruck.vehicleInsertion(v1);
		assertNotNull(spaceTruck.getVehicleParked());
		spaceTruck.vehicleDeletion();
		assertNull(spaceTruck.getVehicleParked());
	}
	@Test
	void testToString() {
		// Test first without vehicle occupying
		String s = "This parking spot is available for " + spaceTruck.getSpaceType().toString();
		assertEquals(s, spaceTruck.toString());
		// Now with a vehicle inserted
		spaceTruck.vehicleInsertion(v1);
		s = "This parking spot is occupied by a " + spaceTruck.getVehicleParked().getVTypeS() + 
				" with the license plate " + spaceTruck.getVehicleParked().getLicensePlate() +
				" in a " + spaceTruck.getSpaceType().toString() + " parking space"+ " beginning at "
				+ spaceTruck.getTimeParked();
		assertEquals(s, spaceTruck.toString());
	}

}
