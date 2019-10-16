package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PadelBuddy {

    private ArrayList<Game> games = new ArrayList<>();
    private Player player;
    public static List<IPlayer> testPlayers = new ArrayList<>();

    public PadelBuddy() {
        this.player = player;
        player = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
        testPlayers.add(new Player("Robin", "Repo Wecklauf", "robinrepowecklauf@gmail.com", "0704549972", "lorem ipsum", 15, SkillLevel.Avancerad));
        testPlayers.add(new Player("Carl-Johan", "Björnson", "tes@gmail.com", "1", "lorem ", 14, SkillLevel.Medel));
        testPlayers.add(new Player("Marcus", "Creutz", "test@gail.com", "2", "lorem ", 13, SkillLevel.Nybörjare));
        testPlayers.add(new Player("Fredrik", "Axelsson", "tet@gmail.com", "3", "lorem ", 12, SkillLevel.Avancerad));
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
