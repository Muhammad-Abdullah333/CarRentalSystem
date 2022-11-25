package app;

import java.util.ArrayList;

public class User {
	private ArrayList<Vehicle> rented;
	private String username;
	private String password;
	private int charge;
		
	public User(String username, String password) {
		super();
		rented = new ArrayList<Vehicle>();
		this.username = username;
		this.password = password;
	}
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Vehicle> getRented() {
		return rented;
	}
	public void setRented(ArrayList<Vehicle> rented) {
		this.rented = rented;
	}
}
