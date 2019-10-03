package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Date;

// singleton class
public class PadelBuddy {

    private static PadelBuddy instance = null;

    private ArrayList<Game> games = new ArrayList<>();
    private Player player;

    private PadelBuddy(Player player) {
        this.player = player;
    }

    public static PadelBuddy getInstance() {
        if (instance == null) {
            Player player = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 1, 3);
            instance = new PadelBuddy(player);
        }

        return instance;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public Player getPlayer() {
        return player;
    }

    // TODO Command query?
    public void createAd(String location, Date date) {
        Game game = new Game(player, location, date);
        game.getPlayers()[0] = player;
        games.add(game);
    }

    public void removeAd(Game game) {
        if (games.contains(game)) {
            games.remove(game);
        }
        // TODO Error message? FancyToast Library?? Finns i slack
    }
}
