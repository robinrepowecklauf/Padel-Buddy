package com.danielkarlkvist.padelbuddy.Services;


import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;


public class ITestFactory {

    private ITestFactory() {

    }

    public static void createTestGames(PadelBuddy padelBuddy) {
        TestDataGames testDataGames = new TestDataGames();
        testDataGames.createTestGame(padelBuddy);
    }
}
