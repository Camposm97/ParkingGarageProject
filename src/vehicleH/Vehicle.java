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
		String vT = "";
		switch(this.vType) {
		case TRUCK: 
			vT = "Truck";
			break;
		case MOTORCYCLE: 
			vT = "Motorcycle";
			break;
		case CAR:
			vT = "Car";
			break;
		}
		return vT;
	}
	public String toString() {
		String lP = this.getLicensePlate();
		String vT = this.getVType();
		return "This is a " + vT + " with the license plate " + lP;
	}
	
	
	
	

}
