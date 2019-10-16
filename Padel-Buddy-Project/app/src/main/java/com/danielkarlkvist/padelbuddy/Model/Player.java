package com.danielkarlkvist.padelbuddy.Model;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * The Player class defines a player which holds values that are being accessed from
 * a user's profile and gameads
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */

// TODO Package-private

public class Player implements IPlayer {

    private String firstname;
    private String lastname;
    private String mail;
    private String phone;
    private String bio;
    private int age;
    private SkillLevel skillLevel;
    private float profileRating;
    private CircleImageView image; //inte i model- ska finnas i vy map<user, circleimageview>

    public Player(String firstname, String lastname, String mail, String phone, String bio, int age, SkillLevel skillLevel) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
        this.bio = bio;
        this.age = age;
        this.skillLevel = skillLevel;
        this.profileRating = 3.3f;
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
        return 3;
    }

    public void setImage(CircleImageView image) {
        this.image = image;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    @Override
    public CircleImageView getImage() {
        return image;
    }
}