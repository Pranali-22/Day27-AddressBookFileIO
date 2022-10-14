/**
 * 
 */
package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dell
 * UC13-Ability to Read or Write the Address Book with
 * Persons Contact into a
 * File using File IO
 */

public class AddressBookMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		AddressBook addressBook = new AddressBook();
		addressBook.addToAddressBook();
		addressBook.writeData(addressBook.contactList);
		addressBook.displayAddressBook();
	}
}
