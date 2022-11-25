package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	static ArrayList<User>users = new ArrayList<User>();
	static User user;
	static Scanner sc = new Scanner(System.in);
	
	public static boolean signIn() {

		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
		for(User u: users)
		{
			if(u.getUsername().equals(username))
			{
				System.out.println("Enter password");
				if(u.getPassword().equals(password))
				{
					user = u;
					return true;
				}
			}
			
		}
		
		return false;
	}
	public static boolean signUp() {
		
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
		for(User u: users)
		{
			if(u.getUsername().equals(username))
			{
				System.out.println("Username already exists");
				
				return false;
			}
		}
		User u = new User(username, password);
		users.add(u);
		System.out.println("New user successfully added");
		user = u;
		return true;
		
	}
	public static User getUser() {
		return user;
	}
}
