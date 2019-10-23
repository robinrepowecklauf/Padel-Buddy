package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The PadelBuddy class defines TODO ...
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public class PadelBuddy implements ICreate {

    private List<IGame> games = new ArrayList<>();
    private IPlayer user;

    public PadelBuddy(IPlayer user) {
        this.user = user;
    }

    // region Getters and Setters
    public List<IGame> getGames() {
        List<IGame> games = new ArrayList<>();

        games.addAll(this.games);

        return games;
    }

    public IPlayer getUser() {
        return user;
    }
    // endregion Getters and Setters

    public void createAd(String location, Date date, String length) {
        IGame game = new PadelGame(user, location, date, length);
        games.add(game);
    }

    public void removeAd(IGame game) {
        if (games.contains(game)) {
            games.remove(game);
        }
    }

    public List<IGame> getJoinableGames() {
        List<IGame> availableGames = new ArrayList<>();
        int arrayLength = games.get(0).getPlayers().length;
        boolean gameAvailable = true;

        for (IGame game : games) {
            for (int i = 0; i < arrayLength; i++) {
                if (game.getPlayers()[i] == user) {
                    gameAvailable = false;
                }
            }
            if (gameAvailable && isGameDateAfterToday(game)) {
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
                if (player == user && !game.isFinishedGame() && isGameDateAfterToday(game)) {
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
                if (player == user && !isGameDateAfterToday(game)) {
                    playedGames.add(game);
                }
            }
        }

        return playedGames;
    }

    public boolean isGameDateAfterToday(IGame game) {
        Date today = Calendar.getInstance().getTime();
        Date gameDate = game.getDate();

        return gameDate.after(today);
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

        for (int i = 0; i < arrayLength; i++) {
            if (players[i] == user) {
                players[i] = null;
            }
        }

        if (game.hasNoPlayers(game)) {
            games.remove(game);
        }
    }
}
