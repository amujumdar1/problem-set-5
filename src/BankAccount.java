/**
 * Just like last time, the BankAccount class is primarily responsible
 * for depositing and withdrawing money. In the enhanced version, there
 * will be the added requirement of transfering funds between accounts.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */
import java.security.*;
import java.util.Scanner;

public class BankAccount {
	private long accountNumber;
	User account;
	Database database;
	char accountStatus;
	double balance;
	
	public BankAccount(Database database) {
		this.accountNumber = database.getMaxAccountNumber() + 100;
	}
	
	public BankAccount(String text){
			int position = 0;
			
			accountNumber = Long.parseLong(text.substring(position, position += 9));
			
			int pin = Integer.parseInt(text.substring(position, position += 4));
			
			balance = Integer.parseInt(text.substring(position, position += 15));
			
			String lastName = text.substring(position, position += 20);
			position += 2;
			
			String firstName = text.substring(position, position += 10);
			
			String birthDate = text.substring(position, position += 8);
			
			long Phone = Long.parseLong(text.substring(position, position += 10));
			
			String streetAddress = text.substring(position, position += 30);
			
			String city = text.substring(position, position += 30);
			
			String state = text.substring(position, position += 2);
			
			int postalCode = Integer.parseInt(text.substring(position, position += 5));
			
			this.account = new User (pin, firstName, lastName, Phone, streetAddress, birthDate, city, state, postalCode);
	}
	public BankAccount(Scanner in) {
		this.account = new User(in);
	}
	
	public void deposit (double amount) {
		if (amount < 0) {
			throw new InvalidParameterException("Deposit amount is too low.");
		}
		balance += amount;
	}
	
	public void withdraw (double amount) {
		if (amount > balance || amount < 1) {
			throw new InvalidParameterException("Invalid amount!");	
		}
		balance -= amount;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}