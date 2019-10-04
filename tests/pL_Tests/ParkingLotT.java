package pL_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pLData.*;
import vehicleH.VehicleType;

class ParkingLotT {

	@Test
	void carParkingTest() {
		// Test that it can park this car in the one car slot
		ParkingLot t = new ParkingLot(1, 0, 0);
		assertNotNull(t.spaceFinder(VehicleType.CAR, false));
	}
	@Test
	void overRideTest() {
		ParkingLot t = new ParkingLot(0, 0, 1);
		// Ask it to find a spot for a car if we can override and place it in a truck spot
		assertNotNull(t.spaceFinder(VehicleType.CAR, true));
		// If it cannot be found then we return -1
		assertEquals(t.spaceFinder(VehicleType.CAR, false), -1);
	}
	

}
