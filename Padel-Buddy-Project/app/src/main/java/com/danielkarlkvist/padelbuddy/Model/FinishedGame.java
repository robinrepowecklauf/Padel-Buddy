package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.Date;

public class FinishedGame extends Game {


    public FinishedGame(Player[] players, Location location, Date date) {
        super(players, location, date);
    }
}
