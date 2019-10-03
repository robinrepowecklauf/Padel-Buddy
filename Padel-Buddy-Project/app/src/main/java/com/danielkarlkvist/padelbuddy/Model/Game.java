package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
    private Player[] players = new Player[4];
    private String location;
    private Date date;
    private Tuple<Integer, Integer> result;

    Game(Player player, String location, Date date) {
        this.players[0] = player;
        this.location = location;
        this.date = date;
        this.result = result;
    }

    // TODO decide return type
    private void getAvgSkillLevel() {

    }

    boolean isFinishedGame(){
        return result!=null;
    }

    void setResult(int t1, int t2){
        this.result = new Tuple(t1, t2);
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
