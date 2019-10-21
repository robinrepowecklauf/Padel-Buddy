package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

public interface IGame {

    void addPlayer(IPlayer player);

    boolean isFinishedGame();

    String getDateAsString();

    String getLocation();

    String getAverageSkillLevel();

    IPlayer[] getPlayers();

    String getGameLength();

    Date getDate();

}
