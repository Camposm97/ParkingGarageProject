package vehicle_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Vehicle;
import model.VehicleType;

class VehicleTest {

	@Test
	void typeTest1() {
		Vehicle v = new Vehicle("123-4567", VehicleType.CAR, "NY");
		String s = v.getVTypeS();
		assertEquals(s, "Car");
	}
	@Test
	void typeTest2() {
		Vehicle v = new Vehicle("321-4332", VehicleType.MOTORCYCLE, "NY");
		assertEquals(v.getVType(), VehicleType.MOTORCYCLE);
		
	}
	@Test
	void licensePlateT() {
		Vehicle v = new Vehicle("321-4332", VehicleType.MOTORCYCLE, "NY");
		assertEquals(v.getLicensePlate(), "321-4332");
	}
	void checkState() {
		
	}

}
