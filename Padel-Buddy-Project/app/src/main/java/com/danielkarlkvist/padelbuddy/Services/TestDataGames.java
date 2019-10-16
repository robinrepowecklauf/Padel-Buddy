package com.danielkarlkvist.padelbuddy.Services;

import com.danielkarlkvist.padelbuddy.Model.Game;
import com.danielkarlkvist.padelbuddy.Model.IGame;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

class TestDataGames implements ITestData {

    private PadelBuddy padelBuddy = new PadelBuddy();
    private Random rand = new Random();
    private TestDataPlayers testDataPlayers = new TestDataPlayers();
    private List<Game> testDataGames = new ArrayList<>();


    @Override
    public List<IGame> create() {

        for (int i = 0; i < 15; i++) {
            padelBuddy.createAd("Padel center gbg", new Date(2019, rand.nextInt(12), rand.nextInt(31), rand.nextInt(24), rand.nextInt(61)));
        }

        testDataGames = padelBuddy.getGames();
        testDataPlayers.create();

        for (int j = 0; j < testDataGames.size(); j++) {
            for (int i = 0; i < 2; i++) {
                List<IPlayer> players = Arrays.asList(testDataGames.get(j).getPlayers());
                int random = rand.nextInt(4);
                while (players.contains(testDataPlayers.players.get(random))) {
                    random = rand.nextInt(4);
                }
                testDataGames.get(j).addPlayer(testDataPlayers.players.get(random));
            }
        }

        return testDataGames;
    }
}
