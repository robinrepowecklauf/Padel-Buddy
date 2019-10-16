package com.danielkarlkvist.padelbuddy.Services;

import com.danielkarlkvist.padelbuddy.Model.Game;
import com.danielkarlkvist.padelbuddy.Model.IGame;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;

import java.util.List;

public class ITestFactory {

    private ITestFactory() {

    }

    public static List<IPlayer> createTestPlayers() {
        TestDataPlayers testDataPlayers = new TestDataPlayers();
        return testDataPlayers.create();
    }

    public static List<Game> createTestGames() {
        TestDataGames testDataGames = new TestDataGames();

        return testDataGames.create();
    }
}
