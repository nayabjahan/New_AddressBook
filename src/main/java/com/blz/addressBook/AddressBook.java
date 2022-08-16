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



}




