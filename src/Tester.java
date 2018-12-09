import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class has only one responsibility: start the ATM program!
 */

public class Tester {
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		try {
			ATM atm = new ATM("accounts-db.txt");
			atm.primaryMenu();	
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error: File not Found. Please find correct file and restart program.");
		} catch (IOException e) {
			System.out.println("I/O Error. Please restart program.");
		}
		// both are possible errors
		
		/*
		 * Rather than hard coding one or more BankAccount objects, you'll need to read them in
		 * from our very primitive database (i.e., a flat-file). After making changes, of course,
		 * you'll need to update the database accordingly.
		 */
	}

}
