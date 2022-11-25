package app;

public class Payment {
	public static void makePayment(User u,int value)
	{
		int payment  = u.getCharge();
		payment-=value;
		u.setCharge(payment);
		System.out.println("A charge of "+value+" has been payed by "+u.getUsername());
		System.out.println("Remaining charge = "+u.getCharge());
	}
	
	public static void imposeFine(User u) {
		int payment = u.getCharge();
		payment += 500;
		u.setCharge(payment);
		System.out.println("Fine Imposed");
	}
	
}
