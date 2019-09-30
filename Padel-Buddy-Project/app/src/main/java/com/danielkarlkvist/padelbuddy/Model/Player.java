package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String firstname;
    private String lastname;
    private String mail;
    private String phone;
    private int age;
    private double skillLevel;
    private double profileRating;

    Player(String firstname, String lastname, String mail, String phone, int age, double skillLevel) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
        this.age = age;
        this.skillLevel = skillLevel;
        this.profileRating = 0;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }
}