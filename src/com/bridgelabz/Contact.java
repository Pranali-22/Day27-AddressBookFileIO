/**
 * 
 */
package com.bridgelabz;

/**
 * @author Dell
 * UC13-Ability to Read or Write the Address Book with
 * Persons Contact into a
 * File using File IO
 */
public class Contact {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zip;
	String phoneNumber;
	String emailId;	

	//Parameterized Contact constructor
	public Contact(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	//Method for displaying data
	public void displayContact() {
		System.out.println("First Name : "+firstName);
		System.out.println("Last Name : "+lastName);
		System.out.println("Address : "+address);
		System.out.println("City : "+city);
		System.out.println("State : "+state);
		System.out.println("Zip : "+zip);
		System.out.println("Phone Number : "+phoneNumber);
		System.out.println("Email Id : "+emailId);
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
	}
	
	
}
