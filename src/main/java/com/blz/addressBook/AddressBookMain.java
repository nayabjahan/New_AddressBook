package com.blz.addressBook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    //initialising final CONSTANTS for Switch case.
    public static final int ADD = 1;
    public static final int EDIT_CONTACTS = 2;
    public static final int DELETE_CONTACTS =3;
    public static final int SHOW_CONTACTS = 4;
    public static final int EXIT =5;

    //creating objects using HashMap for storing data in dictionary
    static HashMap<String, AddressBook> addressBookHashMap = new HashMap<>();
    public static void addNewAddressBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the address book name");
        String addressbookname = scanner.next();
        if (addressBookHashMap.containsKey(addressbookname)){
            System.out.println("Address book is already exist");
        }else {
            AddressBook addressBook = new AddressBook();
            addressBookHashMap.put(addressbookname,addressBook);

        }
    }
    public static void main(String[] args) {
        System.out.println("welcome to Address Book ");
        AddressBook addressBook = new AddressBook();

        int choice;
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Kindly Enter choice \n 1. Add new Contact  \n 2.Edit Contacts +" +
                                       "\n 3.Delete Contact \n 4.Show Contacts \n 5.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case ADD:
                    addressBook.addContacts();
                    break;
                case EDIT_CONTACTS:
                    addressBook.editContact();
                    break;
                case DELETE_CONTACTS:
                    addressBook.deleteContact();
                    break;
                case SHOW_CONTACTS:
                    addressBook.showContacts();
                    break;
                case EXIT:
                    addressBook.showContacts();
                    System.exit(4);
                    break;
                default:
                    System.out.println("enter correct choice");
            }
        }
    }
}



