package com.danielkarlkvist.padelbuddy.Services;

public class ITestFactory {

    private ITestFactory() {

    }

    public static ITestData createTestPlayers() {
        return new TestDataPlayers();
    }

    public static ITestData createTestGames() {
        return new TestDataGames();
    }
}
