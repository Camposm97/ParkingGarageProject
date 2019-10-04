package vehicle_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vehicleH.Vehicle;
import vehicleH.VehicleType;

class VehicleTest {

	@Test
	void typeTest1() {
		Vehicle v = new Vehicle("123-4567", VehicleType.CAR);
		String s = v.getVTypeS();
		assertEquals(s, "Car");
	}
	@Test
	void typeTest2() {
		Vehicle v = new Vehicle("321-4332", VehicleType.MOTORCYCLE);
		assertEquals(v.getVType(), VehicleType.MOTORCYCLE);
		
	}
	@Test
	void licensePlateT() {
		Vehicle v = new Vehicle("321-4332", VehicleType.MOTORCYCLE);
		assertEquals(v.getLicensePlate(), "321-4332");
	}

}
