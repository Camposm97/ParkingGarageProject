package pLData;

import vehicleH.*;
public interface ParkingSpaceInterface {
	
	
	int spaceFinder(VehicleType vt, boolean skipType);
	Space spaceInserter(Vehicle v, int spaceID);
	Space spaceRelease(int spaceID);
	
	

}
