package com.danielkarlkvist.padelbuddy.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The abstract class Game defines TODO ...
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
abstract class Game implements IGame {
    private IPlayer[] players;
    private String location;
    private Date date;
    private String gameLength;
    private Tuple<Integer, Integer> result;

    Game(IPlayer player, int amountOfPlayers, String location, Date date, String gameLength) {
        this.players = new Player[amountOfPlayers];
        this.players[0] = player;
        this.location = location;
        this.date = date;
        this.result = result;
        this.gameLength = gameLength;
    }

    // region Getters and Setters
    public IPlayer[] getPlayers() {
        return players;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getDateAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM hh:mm");
        return simpleDateFormat.format(date);
    }

    public String getGameLength() {
        return gameLength;
    }

    public Tuple<Integer, Integer> getResult() {
        return result;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setResult(int score1, int score2) {
        this.result = new Tuple(score1, score2);
    }
    // endregion Getters and Setters

    public String getAverageSkillLevel() {
        double skillLevelSum = 0;
        int amountOfPlayers = 0;

        for (IPlayer player : players) {

            if (player != null) {
                if(player.getSkillLevel()>3.0){
                    player.setSkillLevel(2.0);
                }
                else{
                    skillLevelSum += player.getSkillLevel();
                    amountOfPlayers++;
                }
            }
        }

        double averageSkillLevelNumber = (skillLevelSum / amountOfPlayers + 0.5);

        return getAverageSkillLevelAsString((int) averageSkillLevelNumber);
    }

    private String getAverageSkillLevelAsString(int averageSkillLevelNumber) {
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

    public boolean hasPlayers() {
        boolean hasPlayers = false;
        int amountOfPlayers = players.length;

        for (int i = 0; i < amountOfPlayers; i++) {
            if (players[i] != null) {
                hasPlayers = true;
                break;
            }
        }

        return hasPlayers;
    }

    public boolean isFilled() {
        if (players[players.length - 1] == null) {
            return false;
        }

        return true;
    }

    /**
     * Checks if the Game is finished
     *
     * @return Returns true if Game has a result
     */
    public boolean isFinishedGame() {
        return result != null;
    }
    
    public void addPlayer(IPlayer player) {
        for (int i = 0; i < players.length; i++) {
            // player should not be able to join multiple times
            if (players[i] == player) {
                break;
            }

            if (players[i] == null) {
                players[i] = player;
                break;
            }
        }
    }
}
