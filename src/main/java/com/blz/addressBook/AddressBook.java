package com.blz.addressBook;

import java.util.*;

public class AddressBook extends ArrayList<Contacts> {
    static Dictionary dictCity = new Hashtable<String, ArrayList<Contacts>>();
    static Dictionary dictState = new Hashtable<String, ArrayList<Contacts>>();
    private static final int ADDRESSBOOK = 1;
    private static final int EDIT_ADDRESSBOOK = 2;
    private static final int DISPLAY_ADDRESSBOOK = 3;
    private static final int EXIT = 6;
    private static final int SEARCH_BY_PERSONCITY = 4;
    private static final int SEARCH_BY_PERSONCITY_BY_PERSONSTATE = 5;
    HashMap<String, ArrayList<Contacts>> addressBookMap = new HashMap<String, ArrayList<Contacts>>();
    static ArrayList<Contacts> contactList = new ArrayList<Contacts>();
    Contacts contacts;
    static Scanner scanner = new Scanner(System.in);

    public Contacts addContact() {
        System.out.println("Enter the First Name :");
        String fName = scanner.nextLine();

        System.out.println("Enter the Last Name :");
        String lName = scanner.nextLine();

        System.out.println("Enter the City :");
        String city = scanner.nextLine();

        System.out.println("Enter the State :");
        String state = scanner.nextLine();

        System.out.println("Enter the Phone Number :");
        String phName = scanner.nextLine();

        System.out.println("Enter the Zip Code :");
        String zipCode = scanner.nextLine();

        System.out.println("Enter the E-Mail :");
        String EMail = scanner.nextLine();

        contactList.add(new Contacts(fName, lName, city, state, phName, zipCode, EMail));
        return contacts;
    }

    public void showContacts() {
        for (Contacts contacts : contactList) {
            System.out.println("Contacts{" +
                                       "firstName='" + contacts.getFirstName() + '\'' +
                                       ", lastName='" + contacts.getLastName() + '\'' +
                                       ", city='" + contacts.getCity() + '\'' +
                                       ", state='" + contacts.getState() + '\'' +
                                       ", zipCode='" + contacts.getZipCode() + '\'' +
                                       ", phNumber='" + contacts.getPhNumber() + '\'' +
                                       ", eMail='" + contacts.getEMail() + '\'' +
                                       '}');
        }
        System.out.println(addressBookMap);
       // contactList.stream().sorted(Comparator.comparing(Contacts::getFirstName)).forEach(System.out::println);
    }

    public void editContact() {

        System.out.println("Enter the first name");
        String firstName = scanner.next();
        boolean isAvailable = false;

        for (Contacts contacts : contactList) {
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
                contacts.setZipCode(scanner.next());
                System.out.println("Enter the Phone Number :");
                contacts.setPhNumber(scanner.next());
                System.out.println("Enter the EMail ID :");
                contacts.setEMail(scanner.next());
                break;
            }
        }
        if (!isAvailable) {
            System.out.println("Contact is Not found ");
        }
    }

    public void deleteContact() {
        System.out.println("Enter the first name");
        String firstName = scanner.next();

        boolean isAvailable = false;
        for (Contacts contacts : contactList) {
            if (firstName.equalsIgnoreCase(contacts.getFirstName())) {
                isAvailable = true;
                System.out.println("Contact Deleted ");
                contacts = null;
            }
        }
        if (!isAvailable) {
            System.out.println("Contact Name Not found ");
        }
    }


    public void addNewAddressBook() {
        System.out.println("Enter the Address Book Name  : ");
        String addressBookName = scanner.next();
        if (addressBookMap.containsKey(addressBookName)) {
            System.out.println("Entered AddressBook is Already Available");
            return;
        }
        contactList = new ArrayList<>();
        addressBookMap.put(addressBookName, contactList);
        System.out.println(addressBookName);
    }
//    public void duplicateEntry() {
//        boolean flag = false;
//        Contacts contact = addContact();
//        try {
//            for (Contacts objPerson : contactList) {
//                if (objPerson.getFirstName().equals(contact.getFirstName())) {
//                    //flag = true;
//                    System.out.println(contact);
//                }
//            }
//            if (!flag) {
//                contactList.add(contact);
//            } else {
//                System.out.println("First Name already exist..");
//            }
//        }catch (NullPointerException e){
//            e.printStackTrace();
//        }
//    }

    public void addressBookMenu() {
        System.out.println("Welcome TO Address Book");
        boolean flag = false;
        int choice;
        do {
            String bookName = "";
            ArrayList<Contacts> addressBook = new ArrayList<Contacts>();
            choice = inputInteger("1.Add a New Address Book \n 2.Edit Address Book \n 3. Display Address Book \n 4.search by person city" +
                                          "\n 5.search by person state \n 6.exit");
            switch (choice) {
                case ADDRESSBOOK:
                    addNewAddressBook();
                    break;
                case EDIT_ADDRESSBOOK:
                    if (!addressBookMap.isEmpty()) {
                        bookName = inputString("Enter Address Book Name to Access: ");
                        addressBook = addressBookMap.get(bookName);
                        menu(bookName, addressBook);
                    } else {
                        System.out.println("No Address Books are present");
                    }
                    break;
                case DISPLAY_ADDRESSBOOK:
                    displayBooks();
                    break;
                case SEARCH_BY_PERSONCITY:
                    searchPersonCity();
                    break;
                case SEARCH_BY_PERSONCITY_BY_PERSONSTATE:
                    searchPersonState();
                    break;
                case EXIT:
                    System.out.println("Thanks For Using!");
                    flag = true;
                    break;
            }
        } while (!flag);
    }

    public void menu(String bookName, ArrayList<Contacts> addressBook) {
        System.out.println("Welcome To Address Book Programme");

        boolean flag = false;
        int choice;
        do {
            System.out.println("Kindly Enter choice \n 1. Add new Contact \n 2. Edit Contact details \n 3. Delete" +
                                       "\n 4. Display Contacts \n 5. Exit ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //duplicateEntry();
                    addContact();
                    System.out.println("Contact Added Successfully!!");
                    break;
                case 2:
                    editContact();
                    System.out.println("Contact Edited Successfully!!");
                    break;
                case 3:
                    deleteContact();
                    System.out.println("Contact Deleted Successfully!!");
                    break;
                case 4:
                    showContacts();
                    break;
                case 5:
                    System.out.println("Thanks For Using");
                    flag = true;
                    break;
                default:
                    System.out.println("Please Enter the correct Choice");
            }
        } while (!flag);

    }

    public static String inputString(String message) {
        System.out.println(message);
        return scanner.next().toLowerCase();
    }

    public static int inputInteger(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public void displayBooks() {
        for (Map.Entry<String, ArrayList<Contacts>> books : addressBookMap.entrySet())
                System.out.println("BookName = " + books.getKey() + ", Contacts = " + books.getValue());
    }
    public static void searchPersonCity() {
        System.out.println("Enter City name");
        String city = scanner.next();
        contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
    }

    public static void searchPersonState() {
        System.out.println("Enter State name");
        String state = scanner.next();
        contactList.stream().filter(person -> person.getState().equalsIgnoreCase(state)).forEach(System.out::println);
    }
  }




