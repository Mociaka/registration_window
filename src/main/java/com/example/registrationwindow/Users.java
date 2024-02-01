package com.example.registrationwindow;

public class Users {
    private String firstName;
    private String lastName;
    private String  userName;
    private String passwrod;
    private String location;
    private String gender;

    public Users() {
    }

    public Users(String firstName, String lastName, String userName, String passwrod, String location, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passwrod = passwrod;
        this.location = location;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }

    public static String sName ="";
}
