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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getBiography() {
        return biography;
    }

    public int getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public int getSkillRating() {
        return skillRating;
    }

    public int getProfileRating() {
        return profileRating;
    }



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
