package model;

import java.io.Serializable;

public class Garage implements Serializable {
	private static final long serialVersionUID = 1L;
	private UserDataManager users;
	private ParkingLot parkingLot;
	
	public Garage(UserDataManager users, ParkingLot parkingLot) {
		this.users = users;
		this.parkingLot = parkingLot;
	}

	public UserDataManager getUsers() {
		return users;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}
}
