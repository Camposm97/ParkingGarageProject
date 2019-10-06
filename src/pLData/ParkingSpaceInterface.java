package pLData;

import vehicleH.*;
/**
 * This is the interface that ParkingLot implements
 * Honestly don't think this was necessary, but oh well
 * @author Matt Guidi
 *
 */
public interface ParkingSpaceInterface {
	
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
	int spaceFinder(VehicleType vt, boolean skipType);
	/**
	 * Space inserter inserts a vehicle into the parking lot array
	 * @param v The vehicle to be inserted into this space
	 * @param spaceID The index in the parking lot where the vehicle is inserted
	 * @return Returns the space object that has been modified. Null is returned if Vehicle or ID is wrong
	 */
	Space spaceInserter(Vehicle v, int spaceID);
	/**
	 * Releases a vehicle from the space resetting it if given a valid space number
	 * @param spaceID This is the index of the space we're trying to empty
	 * @return Returns a clone of the space to be used for ticket printing. Null if incomplete
	 */
	Space spaceRelease(int spaceID);
	/**
	 * This method finds which parking spot # a vehicle is in
	 * @param licensePlate A string of the license plate provided
	 * @param s The state for the vehicle's license plate for further verification
	 * @return Returns the index where this vehicle can be located. <br> Returns -1 if not found
	 * 
	 */
	int vehicleFinder(String licensePlate, State s);
	
	

}
