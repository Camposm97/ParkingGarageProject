package vehicleH;
/**
 * The Vehicle class provides the makeup of info needed for a vehicle 
 * @author Matt Guidi
 *
 */
public class Vehicle {
	private String licensePlate;
	private VehicleType vType;
	private State vehicleState;
	/**
	 * Standard layout for receiving a new vehicle
	 * @param licensePlate The license plate of the car
	 * @param vType The VehicleType of this car
	 * @param stateAbbr The state this car has a LP in
	 */
	public Vehicle(String licensePlate, VehicleType vType, String stateAbbr) {
		super();
		// We can pass through the 
		// attendent's choice of automobile through a VehicleType
		this.licensePlate = licensePlate;
		this.vType = vType;
		this.vehicleState = State.valueOfAbbreviation(stateAbbr);
	}
	/**
	 * @return Returns the license plate of this vehicle
	 */
	public String getLicensePlate() {
		return this.licensePlate;
	}
	/**
	 * 
	 * @return Returns the vehicle type as an ENUM of VehicleType
	 */
	public VehicleType getVType() {
		return vType;
	}
	/**
	 * 
	 * @return Returns the state of the vehicleadmi
	 */
	public State getVehicleState() {
		return vehicleState;
	}
	/**
	 * 
	 * @return Returns the String of the ENUM of VehicleType
	 */
	public String getVTypeS() {
		return vType.toString();
	}
	public String toString() {
		String lP = this.getLicensePlate();
		String vT = this.getVTypeS();
		return "This is a " + vT + " with the license plate " + lP;
	}
	
	
	
	

}
