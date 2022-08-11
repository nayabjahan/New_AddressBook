package com.blz.addressBook;

import java.util.Scanner;

public class AddressBook {
    Contacts contacts = new Contacts();
    public void addContacts(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First name");
        contacts.setFirstName(scanner.nextLine());
        System.out.println("enter the last name");
        contacts.setLastName(scanner.nextLine());
        System.out.println("enter the city");
        contacts.setCity(scanner.nextLine());
        System.out.println("enter the state");
        contacts.setState(scanner.nextLine());
        System.out.println("enter the zip");
        contacts.setZip(scanner.nextLine());
        System.out.println("enter the phone number");
        contacts.setPhoneNo(scanner.nextLine());
        System.out.println("enter the eMail");
        contacts.seteMail(scanner.nextLine());
    }
    public void editContact(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first name");
            String firstName = scanner.next();

            boolean isFound = false;
            if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
                System.out.println("Enter the New First Name");
                contacts.setFirstName(scanner.next());
                System.out.println("Enter the Last Name :");
                contacts.setLastName(scanner.next());
                System.out.println("Enter the City :");
                contacts.setCity(scanner.next());
                System.out.println("Enter the State :");
                contacts.setState(scanner.next());
                System.out.println("Enter the Zip Code :");
                contacts.setZip(scanner.next());
                System.out.println("Enter the Phone Number :");
                contacts.setPhoneNo(scanner.next());
                System.out.println("Enter the EMail ID :");
                contacts.seteMail(scanner.next());
            }else if (!isFound) {
                System.out.println("Contact is Not found ");
            }
            System.out.println(contacts);
        }
        public void deleteContact(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first name");
            String firstName = scanner.next();

            boolean isFound = false;
            if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
                isFound = true;
                System.out.println("Contact Deleted ");
                contacts = null;
            }
            if (!isFound) {
                System.out.println("Contact  Not found ");
            }
        }
}


