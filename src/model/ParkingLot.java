package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is the parking lot "bag" that contains the spaces
 * @author Matt Guidi
 *
 */
public class ParkingLot implements ParkingSpaceInterface, Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList <Space>parkingLotArray;
	
	
	/**
	 * @param MOTORCYCLE_OVERRIDE Used for extra charge
	 * @param CAR_OVERRIDE Used for extra charge
	 */
	private static final double MOTORCYCLE_OVERRIDE = 1.25;
	private static final double CAR_OVERRIDE = 1.50;
	
	
	
	/**
	 * Instantiates a Parking Lot 
	 * 
	 * Default setup is that for every 10 spaces <br>
	 * 8 go for cars <br>
	 * 1 go for motorcycles <br>
	 * 1 go for trucks <br>
	 * If the number of mandatory car spaces is satisfied <br>
	 * we fill in the remainder of motorcycles and then trucks <br>
	 * @param nCarS The number of car spaces you'd like in the Parking Lot
	 * @param nTruckS The number of truck spaces you'd like in the Parking Lot
	 * @param nMotorcycleS The number of motorcycle spaces you'd like in the Parking lot
	 * 
	 * 
	 * 
	 */
	public ParkingLot(int nCarS, int nTruckS, int nMotorcycleS) {
		int totalSpaces = (nCarS + nTruckS + nMotorcycleS);
		this.parkingLotArray = new ArrayList<Space>();
		/*
		 * 	MATT'S Dynamic Parking Lot Filler
		 *  Rules = for each "row" if there is overflow the filter rule is 8 cars, 1 motorcycle, 1 truck
		 * 	As soon as Cars run out then motorcycles begin to fill. Once motorcycles are done trucks fill the rest.
		 */
		for(int i = 0; i < totalSpaces; i++) {
			if((nMotorcycleS > 0) && ((i % 10 == 9) || (nCarS == 0))) {
				this.parkingLotArray.add(new Space(VehicleType.MOTORCYCLE));
				nMotorcycleS--;
			}
			else if((nTruckS > 0) && ((i % 10 == 8) || (nMotorcycleS == 0))) {
				this.parkingLotArray.add(new Space(VehicleType.TRUCK));
				nTruckS--;
			}
			else if((nCarS > 0)) {
				this.parkingLotArray.add(new Space(VehicleType.CAR));
				nCarS--;
			}
			
		}
		
	}
	/**
	 * Finds the nearest space available based on the conditions<br>
	 * If the boolean skipType is true VehicleType.CAR can go in a truck space <br>
	 * Similarly, VehicleType.MOTORCYCLE can go into both truck and car spaces as well<br>
	 * Once it finds the nearest spot available it returns the index of it<br>
	 * @param vt - Enter the actual type of this vehicle for correct placement
	 * @param skipType - If true it allows smaller vehicles to park in bigger spaces, for extra of course
	 * @return The index of the best spot available given these conditions. If full return -1
	 *  
	 *  	 
	 */
	public int spaceFinder(VehicleType vt, boolean skipType) {
		// Find the first spot based on vehicle type 
		// May override the type if the boolean is true
		for(int i = 0; i < parkingLotArray.size(); i++) {
			if(parkingLotArray.get(i).getVehicleParked() == null) {
				if((vt == VehicleType.TRUCK) && (parkingLotArray.get(i).getSpaceType() == VehicleType.TRUCK)) {
					return i;
				}else if(vt == VehicleType.CAR) {
					
					if(skipType == true) {
						if((parkingLotArray.get(i).getSpaceType() == VehicleType.TRUCK)) {
							return i;
						}
					}if((parkingLotArray.get(i).getSpaceType() == VehicleType.CAR)) {
							return i;
						}
				}
				else if(vt == VehicleType.MOTORCYCLE){
					if(skipType == true) {
						return i;
					}else {
						if((parkingLotArray.get(i).getSpaceType() == VehicleType.MOTORCYCLE)){
							return i;
						}
					}
				}
				
			}
		}
		// If we return -1 we're all full! 
		return -1;
	}
	/**
	 * This method finds which parking spot # a vehicle is in
	 * @param licensePlate A string of the license plate provided
	 * @param s The state for the vehicle's license plate for further verification
	 * @return Returns the index where this vehicle can be located. <br> Returns -1 if not found
	 * 
	 */
	public int vehicleFinder(String licensePlate, State s) {
		int spaceID = -1;
		for(int i = 0; i < this.parkingLotArray.size(); i++){
			if(this.parkingLotArray.get(i).getVehicleParked() != null) {
				System.out.println("Checking index " + i + " it has a license plate: " + this.parkingLotArray.get(i).getVehicleParked().getLicensePlate());
				if(this.parkingLotArray.get(i).getVehicleParked().getLicensePlate().compareTo(licensePlate) >= 0) {
					if(this.parkingLotArray.get(i).getVehicleParked().getVehicleState().compareTo(s) >= 0) {
					spaceID = i;
					System.out.println("hello");
					return spaceID;
					}
				}
				
			}
		}
		return spaceID;
	}
	/**
	 * Releases a vehicle from the space resetting it if given a valid space number
	 * @param spaceID This is the index of the space we're trying to empty
	 * @return Returns a clone of the space to be used for ticket printing. Null if incomplete
	 */
	public Space spaceRelease(int spaceID) {
		if((spaceID > parkingLotArray.size()-1) || (spaceID < 0) ) 
			return null;
		Space copyOfOld = new Space(this.parkingLotArray.get(spaceID));
		this.parkingLotArray.get(spaceID).vehicleDeletion();
		return copyOfOld;
	}
	/**
	 * @return Returns a string of the parking lot array's data including vehicle info if not null
	 */
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < parkingLotArray.size(); i++) {
			output += "Index " + i + " is a type " + parkingLotArray.get(i).getSpaceType() + '\n';
			if(parkingLotArray.get(i).getVehicleParked() != null) {
				output += parkingLotArray.get(i).toString() + " \n";
			}
		}
		return output;
	}
	/**
	 * Space inserter inserts a vehicle into the parking lot array
	 * @param v The vehicle to be inserted into this space
	 * @param spaceID The index in the parking lot where the vehicle is inserted
	 * @return Returns the space object that has been modified. Null is returned if Vehicle or ID is wrong
	 */
	public Space spaceInserter(Vehicle v, int spaceID) {
		if((spaceID > parkingLotArray.size()-1) || (spaceID < 0) ) 
			return null;
		if(v == null)
			return null;
		//Passes these checks then we can go ahead and insert the space
		//but we need to check for Vehicle type on the space to apply special rates
		if(v.getVType() != parkingLotArray.get(spaceID).getSpaceType()) {
			//Now that we know we need to add a special rate let's determine which constant
			//We need to set this space to
			if(v.getVType() == VehicleType.MOTORCYCLE) {
				this.parkingLotArray.get(spaceID).setSpecialRate(MOTORCYCLE_OVERRIDE);
			}else{
				this.parkingLotArray.get(spaceID).setSpecialRate(CAR_OVERRIDE);
			}
		}
		// Now we can insert this vehicle into its space. 
		// The calculation for proximity is done at checkout since it is used only from index
		this.parkingLotArray.get(spaceID).vehicleInsertion(v);
		return this.parkingLotArray.get(spaceID);
	}
	/**
	 * 
	 * @return Returns the parking lot's space ArrayList for other classes
	 */
	public ArrayList<Space> getParkingLotArray() {
		return parkingLotArray;
	}
	

}
