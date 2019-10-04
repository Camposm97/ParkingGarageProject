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

}
