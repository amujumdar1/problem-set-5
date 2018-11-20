/**
 * Just like last time, the BankAccount class is primarily responsible
 * for depositing and withdrawing money. In the enhanced version, there
 * will be the added requirement of transfering funds between accounts.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

public class BankAccount {
	private long accountNumber;
	User account;
	double balance;
	
	public BankAccount( long accountNumber, User account, double balance) {
		this.accountNumber = accountNumber;
		this.account = account;
		this.balance = balance;
	}
	
	public void deposit (double amount) {
		if (amount < 1) {
			System.out.println("Invalid amount!");
			return;
		}
		balance += amount;
	}
	
	public void withdraw (double amount) {
		if (amount > balance || amount < 1) {
			System.out.println("Invalid amount!");
			return;		
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