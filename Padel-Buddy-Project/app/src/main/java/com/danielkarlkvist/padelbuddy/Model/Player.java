package com.danielkarlkvist.padelbuddy.Model;

/**
 * The Player class defines a player which holds values that represents a player
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
class Player implements IPlayer {
    private String firstName;
    private String lastName;
    private String mail;
    private String biography;
    private int age;        // TODO show age in profile?
    private double skillLevel;
    private float profileRating;

    Player(String firstName, String lastName, String mail, String biography, int age, double skillLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.biography = biography;
        this.age = age;
        this.skillLevel = skillLevel;
        this.profileRating = 3.5f; // Hardcoded value at the moment
    }
    public void setSkillLevel(double skillLevel) {
        this.skillLevel = skillLevel;
    }

    // region Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getBiography() {
        return biography;
    }

    public double getSkillLevel() {
        return skillLevel;
    }

    public float getProfileRating() {
        return profileRating;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
    // endregion Getters and Setters
}