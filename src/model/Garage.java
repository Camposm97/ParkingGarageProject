package model;


public class Garage {
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
