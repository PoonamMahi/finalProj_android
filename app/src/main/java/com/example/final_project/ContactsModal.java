package com.example.final_project;

public class ContactsModal {

    // variables for userName and contactNumber.
    private String userName;
    private String contactNumber;

    // constructor
    public ContactsModal(String userName, String contactNumber) {
        this.userName = userName;
        this.contactNumber = contactNumber;
    }

    // getter and setter are created
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}


