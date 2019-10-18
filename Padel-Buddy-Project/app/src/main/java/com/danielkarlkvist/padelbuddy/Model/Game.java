package com.danielkarlkvist.padelbuddy.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The ProfileFragment class represents all waiting_for_player_picture about a game
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */

 abstract class Game implements IGame{
    private IPlayer[] players;
    private String location;
    private Date date;
    private String gameLength;
    private Tuple<Integer, Integer> result;

    Game(IPlayer player, int amountOfPlayers, String location, Date date, String gameLength) {
        this.players = new Player[amountOfPlayers];
        players[0] = player; //Detta gör att alla games hamnar i kommande matcher
        this.location = location;
        this.date = date;
        this.result = result;
        this.gameLength = gameLength;
    }

    public String getAverageSkillLevel() {
        double skillLevelSum = 0;
        int amountOfPlayers = 0;
        for (int i=0; i < players.length; i++) {
            if(players[i] != null) {
                skillLevelSum += players[i].getSkillLevel();
                amountOfPlayers++;
            }
        }

        double averageSkillLevelNumber = (skillLevelSum/amountOfPlayers + 0.5);

        return getAverageSkillLevelFromInt((int) averageSkillLevelNumber);
    }

    private String getAverageSkillLevelFromInt(int averageSkillLevelNumber) {
        switch (averageSkillLevelNumber) {
            case 1:
                return "Nybörjare";
            case 2:
                return "Medel";
            case 3:
                return "Avancerad";
                default:
                    return "Medel";
        }
    }

    /**
     * Checks if the Game is finished
     * @return Returns true if Game has a result
     */
    public boolean isFinishedGame(){
        return result != null;
    }

    /**
     * Set both scores of each team
     * @param score1
     * @param score2
     */
    public void setResult(int score1, int score2) {
        //this.result = new Tuple(score1, score2);
    }

    /**
     * Get the players currently in the game
     *
     * @return Players in the game
     */
    public IPlayer[] getPlayers() {
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM hh:mm");
        String formattedDate = simpleDateFormat.format(date);

        return formattedDate;
    }



    public String getGameLength() {
        return gameLength;
    }


    /**
     * Set the date when the game should be played
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public void addPlayer(IPlayer player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                break;
            }
        }
    }
    }
