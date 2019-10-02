package vehicleH;

import pLData.*;

public class vDebugging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle T1 = new Vehicle("123 1111", VehicleType.MOTORCYCLE);
		Vehicle T2 = new Vehicle("123 2222", VehicleType.CAR);
		Vehicle T3 = new Vehicle("123 3333", VehicleType.TRUCK);
		ParkingLot test = new ParkingLot(80, 10, 10);
		System.out.println(test.toString());
		System.out.println(test.spaceFinder(T1.getVType(), false));
		test.spaceInserter(T1, test.spaceFinder(T1.getVType(), false));
		System.out.println(test.toString());
		test.spaceRelease(9);
		System.out.println(test.toString());
		test.spaceInserter(T1, test.spaceFinder(T1.getVType(), true));
		test.spaceInserter(T1, test.spaceFinder(T1.getVType(), false));
		System.out.println(test.toString());
	}

}
