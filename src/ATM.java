/**
 * Just like last time, the ATM class is responsible for managing all
 * of the user interaction. This means login procedures, displaying the
 * menu, and responding to menu selections. In the enhanced version, the
 * ATM class will have the added responsibility of interfacing with the
 * Database class to write and read information to and from the database.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

import java.io.*;
import java.util.Scanner;

public class ATM {
	private BankAccount account;
	private Database database;
	static Scanner in = new Scanner(System.in);
	// input variable
	
	public ATM(BankAccount account) {
		this.account = account;
	}
	
	ATM(File file, Database database){
		this.database = database;
	}
	
	/*public static BankAccount setCredentials(){
		User account = new User(34723283,
				"Johnny", "Appleseed", "2-11-2011", 3457654967, "1776 Raritan Road", "");
		// constructor to set personal information of user
		
		return new BankAccount(1000, 713352114, account);
	}*/
	
	private void primaryMenu() {
		
		System.out.println("Welcome to the ATM.");
		System.out.println("Press 1 to open an account.");
		System.out.println("Press 2 to login.");
		System.out.println("Press 3 to quit.");
		// lists the options
		boolean valid = true; 
		do {
			int input = in.nextInt();
			in.nextLine();
			
			switch(input) {
				case 1:
					account = new BankAccount(in);
					valid = true;
					break;
				case 2:
					loginMenu();
					valid = true;
					break;
				case 3:
					System.out.println("Your balance is $" + bank.balance + ".");
					// displays current balance
					valid = true;
					break;
				default:
					System.out.println("You didn't enter a valid number! Try again.");
					valid = false;
			}
		} while (!valid);
		
		System.out.println("Do you want to do anything else? (Y/N)");
		endDecider(in.next().toUpperCase().charAt(0));
	}
	public int loginMenu() {
		System.out.println("Press 1 to deposit funds.");
		System.out.println("Press 2 to withdraw funds.");
		System.out.println("Press 3 to transfer funds.");
		System.out.println("Press 4 to view your balance.");
		System.out.println("Press 5 to view your personal information.");
		System.out.println("Press 6 to update your personal information.");
		System.out.println("Press 7 to close your account.");
		System.out.println("Press 8 to logout.");
		
		return loginMenu();
	}
	
	public int endDecider(char decision) {
		
		switch(decision) {
			case 'Y':
				primaryMenu();
				return 1;
			case 'N':
				return 0;
			default:
				System.out.println("Invalid input!");
		}
		System.out.println("Do you want to do anything else? (Y/N)");
		return endDecider(in.next().toUpperCase().charAt(0));
	}
	
	/*public void deposit(double amount) {
		bank.deposit(amount);
	}
	
	public void withdraw(double amount) {
		bank.withdraw(amount);
	}
	
	public double showBalance() {
		return bank.balance;
	}*/
}