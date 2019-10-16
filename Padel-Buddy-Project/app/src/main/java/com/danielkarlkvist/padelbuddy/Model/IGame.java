package com.danielkarlkvist.padelbuddy.Model;

public interface IGame {
    String getDateAsString();
    String getLocation();
    IPlayer[] getPlayers();
    boolean isFinishedGame();
    String getAverageSkillLevel();
    void addPlayer(IPlayer player);

}
