package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// singleton class
public class PadelBuddy {

    private static PadelBuddy instance = null;

    private ArrayList<Game> games = new ArrayList<>();
    private Player player;
    public static List<Player> testPlayers = new ArrayList<>();

    private PadelBuddy(Player player) {
        this.player = player;
    }

    public static PadelBuddy getInstance() {
        if (instance == null) {
            Player player = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 1);
            instance = new PadelBuddy(player);

            // creating test players for functionality purposes
            testPlayers.add(new Player("Robin", "Repo Wecklauf", "robinrepowecklauf@gmail.com", "0704549972", "lorem ipsum", 15, 2));
            testPlayers.add(new Player("Carl-Johan", "Björnson", "test@gmail.com", "123", "lorem ", 14, 3));
            testPlayers.add(new Player("Marcus", "Creutz", "test@gmail.com", "123", "lorem ", 14, 4));
            testPlayers.add(new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 5));
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

    public ArrayList<Game> getUpcomingGames() {
        ArrayList<Game> upcomingGames = new ArrayList<>();
        for (Game game : games) {
            if (!game.isFinishedGame()) {
                upcomingGames.add(game);
            }
        }

        return upcomingGames;
    }


    public ArrayList<Game> getPlayedGames() {
        ArrayList<Game> playedGames = new ArrayList<>();
        for (Game game : games) {
            if (game.isFinishedGame()) {
                playedGames.add(game);
            }
        }

        return playedGames;
    }
}
