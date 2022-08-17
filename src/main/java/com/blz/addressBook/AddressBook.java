package com.blz.addressBook;

import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contacts> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addContacts(){
        Contacts contacts = new Contacts();
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
        contacts.setEMail(scanner.nextLine());
        list.add(contacts);
        System.out.println(contacts);
    }
    public void showContacts() {
        for (Contacts contacts : list) {
            System.out.println("Contacts{" +
                    "firstName='" + contacts.getFirstName() + '\'' +
                    ", lastName='" + contacts.getLastName() + '\'' +
                    ", city='" + contacts.getCity() + '\'' +
                    ", state='" + contacts.getState() + '\'' +
                  ", zipCode='" + contacts.getZip() + '\'' +
                   ", phNumber='" + contacts.getPhoneNo()+ '\'' +
                 ", eMail='" + contacts.getEMail() + '\'' +
                   '}');
           }
    }
    public void editContact() {
        System.out.println("Enter the first name");
        String firstName = scanner.next();
        boolean isAvailable = false;

        for (Contacts contacts : list) {
            if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
                isAvailable = true;
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
                contacts.setEMail(scanner.next());
                break;
            }
        }if (!isAvailable) {
            System.out.println("Contact is Not found ");
        }
    }
    public void deleteContact(){
        System.out.println("Enter the first name");
        String firstName = scanner.next();
        boolean isAvailable = false;
        for (Contacts contacts : list) {
            if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
                isAvailable = true;
                System.out.println("Contact Deleted ");
                contacts = null;
            }
        }
        if (!isAvailable) {
            System.out.println("Contact Number Not found ");
        }
    }
}




