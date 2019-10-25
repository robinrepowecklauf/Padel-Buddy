package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The PadelBuddy class is the entry to the model and contains the user of the app as well as all games and methods to sort games
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

    /**
     * Creates a game(PadelGame) and adds it to the games list
     *
     * @param location
     * @param date
     * @param length
     */
    public void createAd(String location, Date date, String length) {
        IGame game = new PadelGame(user, location, date, length);
        games.add(game);
    }

    /**
     * Removes a game from the list if the game is in the list
     *
     * @param game
     */
    public void removeAd(IGame game) {
        if (games.contains(game)) {
            games.remove(game);
        }
    }

    /**
     * Returns the games that the user can join,
     * i.e games that the user hasn't already joined before,
     * games that aren't already filled with the max amount of players
     * and games which the date hasn't passed
     *
     * @return Returns a new list of games the player can join
     */
    public List<IGame> getJoinableGames() {
        List<IGame> availableGames = new ArrayList<>();
        int amountOfPlayers = games.get(0).getPlayers().length;
        boolean gameAvailable = true;

        for (IGame game : games) {
            for (int i = 0; i < amountOfPlayers; i++) {
                if (game.getPlayers()[i] == user || game.isFilledWithPlayers()) {
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

    /**
     * Returns the games user's upcoming games
     *
     * @return Returns a new list of the user's upcoming games
     */
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

    /**
     * Finds the games where the user is in and the date has passed
     *
     * @return Returs the user's played games
     */
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

    /**
     * Checks if a the chosen games date has passed
     *
     * @param game
     * @return Returns true if the game date has passed
     */
    public boolean isGameDateAfterToday(IGame game) {
        Date today = Calendar.getInstance().getTime();
        Date gameDate = game.getDate();

        return gameDate.after(today);
    }

    /**
     * Adds the user to a specific game
     *
     * @param game
     */
    public void joinGame(IGame game) {
        IPlayer[] players = game.getPlayers();
        int amountOfPlayers = players.length;
        boolean available = true;

        for (int i = 0; i < amountOfPlayers; i++) {
            if (players[i] == user) {
                available = false;
            }
        }

        if (available) {
            game.addPlayer(user);
        }
    }

    /**
     * Removes the user from a specific game
     *
     * @param game
     */
    public void leaveGame(IGame game) {
        IPlayer[] players = game.getPlayers();
        int amountOfPlayers = players.length;

        for (int i = 0; i < amountOfPlayers; i++) {
            if (players[i] == user) {
                players[i] = null;
            }
        }

        if (!game.hasPlayers()) {
            games.remove(game);
        }
    }
}
