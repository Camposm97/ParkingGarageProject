package pLData;

import vehicleH.Vehicle;
import vehicleH.VehicleType;

public class ParkingLot implements ParkingSpaceManager{
	
	private Space [] parkingLotArray;
	
	public ParkingLot(int nCarS, int nTruckS, int nMotorcycleS) {
		int totalSpaces = (nCarS + nTruckS + nMotorcycleS);
		this.parkingLotArray = new Space[totalSpaces];
		for(int i = 0; i < this.parkingLotArray.length; i++) {
			if((nMotorcycleS > 0) && ((i % 10 == 9) || (nCarS == 0))) {
				this.parkingLotArray[i] = new Space(VehicleType.MOTORCYCLE);
				nMotorcycleS--;
			}
			else if((nTruckS > 0) && ((i % 10 == 8) || (nMotorcycleS == 0))) {
				this.parkingLotArray[i] = new Space(VehicleType.TRUCK);
				nTruckS--;
			}
			else if((nCarS > 0)) {
				this.parkingLotArray[i] = new Space(VehicleType.CAR);
				nCarS--;
			}
			
		}
		
	}


	public int spaceFinder(VehicleType vt, boolean skipType) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public Space spaceInserter(Vehicle v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vehicle spaceRelease(int spaceID) {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
		String output = "";
		for(int i = 0; i < parkingLotArray.length; i++) {
			System.out.println("Test" + i);
			output += "Index " + i + " is a type " + parkingLotArray[i].getSpaceType() + '\n';
		}
		return output;
	}

}
