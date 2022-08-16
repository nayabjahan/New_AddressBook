package com.blz.addressBook;

import java.util.Scanner;

public class AddressBookMain {

    public static final int ADD = 1;
    public static final int Show_contact = 2;

    public static void main(String[] args) {
        System.out.println("welcome to Address Book ");
        AddressBook addressBook = new AddressBook();

        int choice;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Kindly Enter choice \n 1. Add new Contact \n 2. Show Contact");
            choice = scanner.nextInt();
            switch (choice){
                case ADD:
                    addressBook.addContacts();
                    break;
                case Show_contact:
                    addressBook.showContacts();
                    System.exit(2);
                    break;
            }
        }
    }
}



