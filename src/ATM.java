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

import java.util.Scanner;

public class ATM {
	private static BankAccount bank;
	private Database database;
	static Scanner in = new Scanner(System.in);
	// input variable
	
	public ATM(BankAccount bank) {
		this.bank = bank;
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM(bank);
		System.out.println("Welcome to the ATM!");
		
		boolean rightAccount = false;
		do {
			System.out.print("Account Number: ");
			
			long accountInput = in.nextLong();
			in.nextLine();
			
			if (accountInput != 713352114) {
				System.out.println("Invalid Account Number!");
			}
			else rightAccount = true;
			
		} while (!rightAccount);
		
		boolean rightPin = false; 
		do {
			System.out.print("PIN: ");
			
			int pinInput = in.nextInt();
			in.nextLine();
			
			if (pinInput != 2428) {
				System.out.println("Invalid PIN!");
			}
			else rightPin = true;
			
		} while (!rightPin);
		atm.showMenu();
		
	}
	
	/*public static BankAccount setCredentials(){
		User account = new User(34723283,
				"Johnny", "Appleseed", "2-11-2011", 3457654967, "1776 Raritan Road", "");
		// constructor to set personal information of user
		
		return new BankAccount(1000, 713352114, account);
	}*/
	
	private void showMenu() {
		
		
		System.out.println("Press 1 to withdraw money.");
		System.out.println("Press 2 to deposit money.");
		System.out.println("Press 3 to show your current balance");
		// lists the options
		boolean valid = true; 
		do {
			int input = in.nextInt();
			in.nextLine();
			
			switch(input) {
				case 1:
					System.out.println("How much do you want to withdraw?");
					System.out.print("Amount: ");
					
					bank.withdraw(in.nextDouble());
					// withdraws however much the user wants 
					
					in.nextLine();
					valid = true;
					break;
				case 2:
					System.out.println("How much do you want to deposit?");
					System.out.print("Amount: ");
					
					bank.deposit(in.nextDouble());
					// deposits however much the user wants
					
					in.nextLine();
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
	
	public int endDecider(char decision) {
		
		switch(decision) {
			case 'Y':
				showMenu();
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