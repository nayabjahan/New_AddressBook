package com.blz.addressbook;

import java.sql.*;
import java.util.*;

public class AddressBookDatabase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/addressbookdb" ;
    static final String USER = "root" ;
    static final String PASS = "Alamzafir786@" ;
    public Connection getConnectionSQL() throws SQLException {
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        if(con.isClosed())
            System.out.println("Connection is not Established");
        else
            System.out.println("Connection Established successfully. " + con);

        return con;
    }
    public void retrieveEntryFromDB() throws SQLException {
        Connection connect = getConnectionSQL();
        String stmt = "SELECT * FROM address_bookdb";
        List<Contacts> users = new ArrayList<>();
        ResultSet set = connect.createStatement().executeQuery(stmt);
        while (set.next()) {
            Contacts contacts = new Contacts();
            contacts.setFirst_name(set.getString("First_Name"));
            contacts.setLast_name(set.getString("Last_Name"));
            contacts.setCity(set.getString("city"));
            contacts.setState(set.getString("State"));
            contacts.setZip(set.getString("zip"));
            contacts.setPhNumber(set.getString("phone_number"));
            contacts.setEMail(set.getString("email"));
            users.add(contacts);
        }
        System.out.println(users);
    }
}

