package model;

import java.io.Serializable;
/**
 * The Garage class takes in the parking lot and user data manager objects. <br>
 * This helps to tie together both "bags" of user objects and space objects as they will be used together
 * @author Michael Campos, Chris Demonte, Matt Guidi
 *
 */
public class Garage implements Serializable {
	private static final long serialVersionUID = 1L;
	private UserDataManager users;
	private ParkingLot parkingLot;
	/**
	 * To create the garage we need a link to the users list and spaces list
	 * @param users Provides UserDataManager list (users)
	 * @param parkingLot Provides ParkingLot list (spaces)
	 * @see UserDataManager
	 * @see ParkingLot
	 */
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
