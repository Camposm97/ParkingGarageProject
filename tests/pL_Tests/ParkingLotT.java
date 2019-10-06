package pL_Tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import model.*;

class ParkingLotT {
	public ParkingLot tD = new ParkingLot(80, 10, 10);
	public Vehicle tV = new Vehicle("123-3443", VehicleType.MOTORCYCLE, "NY");
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
	@Test
	void testSpaceRelease() {
		ParkingLot t = new ParkingLot(0, 0, 1);
		// Try to delete something out of index to test if the conditional catches it
		assertNull(t.spaceRelease(100));
		// Then we see if we can delete it now that it's the right index
		tD.spaceInserter(tV, 0);
		assertNotNull(tD.spaceRelease(0));
		// See if it's been deleted
		assertNull(tD.getParkingLotArray().get(0).getVehicleParked());
	}
	@Test
	void checkToStringResults() {
		assertNotNull(tD.toString());
		//Tested to make sure it's not null and actually printing correct values
		//System.out.println(tD.toString());
	}
	@Test
	void testVehicleFinder() {
		tD.spaceInserter(tV, 32);
		// We'll insert it into slot 32 and see if it returns that value to us 
		//System.out.println(tV.getLicensePlate().equals(tD.getParkingLotArray().get(32).getVehicleParked().getLicensePlate()));
		assertEquals(32, tD.vehicleFinder(tV.getLicensePlate(), tV.getVehicleState()));
	}
	

}
