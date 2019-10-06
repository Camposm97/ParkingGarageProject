package vehicle_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.VehicleType;

class VehicleTypeTest {

	@Test
	void testType() {
		String c = "Car";
		assertEquals(c, VehicleType.CAR.toString());
	}
	
	@Test
	void testType2() {
		assertEquals(VehicleType.CAR, VehicleType.MOTORCYCLE);
	}

}
