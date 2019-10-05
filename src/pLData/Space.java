package pLData;

import java.util.Date;

import vehicleH.*;
/**
 * Space's whole purpose is store a lot of the data on the car as well as the values 
 * that have been selected at the time of check in. Most of this gets reset with each car removal.
 * @author Matt Guidi
 * 
 */
public class Space {
	/**
	 * This time modifier helps us modify the "real-time" used to calculate our close time. <br>
	 * It helps make cost approximation and testing a lot easier <br>
	 * Use 3,600,000 for 1 millisecond to equal one hour <br>
	 * Use 60,000 for 1 millisecond to equal one minute <br>
	 * Use 1,000 for 1 millisecond to equal one second <br>
	 * Use 1 for normal time. <br>
	 */
	public static final long TIME_MODIFIER = 60000;
	
	
	private VehicleType parkingSpaceType;
	private Vehicle vehicleParked;
	private Date arrivalTime = new Date();
	private Double specialRate = 1.0;
	/**
	 * Creates a new parking space inteded for VehicleType vT
	 * @param vT The type of vehicle you want parking in this space
	 */
	public Space(VehicleType vT) {
		parkingSpaceType = vT;
	}
	/**
	 * Used to duplicate a space primarily for vehicle deletion and ticket printing
	 * @param c The old space you'd like to make a copy of
	 */
	public Space(Space c) {
		this.arrivalTime = c.arrivalTime;
		this.parkingSpaceType = c.parkingSpaceType;
		this.specialRate = c.specialRate;
		this.vehicleParked = c.vehicleParked;
	}
	/**
	 * sets the space type to parameter x
	 * @param x the type you intend to change this space to
	 */
	public void setSpaceType(VehicleType x) {
		this.parkingSpaceType = x;
	}
	/**
	 * Sets the rateValue for this space (useful for a vehicle type override charge)
	 * @param rateValue the rate at which this person is going to be charged at time of checkout
	 */
	public void setSpecialRate(double rateValue) {
		this.specialRate = rateValue;
	}
	/**
	 * 
	 * @return Returns the special rate. If 1 then the rate is standard
	 */
	public double getSpecialRate() {
		return this.specialRate;
	}
	/**
	 * 
	 * @return Returns Vehicle type of this space
	 */
	public VehicleType getSpaceType() {
		return parkingSpaceType;
	}
	/**
	 * 
	 * @return Returns the vehicle in this space. Null if no occupying vehicle
	 */
	public Vehicle getVehicleParked() {
		return vehicleParked;
	}
	/**
	 * 
	 * @return Returns the string version of the local time the space was occupied by its current vehicle
	 */
	public String getTimeParked() {
		return this.arrivalTime.toString();
	}
	/**
	 * 
	 * @return Returns the (long) version of the local time the space was occupied by its current vehicle
	 */
	public long getTimeA() {
		return arrivalTime.getTime();
	}
	/**
	 * 
	 * @return Gives the time modifier 
	 * @see #TIME_MODIFIER
	 */
	public long getTimeModifier() {
		return TIME_MODIFIER;
	}
	/**
	 * Insertion method utilized by Parking Lot, instantiates arrivalTime as well
	 * @param newVehicle Inserts this vehicle into the space
	 * @see ParkingLot#spaceInserter(Vehicle, int)
	 */
	public void vehicleInsertion(Vehicle newVehicle) {
		this.vehicleParked = newVehicle;
		this.arrivalTime = new Date(((System.currentTimeMillis() * TIME_MODIFIER)));
	}
	/**
	 * Deletes out the temporary data of the space, thus releasing the vehicle's info
	 * @see ParkingLot#spaceRelease(int)
	 */
	public void vehicleDeletion() {
		this.arrivalTime = null;
		this.vehicleParked = null;
		this.specialRate = 1.0;
	}
	/**
	 * Outputs the info of the current space.
	 * If there is a vehicle it also outputs the vehicles info.
	 */
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
