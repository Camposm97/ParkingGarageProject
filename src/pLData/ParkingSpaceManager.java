package pLData;

import vehicleH.*;
public interface ParkingSpaceManager {
	
	
	int spaceFinder(VehicleType vt, boolean skipType);
	Space spaceInserter(Vehicle v);
	Vehicle spaceRelease(int spaceID);
	
	

}
