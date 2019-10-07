package com.danielkarlkvist.padelbuddy.Model;

import android.media.Image;
import android.net.Uri;
import android.widget.ImageView;

import com.danielkarlkvist.padelbuddy.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Player {

    private String firstname;
    private String lastname;
    private String mail;
    private String phone;
    private String bio;
    private int age;
    private int gamesPlayed;
    private double skillLevel;
    private float profileRating;
    private CircleImageView image;


    Player(String firstname, String lastname, String mail, String phone, String bio, int age, double skillLevel, int gamesPlayed) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
        this.bio = bio;
        this.age = age;
        this.skillLevel = skillLevel;
        this.profileRating = 3.3f;
        this.gamesPlayed = gamesPlayed;
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public float getProfileRating() {
        return profileRating;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(CircleImageView image) {
        this.image = image;
    }
}