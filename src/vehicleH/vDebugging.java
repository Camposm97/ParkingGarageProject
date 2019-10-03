package vehicleH;

import pLData.*;
import register.*;

public class vDebugging {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Vehicle T1 = new Vehicle("123 1111", VehicleType.MOTORCYCLE);
		Vehicle T2 = new Vehicle("123 2222", VehicleType.CAR);
		Vehicle T3 = new Vehicle("123 3333", VehicleType.TRUCK);
		ParkingLot test = new ParkingLot(80, 10, 10);
		System.out.println(test.toString());
		System.out.println(test.spaceFinder(T1.getVType(), true));
		test.spaceInserter(T1, test.spaceFinder(T1.getVType(), true));
		Thread.sleep(30000);
		Ticket ticketT1 = new Ticket(test.spaceRelease(0), 0);
		System.out.println(ticketT1.toString());
	}

}
