import java.io.*;

/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */

public class Database {
	
	private File file;
	BufferedReader br;

	
	public Database(File file, BufferedReader br) {
		this.file = file;
		this.br = br;
	}
	
	public User setAccount() {
		int pin;
		String firstName;
		String lastName;
		String birthDate;
		long Phone;
		String streetAddress;
		String city;
		String state;
		int postalCode;
		
		try (br = new BufferedReader(new FileReader(file))) {
		String line;
		
		while ((line = br.readLine()) != null) {
			
		}
		catch (FileNotFoundException ex) {
			
		}
		catch (IOException ex) {
			
		}
		
	}
	}
	/*try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line;
		
		while ((line = br.readLine()) != null) {
			
		}
	}*/
}