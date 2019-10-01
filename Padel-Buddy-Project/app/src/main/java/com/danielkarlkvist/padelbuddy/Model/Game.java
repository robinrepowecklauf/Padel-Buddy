package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
    private Player[] players = new Player[4];
    private String location;
    private Date date;

    Game(Player player, String location, Date date) {
        this.players[0] = player;
        this.location = location;
        this.date = date;
    }

    // TODO decide return type
    private void getAvgSkillLevel() {

    }

    //Setters and Getters.

    public Player[] getPlayers() {
        return players;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM hh:mm");
        String formattedDate = simpleDateFormat.format(date);

        return formattedDate;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
