package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.Date;

class FinishedGame extends Game {

    FinishedGame(Player[] players, Location location, Date date) {
        super(players, location, date);
    }
}
