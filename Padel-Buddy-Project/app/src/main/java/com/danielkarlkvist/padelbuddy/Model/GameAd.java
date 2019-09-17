package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

public class GameAd {
    private Player[] players = new Player[4];
    private String description;
    private Date time;

    public GameAd(Player[] players, String description, Date time) {
        this.players = players;
        this.description = description;
        this.time = time;
    }
}
