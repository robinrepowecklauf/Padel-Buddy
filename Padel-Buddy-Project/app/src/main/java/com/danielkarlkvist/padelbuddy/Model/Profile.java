package com.danielkarlkvist.padelbuddy.Model;

public class Profile {

    private String firstName;
    private String lastName;
    private String mail;
    private String biography;
    private int phone;
    private int age;
    private int skillRating;
    private int profileRating;

    public Profile(String firstName, String lastName, int phone, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
