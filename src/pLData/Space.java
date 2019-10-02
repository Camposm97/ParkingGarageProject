package pLData;

import java.util.Date;

import vehicleH.*;

public class Space {
	// Currently takes the time as need be
	private static final long TIME_MODIFIER = 1;
	
	
	private VehicleType parkingSpaceType;
	private Vehicle vehicleParked;
	private Date arrivalTime = new Date();
	private Double specialRate;
	public Space(VehicleType vT) {
		parkingSpaceType = vT;
	}
	public void setSpaceType(VehicleType x) {
		this.parkingSpaceType = x;
	}
	public void setSpecialRate(double rateValue) {
		this.specialRate = rateValue;
	}
	public double getSpecialRate() {
		return this.specialRate;
	}
	public VehicleType getSpaceType() {
		return parkingSpaceType;
	}
	public Vehicle getVehicleParked() {
		return vehicleParked;
	}
	public String getTimeParked() {
		return this.arrivalTime.toString();
	}
	public void vehicleInsertion(Vehicle newVehicle) {
		this.vehicleParked = newVehicle;
		this.arrivalTime.setTime((System.currentTimeMillis() * TIME_MODIFIER));
	}
	public void vehicleDeletion() {
		this.arrivalTime = null;
		this.vehicleParked = null;
		this.specialRate = null;
	}
	public String toString() {
		if(vehicleParked == null) {
			return "This parking spot is available for " + this.parkingSpaceType.toString();	
		}else {
			return "This parking spot is occupied by a " + this.vehicleParked.getVTypeS() + 
					" with the license plate " + this.vehicleParked.getLicensePlate() +
					" in a " + this.parkingSpaceType.toString() + " parking space"+ " beginning at "
					+ this.getTimeParked();
		}
	}

	
}
