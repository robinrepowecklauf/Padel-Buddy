package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.Date;

abstract class Game {
    private Player[] players = new Player[4];
    private Location location;
    private Date date;

    Game(Location location, Date date) {
        this.location = location;
        this.date = date;
    }

    // TODO decide return type
    private void getAvgSkillLevel() {

     }

    // TODO decide return type
    private void getAvgProfileRating() {

    }

    //Setters and Getters.

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
