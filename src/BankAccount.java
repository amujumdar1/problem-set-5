/**
 * Just like last time, the BankAccount class is primarily responsible
 * for depositing and withdrawing money. In the enhanced version, there
 * will be the added requirement of transfering funds between accounts.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
	private long accountNumber;
	private long tempAccountNumber;
	private User account;
	Database database;
	private char accountStatus = 'Y';
	double balance;
	
	public BankAccount(Database database) {
		tempAccountNumber = database.getMaxAccountNumber() + 1;
	}
	
	public BankAccount(String text){
		// parses the entire line and adds arguments from it
			try {
				int position = 0;
				
				accountNumber = Long.parseLong(text.substring(position, position += 9));
				
				int pin = Integer.parseInt(text.substring(position, position += 4));
				
				balance = Integer.parseInt(text.substring(position, position += 15));
				
				String lastName = text.substring(position, position += 20);
				position += 2;
				
				String firstName = text.substring(position, position += 10);
				
				int birthDate = Integer.parseInt(text.substring(position, position += 8));
				
				long Phone = Long.parseLong(text.substring(position, position += 10));
				
				String streetAddress = text.substring(position, position += 30);
				
				String city = text.substring(position, position += 30);
				
				String state = text.substring(position, position += 2);
				
				String postalCode = text.substring(position, position += 5);
				
				this.setAccountStatus(text.charAt(position));
				
				this.account = new User (pin, firstName, lastName, Phone, streetAddress, birthDate, city, state, postalCode);
			}
			catch (NumberFormatException e) {
				System.out.println("Error reading data. Data types are invalid.");
				// this will never happen but good JUST in case the preloaded file had errors.
			}
			
	}
	public BankAccount(Scanner in) {
	// this is to create a new account, combining the new account number
		this.account = new User(in);
		this.accountNumber = tempAccountNumber++;
	}
	
	public void deposit (Scanner in) {
		// the reason there is no do while statement is to avoid an infinite loop
		System.out.println("How much do you want to deposit?");
		double amount = 0;
		try {
			amount = in.nextDouble();
			if (amount <= 0) {
				System.out.println("Please enter a positive amount.");
				return;
			}
			else if (Double.toString(balance + amount).length() > 15) {
				System.out.println("Deposited amount exceeds bounds.");
				return;
			}
			this.balance += amount;
			System.out.printf("You deposited $%.2f.\n"
					+ "Your new balance is: $%.2f.\n\n", amount, getBalance());
		}
		catch (InputMismatchException e){
			System.out.println("Please enter a valid amount. (No $ signs)");
		}
		finally {
			in.nextLine();
		}
		
	}
	
	public void withdraw (Scanner in) {
		// no do-while due to same reason as above 
	
		System.out.println("How much do you want to withdraw?");
		double amount = 0;
		try {
			amount = in.nextDouble();
			if (amount > balance) {
				System.out.println("Withdaw amount exceeds balance.");	
				return;
			}
			else if (amount <= 0) {
				System.out.println("Please enter a positive amount.");
				return;
			}
			balance -= amount;
			System.out.printf("You withdrew $%.2f.\n"
					+ "Your new balance is $%.2f\n\n", amount, getBalance());
		}
		catch (InputMismatchException e){
			System.out.println("Please enter a valid amount. (No $ signs)");
		}
		finally {
			in.nextLine();
		}
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public User getUser() {
		return account;
	}
	
	public void setUser(User account) {
		this.account = account;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void close() {
		this.setAccountStatus('N');
	}
	
	public void transfer(BankAccount receiver, Scanner in) throws InputMismatchException{
		in.nextLine();
		double amount = 0;
		if (receiver == null) {
			throw new InvalidParameterException("Receiving account does not exist.");
		}
		System.out.println("How much money would you like to transfer?");
		amount = in.nextDouble();
		in.nextLine();
		if (amount > this.balance) {
			throw new InvalidParameterException("Amount exceeds current balance.");
		}
		else if (amount <= 0) {
			throw new InvalidParameterException("Please enter a positive amount.");
		}
		this.balance -= amount;
		receiver.balance += amount;
		System.out.printf("You successfully transferred $%.2f.\n"
				+ "Your new balance is $%.2f\n\n", amount, getBalance());
	}
	public String formatString() {
		String first = String.format("%-9s", this.accountNumber);
		String second = String.format("%-4d", account.getPin());
		String third = String.format("%-15f",this.balance);
		String fourth = String.format("%-20s", account.getLastName());
		String fifth = String.format("%-15s", account.getFirstName());
		String sixth = String.format("%-8s", account.getBirthDate());
		String seventh = String.format("%-10d", account.getPhone());
		String eighth = String.format("%-30s", account.getStreetAddress());
		String ninth = String.format("%-30s", account.getCity());
		String tenth = String.format("%-2s", account.getState());
		String eleventh = String.format("%-5s", account.getPostalCode());
		String twelveth = "Y";
		return (first + second + third + fourth + fifth + sixth + seventh + eighth + ninth
				+ tenth + eleventh + twelveth);
	}

	public char getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(char accountStatus) {
		this.accountStatus = accountStatus;
	}
	
}