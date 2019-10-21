package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

public interface IGame {

    void addPlayer(IPlayer player);

    boolean isFinishedGame();

    String getDateAsString();

    String getLocation();

    String getAverageSkillLevel();

    String getGameLength();

    Date getDate();

    boolean hasNoPlayers(IGame game);

    IPlayer[] getPlayers();

}
