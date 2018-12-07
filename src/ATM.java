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
import java.util.*;

public class ATM {
	private BankAccount account;
	private Database database;
	static Scanner in = new Scanner(System.in);
	// input variable
	
	ATM(String filename) throws FileNotFoundException, IOException{
		this.database = new Database(filename);
		new BankAccount(database);
		}
	
	/*public static BankAccount setCredentials(){
		User account = new User(34723283,
				"Johnny", "Appleseed", "2-11-2011", 3457654967, "1776 Raritan Road", "");
		// constructor to set personal information of user
		
		return new BankAccount(1000, 713352114, account);
	}*/
	
	public void primaryMenu() throws IOException {
		
		System.out.println("Welcome to the ATM.");
		// lists the options
		int input = 0;
		do {
			System.out.println("[1] Open an account");
			System.out.println("[2] Login");
			System.out.println("[3] Quit");
			try {
				input = in.nextInt();
				
				switch(input) {
					case 1:
						System.out.println("Creating new account...");
						this.account = new BankAccount(in);
						database.updateAccount(account, null);
						break;
					case 2:
						
						loginMenu();
						break;
					case 3:
						System.out.println("Quitting...");
						break;
					default:
						System.out.println("You didn't enter a valid number. Try again.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("You didn't enter a valid number. Try again.");
			}
			finally {
				in.nextLine();
			}
			
		} while (input != 3);
		
	}
	public void loginMenu() throws IOException {
		System.out.println("What do you want to do?");
		int input = 0;
		do {
			System.out.println("[1] Deposit funds\n"
					 + "[2] Withdraw funds\n"
	                 + "[3] Transfer funds\n"
	                 + "[4] View your balance\n"
	                 + "[5] View your personal information\n"
	                 + "[6] Update your personal information\n"
	                 + "[7] Close your account"
	                 + "[8] Logout");
			try {
				input = in.nextInt();
				
				switch(input) {
					case 1:
						this.account.deposit(in);
						database.updateAccount(account, null);
						break;
					case 2:
						this.account.withdraw(in);
						database.updateAccount(account, null);
						break;
					case 3:
						break;
					case 4:
						this.account.getBalance();
						System.out.print("Your Current Balance: $" + this.account.getBalance());
						break;
					case 5:
						this.account.getUser().showInfo();
						break;
					case 6:
						this.account.getUser().updateInfo(in);
						database.updateAccount(account, null);
						break;
					case 7:
						System.out.println("Closing account.");
						this.account.close();
						break;
					case 8:
						System.out.println("Logging out...");
						this.account = null;
					default:
						System.out.println("You didn't enter a valid number. Try again.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("You didn't enter a valid number. Try again.");
			}
			finally {
				in.nextLine();
			}
			
		} while (input != 8);
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