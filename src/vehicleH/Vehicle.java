package vehicleH;

public class Vehicle {
	private String licensePlate;
	private VehicleType vType;
	
	public Vehicle(String licensePlate, VehicleType vType) {
		super();
		// We can pass through the 
		// attendent's choice of automobile through a VehicleType
		this.licensePlate = licensePlate;
		this.vType = vType;
	}
	public String getLicensePlate() {
		return this.licensePlate;
	}
	public String getVType() {
		return vType.toString();
	}
	public String toString() {
		String lP = this.getLicensePlate();
		String vT = this.getVType();
		return "This is a " + vT + " with the license plate " + lP;
	}
	
	
	
	

}
