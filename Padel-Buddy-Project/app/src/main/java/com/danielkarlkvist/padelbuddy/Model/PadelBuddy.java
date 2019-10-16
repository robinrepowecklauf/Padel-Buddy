package com.danielkarlkvist.padelbuddy.Model;

import com.danielkarlkvist.padelbuddy.Services.ITestFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PadelBuddy {

    private List<Game> games = new ArrayList<>();
    private Player player;
    public List<IPlayer> testPlayers = new ArrayList<>();

    public PadelBuddy() {

        this.player = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);

    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Game> getGames() {
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

    public List<Game> getUpcomingGames() {
        List<Game> upcomingGames = new ArrayList<>();
        for (Game game : games) {
            if (!game.isFinishedGame()) {
                upcomingGames.add(game);
            }
        }

        return upcomingGames;
    }


    public List<Game> getPlayedGames() {
        List<Game> playedGames = new ArrayList<>();
        for (Game game : games) {
            if (game.isFinishedGame()) {
                playedGames.add(game);
            }
        }

        return playedGames;
    }
}
