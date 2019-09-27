package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// singleton class
public class PadelBuddy {

    private static PadelBuddy instance = null;

    private List<Game> games = new ArrayList<>();
    private Player player;

    private PadelBuddy(Player player) {
        this.player = player;
    }

    public static PadelBuddy getInstance() {
        if (instance == null) {
            Player player = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", 20, 1);
            instance = new PadelBuddy(player);
        }

        return instance;
    }

    // TODO Command query?
    void createAd(Location location, Date date) {
        Game game = new Game(location, date);
        game.getPlayers()[0] = player;
        games.add(game);
    }

    void removeAd(Game game) {
        if (games.contains(game)) {
            games.remove(game);
        }
        // TODO Error message? FancyToast Library?? Finns i slack
    }
}
