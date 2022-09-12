package com.blz.addressBook;
public class Contacts {
        private String firstName;
        private String lastName;
        private String city;
        private String state;
        private String zipCode;
        private String phNumber;
        private String EMail;

        @Override
        public String toString() {
            return "Contacts{" +
                           "firstName='" + firstName + '\'' +
                           ", lastName='" + lastName + '\'' +
                           ", city='" + city + '\'' +
                           ", state='" + state + '\'' +
                           ", zipCode='" + zipCode + '\'' +
                           ", phNumber='" + phNumber + '\'' +
                           ", eMail='" + EMail + '\'' +
                           '}';
        }
        public void displayPersonContactDetails() {
            System.out.println("First Name: " + firstName + "\nLast Name: " + lastName + "\nCity: " + city + "\nState: " + state + "\nZipCode : " + zipCode + "\nPhone Number: " + phNumber + "\nEmail Id: " + EMail);
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
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

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
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
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.phNumber = phNumber;
            this.EMail = EMail;
        }
}


