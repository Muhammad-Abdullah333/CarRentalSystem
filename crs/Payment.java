package crs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Payment {
public void makePayment(Account a) {
	System.out.println("Your account is currently charged with "+a.getCharges());
	System.out.println("Do you wish to make a payment?");
	int input =0;
	Scanner sc = new Scanner(System.in);
	try {
		while(input!=1 && input!=2) {
		System.out.println("Press 1 for Yes");
		System.out.println("Press 2 for No");
		input = sc.nextInt();
		}
	if(input == 1) {
		System.out.println("Enter the amount you want to pay");
		int amount  = sc.nextInt();
		int charge = a.getCharges();
		charge-=amount;
		a.setCharges(charge);
		System.out.println("Your new account charges are "+a.getCharges());
		System.out.println("Thank You! Have a Nice Day");
	}
	}catch(InputMismatchException e) {
		System.out.println("Kindly enter from the given options");
	}
}
}
