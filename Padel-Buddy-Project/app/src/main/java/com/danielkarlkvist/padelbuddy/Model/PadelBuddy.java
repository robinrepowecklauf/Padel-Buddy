package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PadelBuddy {

    private List<Game> games = new ArrayList<>();
    private Player player;

    public PadelBuddy(Player player) {
        this.player = player;
    }

    // TODO Command query?
    void createAd(Location location, Date date) {
        Game game = new Game(location, date);
        game.getPlayers()[0] = player;
        games.add(game);
    }

    void deleteAd(Game game) {
        if (games.contains(game)) {
            games.remove(game);
        }
        // TODO Error message? FancyToast Library?? Finns i slack
    }
}
