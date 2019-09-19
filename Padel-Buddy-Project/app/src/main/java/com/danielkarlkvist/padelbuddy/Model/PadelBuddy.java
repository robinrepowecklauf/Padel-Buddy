package com.danielkarlkvist.padelbuddy.Model;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PadelBuddy {

    private List<GameAd> gameAds = new ArrayList<>();
    private List<FinishedGame> finishedGames = new ArrayList<>();
    private Player player;

    public PadelBuddy(Player player) {
        this.player = player;
    }

    //TODO Command query?
    void createAd(Location location, Date date) {
        GameAd gameAd = new GameAd(location, date);
        gameAd.getPlayers()[0] = player;
        gameAds.add(gameAd);
    }

    void deleteAd(GameAd gameAd) {
        if (finishedGames.contains(gameAd)) {
            finishedGames.remove(gameAd);
        }
        // TODO Error message?
    }
}
