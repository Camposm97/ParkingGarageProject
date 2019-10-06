package model;
/**
 * VehicleType enum to restrict values
 * Possibilities are VehicleType.TRUCK, VehicleType.CAR, VehicleType.MOTORCYCLE
 * @author Matt Guidi
 *
 */
public enum VehicleType {
	TRUCK{
		public String toString(){
			return "Truck";
		}
		
	},
	MOTORCYCLE{
		public String toString(){
			return "Motorcycle";
		}
		
	},
	CAR{
		public String toString(){
			return "Car";
		}
		
	},
}