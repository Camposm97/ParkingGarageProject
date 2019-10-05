package vehicleH;

public class Vehicle {
	private String licensePlate;
	private VehicleType vType;
	private State vehicleState;
	
	public Vehicle(String licensePlate, VehicleType vType, String stateAbbr) {
		super();
		// We can pass through the 
		// attendent's choice of automobile through a VehicleType
		this.licensePlate = licensePlate;
		this.vType = vType;
		this.vehicleState = State.valueOfAbbreviation(stateAbbr);
	}
	public String getLicensePlate() {
		return this.licensePlate;
	}
	public VehicleType getVType() {
		return vType;
	}
	public State getVehicleState() {
		return vehicleState;
	}
	public String getVTypeS() {
		return vType.toString();
	}
	public String toString() {
		String lP = this.getLicensePlate();
		String vT = this.getVTypeS();
		return "This is a " + vT + " with the license plate " + lP;
	}
	
	
	
	

}
