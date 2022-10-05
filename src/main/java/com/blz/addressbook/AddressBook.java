package com.blz.addressbook;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class AddressBook {
    List<Contacts> ContactDetails = new ArrayList<>();
        static Scanner input = new Scanner(System.in);
        static HashMap<String, AddressBook> dictAddressBook = new HashMap<>();//
        static Dictionary dictCity = new Hashtable<String, ArrayList<Contacts>>();
        static Dictionary dictState = new Hashtable<String, ArrayList<Contacts>>();


        public Contacts readContactDetail() {
            Contacts personContact = new Contacts();
            System.out.println("Enter Contact Details");
            System.out.println("----------------------");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter First Name: ");
            personContact.setFirst_name(in.next());
            System.out.print("Enter Last Name: ");
            personContact.setLast_name(in.next());
            System.out.print("Enter City: ");
            personContact.setCity(in.next());
            System.out.print("Enter State: ");
            personContact.setState(in.next());
            System.out.print("Enter Zip: ");
            personContact.setZip(in.next());
            System.out.print("Enter Phone number: ");
            personContact.setPhNumber(in.next());
            System.out.print("Enter Email Id: ");
            personContact.setEMail(in.next());
            return personContact;
        }

        public void addContactDetail() {
            boolean flag = false;
            Contacts personDetails = readContactDetail();
            for (Contacts objPerson : ContactDetails) {
                if (objPerson.getFirst_name().equals(personDetails.getFirst_name())) {
                    flag = true;
                }
            }
            if (!flag) {
                ContactDetails.add(personDetails);
                storePersonByCity(personDetails.getCity(), personDetails);//call store person details by city name
                storePersonByState(personDetails.getState(), personDetails);//call store person details by state name
            } else {
                System.out.println("First Name already exist..");
            }
        }

        //store persons detail in dict by city name
        //@SuppressWarnings("unchecked")
        public void storePersonByCity(String cityName, Contacts personObject) {
            while (dictCity.keys().hasMoreElements()) {
                if (dictCity.keys().nextElement().equals(cityName)) {
                    ArrayList<Contacts> personDetailsArray = (ArrayList<Contacts>) dictCity.get(cityName);
                    personDetailsArray.add(personObject);
                    dictCity.put(cityName, personDetailsArray);
                    return;
                } else break;
            }
            ArrayList<Contacts> personDetailsArray = new ArrayList<>();
            personDetailsArray.add(personObject);
            dictCity.put(cityName, personDetailsArray);
        }

        //store persons detail in dict by state name
        @SuppressWarnings("unchecked")
        public void storePersonByState(String stateName, Contacts personObject) {
            while (dictState.keys().hasMoreElements()) {
                if (dictState.keys().nextElement().equals(stateName)) {
                    ArrayList<Contacts> personDetailsArray = (ArrayList<Contacts>) dictState.get(stateName);
                    personDetailsArray.add(personObject);
                    dictState.put(stateName, personDetailsArray);
                    return;
                } else break;
            }
            ArrayList<Contacts> personDetailsArray = new ArrayList<>();
            personDetailsArray.add(personObject);
            dictState.put(stateName, personDetailsArray);
        }

        public void editContactDetail(String firstName) {
            if (ContactDetails.isEmpty()) {
                System.out.println("------NO RECORDS------");
                return;
            }

            boolean flag = false;
            Contacts newPersonContact = null;
            for (Contacts objPerson : ContactDetails) {
                if (objPerson.getFirst_name().equals(firstName)) {
                    newPersonContact = objPerson;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                int choice;
                do {
                    System.out.println("---------------------------");
                    System.out.println("What you want to edit");
                    System.out.println("1. First Name\n2. Last Name\n3. Address\n4. City\n5. State\n6. Zip\n7. Phone Number\n8. Email Id\n0. Cancel\n");
                    System.out.print("Enter choice: ");
                    Scanner in = new Scanner(System.in);
                    choice = in.nextInt();
                    //use switch for edit specific details
                    switch (choice) {
                        case 1:
                            System.out.println("Old: " + newPersonContact.getFirst_name());
                            System.out.print("New: ");
                            String newFirstName = in.next();
                            newPersonContact.setFirst_name(newFirstName);
                            break;

                        case 2:
                            System.out.println("Old: " + newPersonContact.getLast_name());
                            System.out.print("New: ");
                            String newLastName = in.next();
                            newPersonContact.setLast_name(newLastName);
                            break;
                        case 3:
                            System.out.println("Old: " + newPersonContact.getCity());
                            System.out.print("New: ");
                            String newCity = in.next();
                            newPersonContact.setCity(newCity);
                            break;
                        case 4:
                            System.out.println("Old: " + newPersonContact.getState());
                            System.out.print("New: ");
                            String newState = in.next();
                            newPersonContact.setState(newState);
                            break;
                        case 5:
                            System.out.println("Old: " + newPersonContact.getZip());
                            System.out.print("New: ");
                            String newZip = in.next();
                            newPersonContact.setZip(newZip);
                            break;
                        case 6:
                            System.out.println("Old: " + newPersonContact.getPhNumber());
                            System.out.print("New: ");
                            String newPhone = in.next();
                            newPersonContact.setPhNumber(newPhone);
                            break;
                        case 7:
                            System.out.println("Old: " + newPersonContact.getEMail());
                            System.out.print("New: ");
                            String newEmail = in.next();
                            newPersonContact.setEMail(newEmail);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("invalid option....");
                            break;
                    }
                } while (choice != 0);


            } else {
                System.out.println("First name doesn't exist");
            }
        }

        public void deleteContactDetail(String firstName) {
            boolean flag = false;
            if (ContactDetails.isEmpty()) {
                System.out.println("------NO RECORDS------");
                return;
            }
            for (Contacts objPerson : ContactDetails) {
                if (objPerson.getFirst_name().equals(firstName)) {
                    ContactDetails.remove(objPerson);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("Record Deleted..");
            } else {
                System.out.println("First name doesn't exist");
            }
        }

        //display contact details
        public void displayContactDetails() {
            if (ContactDetails.isEmpty()) {//check list are empty or not
                System.out.println("------NO RECORDS------");
                return;
            }

            for (Contacts objPerson : ContactDetails) {
                System.out.println("--------------------------");
                objPerson.displayPersonContactDetails();
                System.out.println("--------------------------");
            }
        }


        public static String inputString(String message) {
            System.out.println(message);
            return input.next().toLowerCase();
        }

        public static int inputInteger(String message) {
            System.out.println(message);
            return input.nextInt();
        }

        public  char inputChar(String message) {
            System.out.println(message);
            return input.next().toUpperCase().charAt(0);
        }

        public static void displayBooks() {
            for (String books : dictAddressBook.keySet()) {
                System.out.println(books);
            }
        }

        public static void displayNames(AddressBook addressBook) {
            System.out.print("First Names: ");
            for (Contacts objPerson : addressBook.ContactDetails
            ) {
                System.out.print(objPerson.getFirst_name() + ", ");
            }
            System.out.println();
        }

        public static void userOperation(String bookName, AddressBook addressBook) {
            int choice = 0;
            do {
                System.out.println("--------------------------");
                System.out.println("Accessing: " + bookName);
                System.out.println("1. Add Person Details\n2. Display Details\n3. Edit Detail\n4. Delete Detail\n0. Exit");
                choice = inputInteger("Enter Choice: ");
                switch (choice) {
                    case 1:
                        assert addressBook != null;
                        addressBook.addContactDetail();
                        break;
                    case 2:
                        addressBook.displayContactDetails();
                        break;
                    case 3:
                        displayNames(addressBook);
                        String fNameEdit = inputString("Enter First Name: ");
                        addressBook.editContactDetail(fNameEdit);
                        break;
                    case 4:
                        String fNameDelete = inputString("Enter First Name to delete: ");
                        addressBook.deleteContactDetail(fNameDelete);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid input...");
                }
            } while (choice != 0);
        }

        public static void addressBookMenu() {
            int ch;
            System.out.println("Welcome to Address Book");
            do {
                String bookName = "";
                AddressBook addressBook = new AddressBook();
                ch = inputInteger("1. Create New book\n2. Edit Existing book\n" +
                        "3. Edit Global Contact\n4. search by city \n5. search by state\n6.view by city\n7.view by State \n8.Count by City \n9. Count by State" +
                        "\n(0 to Close)");
                switch (ch) {
                    case 1:
                        bookName = inputString("Enter New Address Book Name: ");
                        dictAddressBook.put(bookName, addressBook);
                        userOperation(bookName, addressBook);
                        break;

                    case 2:
                        if (!dictAddressBook.isEmpty()) {
                            displayBooks();
                            bookName = inputString("Enter Address Book Name to Access: ");
                            addressBook = dictAddressBook.get(bookName);
                            userOperation(bookName, addressBook);
                        } else {
                            System.out.println("No Address Books are present");
                        }
                        break;
                    case 3:
                        if (!dictAddressBook.isEmpty()) {
                            String personName = inputString("Enter Person Name to edit: ");
                            editGlobalContact(personName);
                        } else {
                            System.out.println("No Address Books are present");
                        }
                        break;
                    case 4:
                        searchPersonCity();
                        break;
                    case 5:
                        searchPersonState();
                        break;
                    case 6:
                        System.out.println("Enter City name");
                        String city = input.next();
                        viewPersonCity(city);
                        break;
                    case 7:
                        System.out.println("Enter State name");
                        String state = input.next();
                        viewPersonState(state);
                        break;
                    case 8:
                        System.out.println("Enter city name");
                        String cityToCount = input.next();
                        countPersonByCity(cityToCount);
                        break;
                    case 9:
                        System.out.println("Enter state name");
                        String stateToCount = input.next();
                        countPersonByState(stateToCount);
                        break;

                }
            } while (ch != 0);
        }

        public static void editGlobalContact(String personName) {
            boolean flag = false;
            for (AddressBook addressBook : dictAddressBook.values()) {
                for (Contacts listContactDetail : addressBook.ContactDetails
                ) {
                    if (listContactDetail.getFirst_name().equals(personName)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    addressBook.editContactDetail(personName);
                    break;
                }
            }
        }

        public static void searchPersonCity() {
            System.out.println("Enter City name");
            String city = input.next();
            dictAddressBook.values().forEach(book -> book.ContactDetails.stream().filter(person -> person.getCity().equalsIgnoreCase(city)).forEach(System.out::println));
        }

        public static void searchPersonState() {
            System.out.println("Enter State name");
            String state = input.next();
            dictAddressBook.values().forEach(book -> book.ContactDetails.stream().filter(person -> person.getState().equalsIgnoreCase(state)).forEach(System.out::println));

        }

        public static void viewPersonCity(String city) {
            ArrayList<Contacts> personDetails = (ArrayList<Contacts>) dictCity.get(city);
            Map<Contacts, Long> result = personDetails.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            System.out.println(result);
        }

        public static void viewPersonState(String state) {
            ArrayList<Contacts> personDetails = (ArrayList<Contacts>) dictState.get(state);
            Map<Contacts, Long> result = personDetails.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            System.out.println(result);
        }
        public static void countPersonByCity(String city) {
            ArrayList<Contacts> personDetails = (ArrayList<Contacts>) dictCity.get(city);
            int count = (int) personDetails.stream().count();
            System.out.println("city: " + city + " are " + count);
        }

        public static void countPersonByState(String state) {
            ArrayList<Contacts> personDetails = (ArrayList<Contacts>) dictCity.get(state);
            int count = (int) personDetails.stream().count();
            System.out.println("city: " + state + " are " + count);
        }

    }






