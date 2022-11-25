package app;

import java.time.LocalDate;


public class Vehicle {
	private String name;
	private int registrationNumber;
	private int Model;
	private boolean available;
	private LocalDate rentDate;
	private LocalDate returnDate;
	
	public Vehicle(String name, int registrationNumber, int model) {
		super();
		this.name = name;
		this.registrationNumber = registrationNumber;
		Model = model;
		this.available = true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getModel() {
		return Model;
	}
	public void setModel(int model) {
		Model = model;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public boolean rentVehicle(User u) {
		if(this.isAvailable())
		{
			u.getRented().add(this);
			u.setCharge(500);
			System.out.println("Vehicle "+this.getName()+" is now rented by "+u.getUsername());
			this.available = false;
			rentDate = LocalDate.now();
			returnDate = LocalDate.now().plusDays(7);
			return true;
		}
			System.out.println("Vehicle not available, try another one");
			return false;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	
}
