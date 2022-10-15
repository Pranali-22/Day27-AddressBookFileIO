/**
 * 
 */
package com.bridgelabz;

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
		//addressBook.writeData(addressBook.contactList);
		//addressBook.printData();
		
		int choice =1;
		//Store contacts to addressBook1
		
		while (choice!=0){         
            switch (choice){
                case 0:
                    return;                   
                case 1:
                    addressBook.addToAddressBook();
                    break;
                case 2:
                    addressBook.editPersonName();
                    break;   
                case 3:
                	addressBook.displayAddressBook();
                	break;
                case 4:
                	addressBook.deleteContact();
                	break;
                case 5:
                	System.out.println("Enter state to search for persons");
                	String state=input.next();
                	addressBook.displayPersonInState(state);
                	break;
                case 6:
                	System.out.println("Enter city to search for persons");
                	String city=input.next();
                	addressBook.displayPersonInCity(city);
                	break;
                case 7:
                	addressBook.sortAddressBookByFirstName();
                	break;
                case 8:
                	System.out.println("Enter choice to sort Address Book upon");
            		String option = input.next();
                	addressBook.sortAddressBookByCityOrStateOrZip(option);
                	break;
                case 9:
                	addressBook.writeData(addressBook.contactList);
                	break;
                case 10:
                	addressBook.printData();
                	break;
            }
            
            System.out.println("Enter\n0- exit \n1- Add more contact \n2- edit contact \n3- display\n4- delete contact\n5- Search for person within state\n6- Search for person within city \n7- Sort using first name \n8- sort using city/state/zip \n9- Write data to file IO \n10- Read data from file");
            choice = input.nextInt();
        }
		
		
	}
}
