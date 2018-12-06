/**
 * This class has only one responsibility: start the ATM program!
 */

public class Tester {
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) throws NumberFormatException {
		try {
			printWeirdString();
		}
		catch (NumberFormatException e){
			
			System.out.println("Invalid!");
		}
		
		/*
		 * Rather than hard coding one or more BankAccount objects, you'll need to read them in
		 * from our very primitive database (i.e., a flat-file). After making changes, of course,
		 * you'll need to update the database accordingly.
		 */
	}


	public static void printWeirdString() throws NumberFormatException {
		String x = "a";
		
		char toChar = toChar(x);
		
		System.out.println(toChar);
	}


	private static char toChar(String x) {
		// TODO Auto-generated method stub
		return 0;
	}
}
