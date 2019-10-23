package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

/**
 * The IGame interface defines TODO ...
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public interface IGame {

    String getDateAsString();

    String getLocation();

    String getAverageSkillLevel();

    String getGameLength();

    Date getDate();

    IPlayer[] getPlayers();

    void addPlayer(IPlayer player);

    boolean isFinishedGame();

    boolean hasNoPlayers(IGame game);
}
