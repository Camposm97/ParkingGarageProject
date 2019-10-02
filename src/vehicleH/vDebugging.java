package vehicleH;

import pLData.*;

public class vDebugging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle t1 = new Vehicle("123-NULL", VehicleType.TRUCK);
		System.out.println(t1.getLicensePlate());
		System.out.println(t1.toString());
		Space s = new Space(VehicleType.TRUCK);
		System.out.println(s.toString());
		
		
		ParkingLot test = new ParkingLot(80, 10, 10);
		System.out.println(test.toString());
		
		
	}

}
