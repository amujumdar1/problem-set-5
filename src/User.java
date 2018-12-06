import java.util.Scanner;
import java.lang.Math;
/**
 * Just like last time, the User class is responsible for retrieving
 * (i.e., getting), and updating (i.e., setting) user information.
 * This time, though, you'll need to add the ability to update user
 * information and display that information in a formatted manner.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

public class User {
	private int pin;
	private String firstName;
	private String lastName;
	private String birthDate;
	private long Phone;
	private String streetAddress;
	private String city;
	private String state;
	private int postalCode;
	
	public User (int pin, String firstName, String lastName, long Phone, String streetAddress,
			String birthDate, String city, String state, int postalCode) {
		this.pin = pin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.Phone = Phone;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}
	
	User (Scanner in) {
		System.out.println("Please enter your information below.");
			System.out.print("First name (first 15 characters): ");
			this.firstName = in.nextLine().substring(0, 16);
			System.out.print("Last name (first 15 characters): ");
			this.lastName = in.nextLine().substring(0, 21);
			do {
				System.out.println("PIN (####): ");
				try {
					this.pin = in.nextInt();
					in.nextLine();
				}
				catch (NumberFormatException e){
					System.out.println("Invalid argument. Try again.");
				}
				
				if ((int) Math.log10(this.pin) + 1 != 4){
					System.out.println("Invalid argument. Try again.");
				}
			} while ((int) (Math.log10(this.pin) + 1) != 4);
			
			do {
				System.out.print("Birth date (YYYYMMDD): ");
				this.birthDate = in.nextLine();
				if (this.birthDate.length() != 8) {
					System.out.println("Invalid argument. Try again.");
				}
			} while (this.birthDate.length() != 8);
			do {
				System.out.println("Phone Number (##########): ");
				try {
					this.Phone = in.nextLong();
					in.nextLine();
				}
				catch (NumberFormatException e){
					System.out.println("Invalid argument. Try again.");
				}
				
				if ((int) Math.log10(this.Phone) + 1 != 10){
					System.out.println("Invalid argument. Try again.");
				}
			} while ((int) (Math.log10(this.Phone) + 1) != 10);
			System.out.print("Street address (first 30 characters): ");
			
			this.streetAddress = this.firstName = in.nextLine().substring(0, 31);
			
			System.out.print("City (first 30 characters): ");
			
			this.city= in.nextLine().substring(0, 31);
			
			do {
				System.out.print("State (two characters; e.g: XY): ");
				this.state = in.nextLine();
				if (this.state.length() != 2) {
					System.out.println("Invalid argument. Try again.");
				}
			} while (this.state.length() != 2);
			do {
				System.out.println("Postal Code (#####): ");
				try {
					this.postalCode = in.nextInt();
					in.nextLine();
				}
				catch (NumberFormatException e){
					System.out.println("Invalid argument. Try again.");
				}
				
				if ((int) Math.log10(this.postalCode) + 1 != 5){
					System.out.println("Invalid argument. Try again.");
				}
			} while ((int) (Math.log10(this.postalCode) + 1) != 5);
		}
		
	
	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin; 
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String lastName) {
		this.firstName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public long getPhone() {
		return Phone;
	}
	
	public void setPhone(long Phone) {
		this.Phone = Phone;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
}