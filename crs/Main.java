package crs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static CarRentalSystem crs = new CarRentalSystem();
	static Scanner sc = new Scanner(System.in);
	static Account acc = null;
	
public static void main(String[] args) {
	while(acc == null)
	system();
}

private static void system() {
	
	System.out.println("Welcome to Car Rental System");
	int value =0;
	while(value == 0 || acc == null) {
		value = AccountManagement();
		switch(value) {
		case 1:
			acc = crs.signIn();
			break;
		case 2:
			crs.signUp();
			break;
		case 0:
			System.out.println("Try Again");
			break;
		}
	}
	int display = 0;
	System.out.println("Welcome "+acc.getUsername());
	if(!acc.isAdmin()) {
		while(display!=6 && acc!=null) {
			display =0 ;
			while(display == 0) {
				display = genralMenu();
			}
			switch(display) {
			case 1:
				crs.displayAllAvailableCars();
				break;
			case 2:
				crs.rentCar(acc);
				break;
			case 3:
				crs.returnCar(acc);
				break;
			case 4:
				System.out.println(acc.getRentedCars());
				break;
			case 5:
				System.out.println("Good Bye "+acc.getUsername()+" !!!");
				acc = null;
				break;
			case 6:
				break;
			}	
		}
		
	}
	else {
		while(display!=5 && acc!=null) {
			display =0 ;
		while(display == 0) {
		display = adminMenu();
		}
		switch(display) {
		case 1:
			crs.displayAllAvailableCars();
			break;
		case 2:
			crs.addCar();
			break;
		case 3:
			crs.removeCar();
			break;
		case 4:
			System.out.println("Good Bye "+acc.getUsername()+" !!!");
			acc = null;
			break;
		case 5:
			break;
		}
		}
		
	}
}
private static int AccountManagement() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Press 1 to Sign In");
	System.out.println("Press 2 to Sign Up");
	int choice = 0;
	try {
	while(choice!=1 && choice !=2) {
		choice = sc.nextInt();
	}
	return choice;
	}catch(InputMismatchException e){
		System.out.println("Kindly only enter numbers");
		return 0;
	}
}

private static int genralMenu() {
	int input = 0;
	try {
	while(input!=1 && input!=2 && input!=3 && input!=4 && input!=5 && input!=6){
	System.out.println("Press 1 to view all available cars");
	System.out.println("Press 2 to rent a car");
	System.out.println("Press 3 to return a car");
	System.out.println("Press 4 to view all rented cars");
	System.out.println("Press 5 to Log out");
	System.out.println("Press 6 to exit");
	input = sc.nextInt();
	}
	return input;
	}
	catch(InputMismatchException e) {
		System.out.println("Kindly enter from given options");
	}
	return 0;
}

private static int adminMenu() {
	int input = 0;
	try {
	while(input!=1 && input!=2 && input!=3 && input!=4 && input!=5){
	System.out.println("Press 1 to view all available cars");
	System.out.println("Press 2 to add a new car");
	System.out.println("Press 3 to remove a car");
	System.out.println("Press 4 to Log out");
	System.out.println("Press 5 to exit");
	input = sc.nextInt();
	}
	return input;
	}
	catch(InputMismatchException e) {
		System.out.println("Kindly enter from given options");
	}
	return 0;
}

}
