package com.danielkarlkvist.padelbuddy.Model;

public interface IGame {

    void addPlayer(IPlayer player);

    boolean isFinishedGame();

    String getDateAsString();

    String getLocation();

    String getAverageSkillLevel();

    IPlayer[] getPlayers();

}
