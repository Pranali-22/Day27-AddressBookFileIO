/**
 * 
 */
package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		if(contactList.isEmpty()) {
			contactList.add(personContact);
		}
		else {
			boolean isDuplicate =false;
			for(int i=0; i < contactList.size(); i++) {
				if(contactList.get(i).firstName.equals(firstName1) && contactList.get(i).lastName.equals(lastName1)) {
					isDuplicate = true;
					break;
				}
			}
			if(isDuplicate == false) {
				contactList.add(personContact);
			}
		}
	}
	
	// Edit person name for the given name
	
	public void editPersonName() {
		int check=0;
		System.out.println("\nEnter current name of person to edit name");
		String currentName = input.nextLine();
		System.out.println("Enter name to update");
		String nameToUpdate = input.nextLine();
		
		for(int i=0; i < contactList.size(); i++) {
			if(contactList.get(i).firstName.equals(currentName)) {
				contactList.get(i).firstName = nameToUpdate;
				check=1;
				System.out.println(check);
				return;
			}
		}
		
		if(check==0) {
			System.out.println("No record found with given name");
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
	
	
	//Delete a contact using name
	public void deleteContact() {
		
		System.out.println("\nEnter name of person to delete contact");
		String name = input.nextLine();
		int found=0;
		for(int i=0; i <contactList.size(); i++) {	
			if(contactList.get(i).firstName.equals(name)) {
				contactList.remove(i);
				found=1;
				return;
			}
		}
		if(found==0) {
			System.out.println("No record found with given name to delete");
		}
	}
	
	//Search for person in city
	Dictionary<String, String> cityPerson = new Hashtable<String, String>(); 
	public void displayPersonInCity(String cityName) {
		for(int i=0; i <contactList.size(); i++) {	
			if(contactList.get(i).city.equalsIgnoreCase(cityName)) {
				cityPerson.put(cityName, contactList.get(i).firstName);				
			}
		}
		System.out.println("Number of contacts with city "+cityName+" : "+cityPerson.size()+"\n"+cityPerson);
	}
	
	
	//Search for person in state
	Dictionary<String, String> statePerson = new Hashtable<String, String>(); 
	public void displayPersonInState(String stateName) {
	
		for(int i=0; i <contactList.size(); i++) {	
			if(contactList.get(i).state.equalsIgnoreCase(stateName)) {
				statePerson.put(stateName, contactList.get(i).firstName);
			}
		}
		System.out.println("Number of contacts with state "+stateName+" : "+statePerson.size()+"\n"+statePerson);
	}
	
	//Sort addressBook by first name
	
	public void sortAddressBookByFirstName() {
		System.out.println("Sorted address book by first name");
		List<Contact> sortedAddressBook =  contactList.stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());
		
		sortedAddressBook.forEach(contact -> contact.displayContact());
	}
	
	//UC12 - Ability to sort the entries in
	// the address book by City,
	// State, or Zip
	public void sortAddressBookByCityOrStateOrZip(String option) {
		List<Contact> sortedAddressBookByCityOrStateOrZip =  contactList.stream().collect(Collectors.toList());
		switch(option) {
			case "city" :
				System.out.println("Display AddressBook in sorted order by city");
				sortedAddressBookByCityOrStateOrZip.sort(Comparator.comparing(Contact::getCity));;
				break;
				
			case "state" :
				System.out.println("Display AddressBook in sorted order by state");
				sortedAddressBookByCityOrStateOrZip.sort(Comparator.comparing(Contact::getState));
				break;
				
			case "zip" :
				System.out.println("Display AddressBook in sorted order by zip");
				sortedAddressBookByCityOrStateOrZip.sort(Comparator.comparing(Contact::getZip));
				break;
		}
			
		sortedAddressBookByCityOrStateOrZip.forEach(contact -> contact.displayContact());
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
	
	//Display data of file
	
	public void printData() {
		try {
			Files.lines(new File("AddressBook-IO.txt").toPath()).forEach(System.out::println);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
