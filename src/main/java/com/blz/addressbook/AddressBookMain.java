package com.blz.addressbook;

import java.sql.*;

public class AddressBookMain {
    public static void main(String[] args) throws SQLException {

        AddressBook addressBook = new AddressBook();
        addressBook.addressBookMenu();
        AddressBookDatabase db = new AddressBookDatabase();
        db.getConnectionSQL();
        db.retrieveEntryFromDB();

    }
}
