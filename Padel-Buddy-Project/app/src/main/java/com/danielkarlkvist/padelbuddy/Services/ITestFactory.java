package com.danielkarlkvist.padelbuddy.Services;


import com.danielkarlkvist.padelbuddy.Model.IGame;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;

import java.util.List;

public class ITestFactory {

    private ITestFactory() {

    }

    public static List<IPlayer> createTestPlayers() {
        TestDataPlayers testDataPlayers = new TestDataPlayers();
        return testDataPlayers.createTestPlayer();
    }

    public static void createTestGames(PadelBuddy padelBuddy) {
        TestDataGames testDataGames = new TestDataGames();
        testDataGames.createTestGame(padelBuddy);
    }
}
