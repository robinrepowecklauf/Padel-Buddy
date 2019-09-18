package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.Date;

public abstract class Game {
    private Player[] players;
    private Location location;
    private Date date;

    public Game(Player[] players, Location location, Date date) {
        this.players = players;
        this.location = location;
        this.date = date;
    }

    // TODO decide return type
    private void getAvgSkillLevel() {

    }

    // TODO decide return type
    private void getAvgProfileRating() {

    }
}
