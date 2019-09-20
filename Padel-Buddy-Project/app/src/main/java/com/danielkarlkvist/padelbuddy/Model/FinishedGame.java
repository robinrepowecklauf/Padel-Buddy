package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.Date;

class FinishedGame extends Game {

    FinishedGame(Location location, Date date) {
        super(location, date);
    }
}
