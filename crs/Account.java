package crs;

import java.util.ArrayList;

public class Account {
	private boolean admin;
	private String username;
	private String password;
	private int charges;
	private ArrayList<Car> rentedCars;
	private Payment pay;
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.admin = false;
		this.charges = 0;
		rentedCars = new ArrayList<Car>();
		pay = new Payment();
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public ArrayList<Car> getRentedCars() {
		return rentedCars;
	}
	public void setRentedCars(ArrayList<Car> rentedCars) {
		this.rentedCars = rentedCars;
	}
	public void makePayment() {
		pay.makePayment(this);
	}
}
