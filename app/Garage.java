package app;

import java.time.LocalDate;
import java.util.ArrayList;

public class Garage {
	static ArrayList<Vehicle>vehicles = new ArrayList<Vehicle>();
	static ArrayList<Vehicle>rentedVehicles = new ArrayList<Vehicle>();
	
	public static void addVehicle(String name, int regNum, int Model)
	{
		boolean exists = false;
		Vehicle v = new Vehicle(name,regNum,Model);
		for(Vehicle ve: vehicles)
		{
			if(ve.getRegistrationNumber() == v.getRegistrationNumber())
			{
				exists = true;
			}
		}
		if(!exists)
		{
			vehicles.add(v);
		}
		else
		{
			System.out.println("Vehicle already present");
		}
	}
	public static void removeVehicle(int regNum)
	{
		Vehicle v = getVehicle(regNum);
		if(v != null)
		{
			vehicles.remove(v);
			System.out.println("Vehicle got removed");
			return;
		}
		System.out.println("No such vehicle in garage");	
	}
	public static void rentVehicle(int regNum, User u)
	{
		Vehicle v = getVehicle(regNum);
		if(v !=null) {
			if(v.rentVehicle(u))
			{
				rentedVehicles.add(v);
				return;
			}
		}
		System.out.println("No such vehicle");
		
	}
	public static void returnVehicle(int regNum) {
		Vehicle v = getRentedVehicle(regNum);
		if(v!=null) {
		v.setAvailable(true);
		rentedVehicles.remove(v);
		Account.getUser().getRented().remove(v);
		if(v.getReturnDate().isBefore(LocalDate.now()))
		{
			Payment.imposeFine(Account.getUser());
		}
		return;
		}
		System.out.println("No such vehicle rented by garage");
	}
	public static void getVehicles() {
		for(Vehicle c: vehicles)
		{
			System.out.println(c.getName()+" "+c.getRegistrationNumber()+" " +c.getModel());
		}
	}
	
	private static Vehicle getVehicle(int regNum)
	{
		for(Vehicle v: vehicles) {
			if(v.getRegistrationNumber() == regNum)
			{
				return v;
			}
		}
		return null;
	}
	private static Vehicle getRentedVehicle(int regNum)
	{
		for(Vehicle v: rentedVehicles) {
			if(v.getRegistrationNumber() == regNum)
			{
				return v;
			}
		}
		return null;
	}
}
