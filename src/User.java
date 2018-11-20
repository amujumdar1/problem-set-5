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
	private int SSN;
	private String Name;
	private String Phone;
	private String Address;
	
	public User (int SSN, String Name, String Phone, String Address) {
		this.SSN = SSN;
		this.Name = Name;
		this.Phone = Phone;
		this.Address = Address;
	}
	
	public int getSSN() {
		return SSN;
	}
	
	public void setSSN(int SSN) {
		this.SSN = SSN; 
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getPhone() {
		return Phone;
	}
	
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
}