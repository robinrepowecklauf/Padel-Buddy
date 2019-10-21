package com.danielkarlkvist.padelbuddy.Model;

import android.net.IpPrefix;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PadelBuddy implements ICreate {

    private List<IGame> games = new ArrayList<>();
    private IPlayer user;

    public PadelBuddy(IPlayer user) {
        this.user = user;
    }


    public List<IGame> getGames() {
        return games;
    }

    public IPlayer getUser() {
        return user;
    }

    // TODO Command query?
    public void createAd(String location, Date date, String length) {
        IGame game = new PadelGame(user, location, date, length);
        games.add(game);
    }


    public void removeAd(IGame game) {
        if (games.contains(game)) {
            games.remove(game);
        } else {
            System.out.println("Game does not exist");
        }

        // TODO Error message? FancyToast Library?? Finns i slack
    }

    public List<IGame> getAvailableGames() {
        List<IGame> availableGames = new ArrayList<>();
        int arrayLength = games.get(0).getPlayers().length;
        boolean gameAvailable = true;

        for (IGame game : games) {
            for (int i = 0; i < arrayLength; i++) {
                if (game.getPlayers()[i] == user) {
                    gameAvailable = false;
                }
            }
            if (gameAvailable) {
                availableGames.add(game);
            }
            gameAvailable = true;
        }
        return availableGames;
    }

    public List<IGame> getUpcomingGames() {
        List<IGame> upcomingGames = new ArrayList<>();
        for (IGame game : games) {
            for (IPlayer player : game.getPlayers()) {
                Date gameDate = game.getDate();
                Date today = Calendar.getInstance().getTime();
                if (player == user && !game.isFinishedGame() && gameDate.after(today)) {
                    upcomingGames.add(game);
                }
            }
        }

        return upcomingGames;
    }

    public List<IGame> getPlayedGames() {
        List<IGame> playedGames = new ArrayList<>();
        for (IGame game : games) {
            for (IPlayer player : game.getPlayers()) {
                Date gameDate = game.getDate();
                Date today = Calendar.getInstance().getTime();
                if (player == user && gameDate.before(today)){
                        playedGames.add(game);
                }
            }
        }
        System.out.println(Calendar.getInstance().getTime());
        return playedGames;
    }

    public void joinGame(IGame game) {
        IPlayer[] players = game.getPlayers();
        int arrayLength = players.length;
        boolean available = true;

        for (int i = 0; i < arrayLength; i++) {
            if (players[i] == user) {
                available = false;
            }
        }

        if (available) {
            game.addPlayer(user);
        }
    }

    public void leaveGame(IGame game) {
        IPlayer[] players = game.getPlayers();
        int arrayLength = players.length;
        for (int i = 0; i < arrayLength; i++){
            if(players[i] == user){
                players[i] = null;
            }
        }
    }
}
