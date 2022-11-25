package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);	
	
public static void main(String[] args) {
	System.out.println("Welcome to Vehicle Rental System");
	boolean exit = false;
	boolean signIn;
	while(!exit) {
		System.out.println("Press 1 to Sign In");
		System.out.println("Press 2 to Sign Up");
		try {
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			signIn = false;	
			if(input == 1)
			{
				signIn = Account.signIn();
			}
			else if(input == 2)
			{
				Account.signUp();
			}
			while(signIn)
			{
				System.out.println("\nPress 1 to view all available vehicles");
				System.out.println("Press 2 to rent a vehicle");
				System.out.println("Press 3 to return a vehicle");
				System.out.println("Press 4 to add a new vehicle");
				System.out.println("Press 5 to remove a vehicle");
				System.out.println("Press 6 to make payment");
				System.out.println("Press 7 to exit application");
				int choice = sc.nextInt();
					switch (choice)
					{
					case 1:
						Garage.getVehicles();
						break;
					case 2:
						System.out.println("Enter registration number of vehicle");
						int num = sc.nextInt();
						Garage.rentVehicle(num, Account.getUser());
						break;
					case 3:
						System.out.println("Enter registration number of vehicle");
						int num1 = sc.nextInt();
						Garage.returnVehicle(num1);
						break;
					case 4:
						System.out.println("Enter vehicle name:");
						String name = sc.next();
						System.out.println("Enter vehicle registration number");
						int regNum = sc.nextInt();
						System.out.println("Enter Vehicle Model");
						int model = sc.nextInt();
						Garage.addVehicle(name, regNum, model);
						break;
					case 5:
						System.out.println("Enter registration number of vehicle");
						int reg = sc.nextInt();
						Garage.removeVehicle(reg);
						break;
					case 6:
						System.out.println("Enter amount to be paid");
						int amount = sc.nextInt();
						Payment.makePayment(Account.getUser(), amount);
						break;
					case 7:
						signIn = false;
						exit = true;
						break;
					}// switch
			}// while
			
		}catch(InputMismatchException e)
		{
			System.out.println("Kindly try again");
			signIn = false;
		}
		}// while	
	}// main
}


