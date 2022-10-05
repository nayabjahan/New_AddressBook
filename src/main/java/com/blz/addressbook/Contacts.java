package com.blz.addressbook;

public class Contacts {
    private String first_name;
    private String last_name;
    private String city;
    private String state;
    private String zip;
    private String phNumber;
    private String EMail;

    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zip + '\'' +
                ", phNumber='" + phNumber + '\'' +
                ", eMail='" + EMail + '\'' +
                '}';
    }
    public void displayPersonContactDetails() {
        System.out.println("First Name: " + first_name + "\nLast Name: " + last_name + "\nCity: " + city + "\nState: " + state + "\nZipCode : " + zip + "\nPhone Number: " + phNumber + "\nEmail Id: " + EMail);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public Contacts() {
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phNumber = phNumber;
        this.EMail = EMail;
    }
}
