package crs;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarRentalSystem {
	ArrayList<Account> Accounts;
	ArrayList<Car> Cars;
	Fine fine;
	public CarRentalSystem() {
		Accounts = new ArrayList<Account>();
		Cars = new ArrayList<Car>();
		fine = new Fine();
	}
	
	public void signUp()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String uname = sc.next();
		for(Account a: Accounts)
		{
			if(a.getUsername().equals(uname))
			{
				System.out.println("Account with "+uname+" already exists");
				return;
			}
		}
		System.out.println("Enter password");
		String pass = sc.next();
		Account acc = new Account(uname,pass);
		boolean admin = AuthAdmin();
		acc.setAdmin(admin);
		Accounts.add(acc);
		System.out.println("New Account with username "+uname+" successfully added to Car Rental System");
	}
	
	private boolean AuthAdmin() {
		Scanner sc = new Scanner(System.in);
		int choice =0;
		try {
			
		while(choice!=1 && choice!=2)
		{
			System.out.println("Are you signing up as Admin");
			System.out.println("Press 1 for Yes");
			System.out.println("Press 2 for No");
			choice = sc.nextInt();
		}
	
		if(choice == 1) {
			return true;
		}
		return false;
		
		}catch(InputMismatchException e) {
			System.out.println("Kindly enter only 1 or 2");
			System.out.println("Your account is now being registered as a member");
			return false;
		}
	}
	
	public Account signIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String uname = sc.next();
		Account account = null;
		for(Account a: Accounts)
		{
			if(a.getUsername().equals(uname))
			{
				System.out.println("Enter password for "+ uname);
				String pass = sc.next();
				if(a.getPassword().equals(pass))
				{
					account = a;
					return account;
				}
				else {
					System.out.println("Incorrect password");
					return null;
				}
			}
		}
		System.out.println("Account with username "+uname+" does not exists");
		return null;
	}
	public void addCar() {
		
		displayAllAvailableCars();
		System.out.println("Enter registration number of car");
		try {
			Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		for(Car c: Cars)
		{
			if(c.getId() == id)
			{
				System.out.println("Unable to add new car");
				System.out.println("A car with registration number "+id+" already exists");
				return;
			}
		}
		System.out.println("Enter car's company");
		String make = sc.next();
		System.out.println("Enter Car's model");
		int model = sc.nextInt();
		System.out.println("Enter Car's name");
		String name = sc.next();
		System.out.println("Enter Car's rental charge");
		int charge = sc.nextInt();
		Car c = new Car(id, charge, model, make, name);
		Cars.add(c);
		System.out.println("A new car with registration number "+c.getId()+" has been added");
		}catch(InputMismatchException e) {
			System.out.println("You have entered a non Integer in an Integer field");
		}
	}
	
	public void removeCar() {
		System.out.println("Enter registration number of car");
		try {
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		for(Car c: Cars)
		{
			if(c.getId() == id)
			{
				Cars.remove(c);
				System.out.println("Car with id "+ id+" has been removed");
				return;
			}
		}
		System.out.println("A car with id "+id+" not found");
		}catch(InputMismatchException e) {
			System.out.println("Registraion number is an Integer field");
		}
	}
	
	public void rentCar(Account a)
	{
		System.out.println("Following is the list of all available cars\n");
		displayAllAvailableCars();
		System.out.println("Enter registraion number of car");
		try {
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			for(Car c: Cars)
			{
				if(c.getId() == id)
				{
					if(c.isAvailable()) {
						System.out.println(c.toString());
						System.out.println("You have to pay "+c.getRentalCharge()+" to have the car "+c.getName()+"\n");
						int choice = 0;
						while(choice !=1 && choice !=2)
						{
							
							System.out.println("Do you wish to charge your account with "+c.getRentalCharge()+" rental charge");
							System.out.println("Press 1 for Yes");
							System.out.println("Press 2 for No");
							choice = sc.nextInt();
						}
						if(choice == 1) {
							a.setCharges(c.getRentalCharge()+a.getCharges());
							a.getRentedCars().add(c);
							c.setRentDate();
							c.setAvailable(false);
						}
						else {
							break;
						}
					}
					else {
						System.out.println("Car with registration number "+c.getId()+" is currently not avaiable \n");
						break;
					}				
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("This fild is an Integer field and only accepts integer \n");
		}
	}
	public void returnCar(Account a) {
		System.out.println("Enter registraion number of car \n");
		try {
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			Car c  = null;
			for(Car car: Cars) {
				if(car.getId() == id && !car.isAvailable()) {
					c = car;
					}
			}
			if(c == null) {
				System.out.println("Either the car is already present in garage or not registered to Car Rental System");
			}
			else {
				a.getRentedCars().remove(c);
				c.setAvailable(true);
				System.out.println(c.getName()+" has been returned to Car Rental System \n");
				fine.check(c,a);
			}
		}catch(InputMismatchException e) {
			System.out.println("This field only accepts numbers kindly try again \n");
		}
	}
	public void displayAllAvailableCars() {
		for(Car c:Cars)
		{
			if(c.isAvailable())
			System.out.println(c.toString());
		}
		System.out.println();
	}
}
