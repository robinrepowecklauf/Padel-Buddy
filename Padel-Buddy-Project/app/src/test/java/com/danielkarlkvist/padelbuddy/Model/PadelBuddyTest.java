package com.danielkarlkvist.padelbuddy.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.junit.Assert.*;

public class PadelBuddyTest {

    private PadelBuddy padelBuddy = new PadelBuddy(new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 2));
    Player badplayer1 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 1);
    IGame game1 = new PadelGame(badplayer1, "Gltk", new Date(2019, 11, 05), "60");
    IGame game2 = new PadelGame(badplayer1, "Gltk", new Date(2019, 11, 05), "60");


    @Test
    public void createAd_GameExist_ReturnsTrue() {
        int temp = padelBuddy.getGames().size();
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        assertTrue(padelBuddy.getGames().size() == temp + 1);
    }

    @Test
    public void createAd_PlayerExist_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        assertTrue(padelBuddy.getGames().get(padelBuddy.getGames().size() - 1).getPlayers() != null);
    }

    @Test
    public void removeAd_GamesExist_ReturnsTrue() {
        int temp = padelBuddy.getGames().size();
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        padelBuddy.removeAd(padelBuddy.getGames().get(padelBuddy.getGames().size() - 1));
        assertTrue(padelBuddy.getGames().size() == temp);

    }

    @Test
    public void removeAd_RemoveOneAd_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        int temp = padelBuddy.getGames().size();
        padelBuddy.removeAd(padelBuddy.getGames().get(temp - 1));
        assertTrue(padelBuddy.getGames().get(temp - 2).getPlayers() != null);
    }

    @Test
    public void getAvailableGames_CreateOneAdTwoGames_ReturnsTrue() {
        padelBuddy.createAd("hej", new Date(), "90");
        // padelBuddy.createAd()
        padelBuddy.getGames().add(game1);
        padelBuddy.getGames().add(game2);
        System.out.println(padelBuddy.getGames().size());
        System.out.println(padelBuddy.getAvailableGames().size());
        assertTrue(padelBuddy.getAvailableGames().size() == 2);
    }

    @Test
    public void getAvailableGames_CreateTwoAds_ReturnsTrue() {
        padelBuddy.createAd("hej", new Date(), "90");
        padelBuddy.createAd("tjo", new Date(), "90");
        System.out.println(padelBuddy.getGames().size());
        System.out.println(padelBuddy.getAvailableGames().size());
        assertTrue(padelBuddy.getGames().size() == 2);
        assertTrue(padelBuddy.getAvailableGames().size() == 0);

    }

    @Test
    public void getAvailableGames_CreateOneGame_ReturnsTrue() {
    padelBuddy.getGames().add(game1);
        assertTrue(padelBuddy.getGames().size() == 1);
        assertTrue(padelBuddy.getAvailableGames().size() == 1);
    }
}