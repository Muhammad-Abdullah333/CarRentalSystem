package crs;

import java.time.LocalDate;

public class Fine {
public void check(Car c, Account a) {
	if(c.getReturnDate().isBefore(LocalDate.now())) {
		a.setCharges(c.getRentalCharge()+100);
		System.out.println("You have returned the car after its due date hence a fine of 100 has been charged to your accout");
	return;
	}
}
}
