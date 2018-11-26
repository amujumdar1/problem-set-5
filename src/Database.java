import java.io.*;

/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */

public class Database {
	
	private File file;

	public Database(File file) {
		this.file = file;
	}
	
	public BankAccount retrieveAccount(long accountNumber, int pin) throws IOException {
		BankAccount account = null;
		
		 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			 String line;
			 
			 while ((line = br.readLine()) != null) {
				 
				 if (line.substring(0, 13).equals(accountNumber + "" + pin)) {
					 // parse all values one by one
					 // use parsed values to build and return BankAccount object
					 
//					account = new BankAccount(
//						parsed values
//					);
				 }
			 }
		
		 }
		 
		 return account;
	}
	/*try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line;
		
		while ((line = br.readLine()) != null) {
			
		}
	}*/
}