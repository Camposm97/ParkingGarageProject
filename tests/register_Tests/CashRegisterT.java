package register_Tests;

import org.junit.jupiter.api.Test;

import model.CashRegister;
import model.UserData;
import model.Vehicle;
import model.VehicleType;
import model.*;

class CashRegisterT {
	public ParkingLot pL = new ParkingLot(1, 1, 1);
	public Vehicle v1 = new Vehicle("123-4567", VehicleType.CAR, "NY");
	public UserData uT = new UserData("a", "dmin","admin", 0);
	public CashRegister cr = new CashRegister(uT);
	@Test
	void testCashRegister() throws InterruptedException {
		pL.spaceInserter(v1, 0);
		Thread.sleep(100);
		cr.closeTicket(pL, v1.getLicensePlate(), v1.getVehicleState());
	}

}
