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
        System.out.println(contacts);

    }
}
