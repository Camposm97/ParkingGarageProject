package pLData;

import vehicleH.Vehicle;
import vehicleH.VehicleType;

public class ParkingLot implements ParkingSpaceManager{
	
	private Space [] parkingLotArray;
	
	
	
	private static final double MOTORCYCLE_OVERRIDE = 1.25;
	private static final double CAR_OVERRIDE = 1.50;
	
	
	
	
	
	public ParkingLot(int nCarS, int nTruckS, int nMotorcycleS) {
		int totalSpaces = (nCarS + nTruckS + nMotorcycleS);
		this.parkingLotArray = new Space[totalSpaces];
		/*
		 * 	MATT'S Dynamic Parking Lot Filler
		 *  Rules = for each "row" if there is overflow the filter rule is 8 cars, 1 motorcycle, 1 truck
		 * 	As soon as Cars run out then motorcycles begin to fill. Once motorcycles are done trucks fill the rest.
		 */
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
		// Find the first spot based on vehicle type 
		// May override the type if the boolean is true
		for(int i = 0; i < parkingLotArray.length; i++) {
			if(parkingLotArray[i].getVehicleParked() == null) {
				if((vt == VehicleType.TRUCK) && (parkingLotArray[i].getSpaceType() == VehicleType.TRUCK)) {
					return i;
				}else if(vt == VehicleType.CAR) {
					
					if(skipType == true) {
						if((parkingLotArray[i].getSpaceType() == VehicleType.TRUCK)) {
							return i;
						}
					}if((parkingLotArray[i].getSpaceType() == VehicleType.CAR)) {
							return i;
						}
				}
				else if(vt == VehicleType.MOTORCYCLE){
					if(skipType == true) {
						return i;
					}else {
						if((parkingLotArray[i].getSpaceType() == VehicleType.MOTORCYCLE)){
							return i;
						}
					}
				}
				
			}
		}
		// If we return -1 we're all full! 
		return -1;
	}
	public Vehicle spaceRelease(int spaceID) {
		if((spaceID > parkingLotArray.length-1) || (spaceID < 0) ) 
			return null;
		Vehicle del = this.parkingLotArray[spaceID].getVehicleParked();
		this.parkingLotArray[spaceID].vehicleDeletion();
		return del;
	}
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < parkingLotArray.length; i++) {
			output += "Index " + i + " is a type " + parkingLotArray[i].getSpaceType() + '\n';
			if(parkingLotArray[i].getVehicleParked() != null) {
				output += parkingLotArray[i].toString() + " \n";
			}
		}
		return output;
	}
	public Space spaceInserter(Vehicle v, int spaceID) {
		if((spaceID > parkingLotArray.length-1) || (spaceID < 0) ) 
			return null;
		if(v == null)
			return null;
		//Passes these checks then we can go ahead and insert the space
		//but we need to check for Vehicle type on the space to apply special rates
		if(v.getVType() != parkingLotArray[spaceID].getSpaceType()) {
			//Now that we know we need to add a special rate let's determine which constant
			//We need to set this space to
			if(v.getVType() == VehicleType.MOTORCYCLE) {
				this.parkingLotArray[spaceID].setSpecialRate(MOTORCYCLE_OVERRIDE);
			}else{
				this.parkingLotArray[spaceID].setSpecialRate(CAR_OVERRIDE);
			}
		}
		// Now we can insert this vehicle into its space. 
		// The calculation for proximity is done at checkout since it is used only from index
		this.parkingLotArray[spaceID].vehicleInsertion(v);
		return this.parkingLotArray[spaceID];
	}

}
