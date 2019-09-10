package com.danielkarlkvist.padelbuddy;

public class Profile {

    private String firstname;
    private String lastname;
    private int phonenumber;
    private int age;

    public Profile (String firstname, String lastname, int phonenumber, int age){
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhonenumber(int phonenumber){
        this.phonenumber = phonenumber;
    }

    public void setAge(int age){
        this.age = age;
    }
}
