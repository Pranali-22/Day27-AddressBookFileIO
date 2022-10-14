/**
 * 
 */
package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dell
 * UC13-Ability to Read or Write the Address Book with
 * Persons Contact into a
 * File using File IO
 */

public class AddressBook {
	
	public static String ADDRESS_BOOK_FILE_NAME = "AddressBook-IO.txt";
	
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	Scanner input = new Scanner(System.in);
	
	String firstName1,lastName1, address1, city1, state1, zip1, phoneNo1, email1;
		
	//add contact to addressbook
	
	public void addToAddressBook() {
		System.out.println("Enter first name, last name, address, city, state, zip, phone number, email ID sequentially");
		firstName1 = input.nextLine();
		lastName1 = input.nextLine();
		address1 = input.nextLine();
		city1 = input.nextLine();
		state1 = input.nextLine();
		zip1 = input.nextLine();
		phoneNo1 = input.nextLine();
		email1 = input.nextLine();
		
		Contact personContact =  new Contact(firstName1, lastName1, address1, city1, state1, zip1, phoneNo1, email1);
		contactList.add(personContact);
	}
	
	
	public void writeData(List<Contact> contactList) {
		StringBuffer empBuffer = new StringBuffer();
		contactList.forEach(address -> {
			String addressBookString = address.toString().concat("\n");
			empBuffer.append(addressBookString);
		});
		
		try {
			Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME), empBuffer.toString().getBytes());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Display contact details
	
	public void displayAddressBook() {
		System.out.println("Displaying all contacts from address book");
		for(int i=0; i < contactList.size(); i++) {
			contactList.get(i).displayContact();
			System.out.println("---------------------");
		}
	}
	
	
}
