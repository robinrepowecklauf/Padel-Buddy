package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PadelBuddy implements ICreate {

    private List<IGame> games = new ArrayList<>();
    private IPlayer player;

    public PadelBuddy(IPlayer player) {
        this.player = player;
        //this.player = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);

    }


    public List<IGame> getGames() {
        return games;
    }

    public IPlayer getPlayer() {
        return player;
    }

    // TODO Command query?
    public void createAd(String location, Date date, String length) {
        IGame game = new PadelGame(location, date, length);
        game.getPlayers()[0] = player;
        games.add(game);
    }


    public void removeAd(IGame game) {
        if (games.contains(game)) {
            games.remove(game);
        }

        // TODO Error message? FancyToast Library?? Finns i slack
    }

    public List<IGame> getAvailableGames() {
        List<IGame> availableGames = new ArrayList<>();
        int arrayLength = games.get(0).getPlayers().length;

        for (IGame game : games){
            for (int i=0; i<arrayLength; i++){
                if (game.getPlayers()[i] == player){
                    break;
                }
                availableGames.add(game);
            }
        }
        //Hardcoded game where Daniel is not a player. should be removed when we create games without daniel in Service.
        //availableGames.add(createAd(new Player("Calle","balle","lingon","skalle","hejsan",12,2), "PDL Trollhättan", new Date(), "60 min"););
        return availableGames;
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
