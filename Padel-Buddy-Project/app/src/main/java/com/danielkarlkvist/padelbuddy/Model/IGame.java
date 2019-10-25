package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

/**
 * The IGame interface defines the methods that should be able to run of a Game outside of the Model
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public interface IGame {

    String getDateAsString();

    String getLocation();

    String getGameLength();

    /**
     * Calculates the average skill level of the players in the Game
     *
     * @return Returns the average skill level of the players in the Game as a String
     */
    String getAverageSkillLevel();

    Date getDate();

    void setResult(int score1, int score2);

    IPlayer[] getPlayers();

    /**
     * Adds a player to the Game if it isn't already in it
     */
    void addPlayer(IPlayer player);

    /**
     * Checks if the Game is finished
     *
     * @return Returns true if Game has a result
     */
    boolean isFinishedGame();

    /**
     * Checks if the Game has at least one player
     *
     * @return Returns true if the Game has at least one player
     */
    boolean hasPlayers();

    /**
     * Checks if the Game has filled the max amount of players
     *
     * @return Returns true if the Game has filled the max amount of players
     */
    boolean isFilledWithPlayers();
}
