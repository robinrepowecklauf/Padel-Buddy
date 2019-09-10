package com.danielkarlkvist.padelbuddy;

public class Profile {

    private String firstName, lastName, mail, biography;
    private int phone, age, skillRating, profileRating;

    public Profile (String firstName, String lastName, int phone, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public void setAge(int age){
        this.age = age;
    }
}
