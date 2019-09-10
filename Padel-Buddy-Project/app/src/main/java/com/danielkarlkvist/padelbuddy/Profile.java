package com.danielkarlkvist.padelbuddy;

public class Profile {

    private String firstName, lastName, mail, biography;
    private int phone, age, skillRating, profileRating;

    public Profile (String firstname, String lastname, int phonenumber, int age){
        this.firstName = firstname;
        this.lastName = lastname;
        this.phone = phone;
        this.age = age;
    }

    public void setFirstname(String firstname){
        this.firstName = firstname;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public void setPhonenumber(int phonenumber){
        this.phone = phone;
    }

    public void setAge(int age){
        this.age = age;
    }
}
