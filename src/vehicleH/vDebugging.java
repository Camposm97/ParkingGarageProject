package vehicleH;

import pLData.Space;

public class vDebugging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle t1 = new Vehicle("123-NULL", VehicleType.TRUCK);
		System.out.println(t1.getLicensePlate());
		System.out.println(t1.toString());
		Space s = new Space(VehicleType.TRUCK);
		System.out.println(s.toString());
		s.vehicleInsertion(t1);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.toString());
		
	}

}
