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
	
	void createAccount(BankAccount account) throws IOException {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(this.file))){
			// TODO
		}
	}
	
	public BankAccount retrieveAccount(long accountNumber, int pin){
		 try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
			 
			 String line;
			 
			 while ((line = br.readLine()) != null) {
				 
				 if (line.charAt(141) == 'N') return null;
				 
				 if (line.substring(0, 13).equals(accountNumber + "" + pin)) {
					 return new BankAccount(line);
//					);
				 }
			 }
			 return null;
		
		 }
		 catch (IOException e) {
			 System.out.println("Could not read account from file.");
			 return null;
		 }
	}
	/*try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line;
		
		while ((line = br.readLine()) != null) {
			
		}
	}*/
	
	public BankAccount updateAccount() {
		// TODO
		return null;
	}
}