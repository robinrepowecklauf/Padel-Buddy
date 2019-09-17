package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.ArrayList;
import java.util.List;

class Player {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String mail;
    private String biography;
    private String phone;
    private int age;
    private double skillLevel;
    private double profileRating;
    private List<GameAd> gameAds = new ArrayList<>();

    public Player(String firstname, String lastname, String username, String password, String mail, String biography, String phone, int age, double skillLevel) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.biography = biography;
        this.phone = phone;
        this.age = age;
        this.skillLevel = skillLevel;
    }
}