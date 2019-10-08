package com.danielkarlkvist.padelbuddy.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The ProfileFragmentController class represents all information about a game
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */

public class Game {
    private Player[] players = new Player[4];
    private String location;
    private Date date;
    private Tuple<Integer, Integer> result;

    Game(Player player, String location, Date date) {
        this.players[0] = player;
        this.location = location;
        this.date = date;
        this.result = result;
    }

    // TODO decide return type
    private void getAvgSkillLevel() {

    }

    boolean isFinishedGame() {
        return result != null;
    }

    void setResult(int t1, int t2) {
        this.result = new Tuple(t1, t2);
    }

    //Setters and Getters.

    /**
     * Get the players currently in the game
     *
     * @return Players in the game
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Get the location of the game
     *
     * @return The location of the game
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location of the game
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the date when the game should be played formatted as dd/MM hh:mm
     *
     * @return The date of the game formatted as dd/MM hh:mm
     */
    public String getDateAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM hh:mm");
        String formattedDate = simpleDateFormat.format(date);

        return formattedDate;
    }

    /**
     * Set the date when the game should be played
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
