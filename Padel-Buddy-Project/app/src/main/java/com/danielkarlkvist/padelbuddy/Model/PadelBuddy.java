package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PadelBuddy {

    private List<IGame> games = new ArrayList<>();
    private Player player;

    public PadelBuddy() {

        //this.player = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);

    }


    public List<IGame> getGames() {
        return games;
    }

    public Player getPlayer() {
        return player;
    }

    // TODO Command query?
    public void createAd(String location, Date date) {
        Game game = new PadelGame(player, location, date);
        game.getPlayers()[0] = player;
        games.add(game);
    }

    public void removeAd(IGame game) {
        if (games.contains(game)) {
            games.remove(game);
        }

        // TODO Error message? FancyToast Library?? Finns i slack
    }

    public List<IGame> getUpcomingGames() {
        List<IGame> upcomingGames = new ArrayList<>();
        for (IGame game : games) {
            if (!game.isFinishedGame()) {
                upcomingGames.add(game);
            }
        }

        return upcomingGames;
    }


    public List<IGame> getPlayedGames() {
        List<IGame> playedGames = new ArrayList<>();
        for (IGame game : games) {
            if (game.isFinishedGame()) {
                playedGames.add(game);
            }
        }

        return playedGames;
    }
}
