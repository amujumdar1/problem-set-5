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
			firstName = (in.nextLine() + "                ").substring(0, 15);
			System.out.print("Last name (first 15 characters - CANNOT CHANGE): ");
			lastName = (in.nextLine() + "                     ").substring(0, 20);
			do {
				System.out.print("PIN (####): ");
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
					birthDate = in.nextInt();
					if ((int) Math.log10(birthDate) + 1 != 8) {
						System.out.println("Invalid argument. Try again.");
					}
				}
				catch (InputMismatchException e){
					System.out.println("Invalid argument. Try again.");
				}
				finally {
					in.nextLine();
				}
			} while ((int) Math.log10(birthDate) + 1  != 8);
			
			setPhone(in);
			
			setStreetAddress(in);
			
			setCity(in);
			
			setState(in);
			
			setPostalCode(in);
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
			
			if (pinTest != pin) {
				System.out.println("Incorrect PIN. Please try again. Or press 0 to exit.");
			}
			exitCounter++;
		} while (pinTest != pin);
		do {
			System.out.println("Please enter your new PIN.");
			this.pin = in.nextInt();
			in.nextLine();
			if ((int) Math.log10(this.pin) + 1 != 4) {
				System.out.println("Please enter a 4 digit PIN.");
			}
		} while ((int) Math.log10(this.pin) + 1 != 4);
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	public void setPhone(Scanner in) {
		do {
			System.out.print("Enter your new Phone Number (##########): ");
			try {
				Phone = in.nextLong();
				if ((int) Math.log10(Phone) + 1 != 10){
					System.out.println("Invalid argument. Try again.");
				}
			}
			catch (InputMismatchException e){
				System.out.println("Invalid argument. Try again.");
			}
			finally {
				in.nextLine();
			}
			
		} while ((int) (Math.log10(Phone) + 1) != 10);
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(Scanner in) {
		System.out.print("Please enter your new street address (first 30 characters):");
		streetAddress = (in.nextLine() + "                              ").substring(0, 30);
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(Scanner in) {
		System.out.print("Please enter your new city (first 30 characters): ");
		
		city= (in.nextLine() + "                                 ").substring(0, 30);
	}
	public String getState() {
		return state;
	}
	public void setState(Scanner in) {
		state = null;
		do {
			System.out.print("Please enter your new state (two characters; e.g: XY): ");
			state = in.nextLine();
			if (state.length() != 2) {
				System.out.println("Invalid argument. Try again.");
			}
		} while (state.length() != 2);
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Scanner in) {
		do {
			System.out.print("Please enter your new Postal Code (5 characters): ");
				postalCode = in.nextLine();
				if (this.postalCode.length() != 5){
					System.out.println("Invalid argument. Try again.");
				}
		} while (postalCode.length() != 5);
	}
	
	public void showInfo() {
		System.out.println("Name: " + getFirstName().replaceFirst("\\s++$", "") + " " + getLastName().replaceFirst("\\s++$", ""));
		
		System.out.println("Date of Birth: " + getBirthDate());
		
		System.out.println("Phone Number: " + getPhone());
		
		System.out.println("Address: " + getStreetAddress().replaceFirst("\\s++$", "") + ", "
				+ getCity().replaceFirst("\\s++$", "") + ", " + getState().replaceFirst("\\s++$", "")
				+ " " + getPostalCode());
	}
	
	public void updateInfo(Scanner in) {
		System.out.println("What do you want to update?");
		int updateInput = 0;
		do {
			System.out.println("[1] PIN\n" +
					   "[2] Phone Number\n" + 
			           "[3] Address\n"+
			           "[4] Nothing; get me out of here.");
			try {
				updateInput = in.nextInt();
				in.nextLine();
				
				switch(updateInput) {
					case 1:
						try {
							setPin(in);
							System.out.println("Successfully updated PIN. Your new"
									+ " PIN is now " + getPin() + ".");

							System.out.println("Press [ENTER] twice.");
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid input.");
						}
						finally {
							in.nextLine();
						}
						break;
					case 2:
						setPhone(in);
						System.out.println("Successfully updated your phone number. Your "
								+ "new phone number is now " + getPhone() + ".");
						System.out.println("Press [ENTER]");
						break;
					case 3:
						setStreetAddress(in);
						setCity(in);
						setState(in);
						setPostalCode(in);
						
						System.out.println("Your new address is " + getStreetAddress().replaceFirst("\\s++$", "") + ", "
								+ getCity().replaceFirst("\\s++$", "") + ", " + getState().replaceFirst("\\s++$", "")
								+ " " + getPostalCode() + ".");
						System.out.println("Press [ENTER]");
						break;
					case 4:
						System.out.println("Exiting Update Menu. Press [ENTER] twice");
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
		} while (updateInput != 4);
	}
}