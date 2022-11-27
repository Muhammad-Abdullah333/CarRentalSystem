package crs;

import java.time.LocalDate;

public class Car {
	private int id;
	private int rentalCharge;
	private int model;
	private String Company;
	private String name;
	private boolean isAvailable;
	private LocalDate rentDate;
	private LocalDate returnDate;
	
	public Car(int id, int rentalCharge, int model, String company, String name) {
		super();
		this.id = id;
		this.rentalCharge = rentalCharge;
		this.model = model;
		Company = company;
		this.name = name;
		this.isAvailable = true;
	}
	public int getId() {
		return id;
	}
	public int getRentalCharge() {
		return rentalCharge;
	}
	public int getModel() {
		return model;
	}
	public String getCompany() {
		return Company;
	}
	public String getName() {
		return name;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public void setRentDate() {
		this.rentDate = LocalDate.now();
		this.returnDate = LocalDate.now().plusDays(7);
		System.out.println("You have to retun the car till "+returnDate+" or you will get fined according to the rental charge of car");
	}
	public LocalDate getRentDate() {
		return this.rentDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	@Override
	public String toString() {
		return "Car [ Registration Number=" + id +", model=" + model + ", Company=" + Company
				+ ", name=" + name+" ]";
	}
	
}
