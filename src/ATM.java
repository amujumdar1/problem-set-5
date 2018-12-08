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
import java.security.InvalidParameterException;
import java.util.*;

public class ATM {
	private BankAccount account;
	private Database database;
	private static Scanner in = new Scanner(System.in);
	// input variable
	
	ATM(String filename) throws FileNotFoundException, IOException{
		this.database = new Database(filename);
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
				in.nextLine();
				
				switch(input) {
					case 1:
						System.out.println("Creating new account...");
						this.account = new BankAccount(in, database);
						database.updateAccount(account, null);
						System.out.println("Successfully created a new account.");
						System.out.println("Your Account Number is: " + this.account.getAccountNumber());
						mainMenu();
						break;
					case 2:
						try {
							login();
							mainMenu();
						}
						catch (InvalidParameterException e) {
							System.out.println(e.getMessage());
							System.out.println("Press [ENTER] twice.");
						}
						catch(InputMismatchException e) {
							System.out.println("You didn't enter a valid number. Press [ENTER]");
						}
						finally {
							in.nextLine();
						}
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
	public void mainMenu() throws IOException {
		System.out.println("What do you want to do?");
		int mainInput = 0;
		do {
			System.out.println("[1] Deposit funds\n"
					 + "[2] Withdraw funds\n"
	                 + "[3] Transfer funds\n"
	                 + "[4] View your balance\n"
	                 + "[5] View your personal information\n"
	                 + "[6] Update your personal information\n"
	                 + "[7] Close your account\n"
	                 + "[8] Logout");
			try {
				mainInput = in.nextInt();
				in.nextLine();
				
				switch(mainInput) {
					case 1:
						this.account.deposit(in);
						database.updateAccount(account, null);
						System.out.println("Press [ENTER]");
						break;
					case 2:
						this.account.withdraw(in);
						database.updateAccount(account, null);
						System.out.println("Press [ENTER]");
						break;
					case 3:
						// TODO - create transfer method
						System.out.println("Please enter the recepient's account number.");
						try {
							BankAccount receiver = database.getAccount(in.nextLong());
							in.nextLine();
							this.account.transfer(receiver, in);
							database.updateAccount(this.account, receiver);
							in.nextLine();
						}
						catch (InvalidParameterException e) {
							e.getMessage();
						}
						/*catch (InputMismatchException e) {
							System.out.println("Please enter a valid amount.");
						}*/
						finally {
							in.nextLine();
						}
						System.out.println("Press [ENTER]");
						break;
					case 4:
						this.account.getBalance();
						System.out.println("Your Current Balance: $" + this.account.getBalance());
						System.out.println("Press [ENTER]");
						break;
					case 5:
						System.out.println("Your personal information is listed below.");
						System.out.println("Account Number: " + this.account.getAccountNumber());
						this.account.getUser().showInfo();
						System.out.println("Press [ENTER]");
						break;
					case 6:
						this.account.getUser().updateInfo(in);
						database.updateAccount(account, null);
						break;
					case 7:
						System.out.println("Closing account. Thank you for using this ATM.");
						this.account.close();
						this.account = null;
						database.updateAccount(account, null);
						break;
					case 8:
						System.out.println("Logging out...");
						this.account = null;
						System.out.println("Press [ENTER] three times.");
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
			
		} while (mainInput != 8 || mainInput != 7);
	}
	
	public void login() throws InputMismatchException {
		System.out.println("Please enter your Account Number.");
		this.account = database.getAccount(in.nextLong());
		in.nextLine();
		if (this.account == null) {
			throw new InvalidParameterException("Account does not exist.");
		}
		System.out.println("Please enter your PIN.");
		int pinTest = in.nextInt();
		if (pinTest != account.getUser().getPin()) {
			throw new InvalidParameterException("Incorrect PIN.");
		}
		System.out.println("Successfully logged in.");
	}
}