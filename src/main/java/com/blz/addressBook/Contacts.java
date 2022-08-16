package com.blz.addressBook;

import lombok.Data;
import lombok.Getter;

@Data
public class Contacts {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;
    private String phoneNo;
    private String eMail;

}
