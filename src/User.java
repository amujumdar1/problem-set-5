import java.util.InputMismatchException;
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
	private int birthDate;
	private long Phone;
	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;
	
	public User (int pin, String firstName, String lastName, long Phone, String streetAddress,
			int birthDate, String city, String state, String postalCode) {
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
			System.out.print("First name (first 15 characters - CANNOT CHANGE): ");
			this.firstName = in.nextLine().substring(0, 16);
			System.out.print("Last name (first 15 characters - CANNOT CHANGE): ");
			this.lastName = in.nextLine().substring(0, 21);
			do {
				System.out.println("PIN (####): ");
				try {
					this.pin = in.nextInt();
					if ((int) Math.log10(this.pin) + 1 != 4){
						System.out.println("Invalid argument. Try again.");
					}
				}
				catch (InputMismatchException e){
					System.out.println("Invalid argument. Try again.");
				}
				finally {
					in.nextLine();
				}
				
			} while ((int) (Math.log10(this.pin) + 1) != 4);
			
			do {
				System.out.print("Birth date (YYYYMMDD - CANNOT CHANGE): ");
				try {
					this.birthDate = in.nextInt();
					if ((int) Math.log10(this.Phone) + 1 != 8) {
						System.out.println("Invalid argument. Try again.");
					}
				}
				catch (InputMismatchException e){
					System.out.println("Invalid argument. Try again.");
				}
				finally {
					in.nextLine();
				}
			} while ((int) Math.log10(this.Phone) + 1  != 8);
			
			do {
				System.out.println("Phone Number (##########): ");
				try {
					this.Phone = in.nextLong();
					if ((int) Math.log10(this.Phone) + 1 != 10){
						System.out.println("Invalid argument. Try again.");
					}
				}
				catch (InputMismatchException e){
					System.out.println("Invalid argument. Try again.");
				}
				finally {
					in.nextLine();
				}
				
			} while ((int) (Math.log10(this.Phone) + 1) != 10);
			
			System.out.print("Street address (first 30 characters): ");
			
			this.streetAddress = in.nextLine().substring(0, 31);
			
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
					this.postalCode = in.nextLine();
					if (this.postalCode.length() != 5){
						System.out.println("Invalid argument. Try again.");
					}
			} while (this.postalCode.length() != 5);
		}
		
				
	
	public int getPin() {
		return pin;
	}
	public void setPin(Scanner in) throws InputMismatchException {
		System.out.println("Please enter your current PIN.");
		int exitCounter = 0;
		int pinTest = 0;
		do {
			pinTest = in.nextInt(); 
			in.nextLine();
			
			if (pinTest == 0 && exitCounter > 0) return;
			// so there is no infinite loop
			
			if (pinTest != this.pin) {
				System.out.println("Incorrect PIN. Please try again. Or press 0 to exit.");
			}
			exitCounter++;
		} while (pinTest != this.pin);
		
		System.out.println("Please enter your new PIN.");
		this.pin = in.nextInt();
		in.nextLine();
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
	
	public int getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(int birthDate) {
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void showInfo() {
		System.out.println("Your personal information is listed below.");
		System.out.println("Name: " + getFirstName() + getLastName());
		System.out.println("Date of Birth: " + getBirthDate());
		
		System.out.println("Phone Number: " + String.valueOf(getPhone()).substring(0, 3) + "-" +
				String.valueOf(getPhone()).substring(3, 6) + 
				"-" + String.valueOf(getPhone()).substring(6, 10));
		
		System.out.println("Address: " + getStreetAddress() + ", "
				+ getCity() + ", " + getState() + " " + getPostalCode());
	}
	
	public void updateInfo(Scanner in) {
		System.out.println("What do you want to update?");
		System.out.println("[1] PIN\n" +
						   "[2] Phone Number\n" + 
				           "[3] Address"+
				           "[4] Nothing; get me out of here.");
		int input = 0;
		do {
			try {
				input = in.nextInt();
				
				switch(input) {
					case 1:
						try {
							setPin(in);
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid input.");
						}
						finally {
							in.nextLine();
						}
						break;
					case 2:
						break;
					case 3:
						System.out.println("Please enter your new street address (first 30 characters).");
						String newStreetAddress = in.nextLine().substring(0, 31);
						
						System.out.println("Please enter your new city.");
						String newCity = in.nextLine().substring(0, 31);
						
						String newState = null, newPostalCode = null;
						do {
							System.out.print("Please enter your new state (two characters; e.g: XY): ");
							newState = in.nextLine();
							if (newState.length() != 2) {
								System.out.println("Invalid argument. Try again.");
							}
						} while (newState.length() != 2);
						do {
							System.out.println("Please enter your new Postal Code (5 characters): ");
								newPostalCode = in.nextLine();
								if (this.postalCode.length() != 5){
									System.out.println("Invalid argument. Try again.");
								}
						} while (newPostalCode.length() != 5);
						setStreetAddress(newStreetAddress);
						setCity(newCity);
						setState(newState);
						setPostalCode(newPostalCode);
						
						break;
					case 4:
						System.out.println("Exiting Update Menu.");
						break;
					default:
						System.out.println("Please enter a valid number.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid number.");
			}
			finally {
				in.nextLine();
			}
		} while (input != 4);
	}
}