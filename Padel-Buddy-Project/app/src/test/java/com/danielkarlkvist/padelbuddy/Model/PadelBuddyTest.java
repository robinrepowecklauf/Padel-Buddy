package com.danielkarlkvist.padelbuddy.Model;

import org.junit.Test;

import java.util.Date;
import java.util.List;


import static org.junit.Assert.*;

public class PadelBuddyTest {

    private PadelBuddy padelBuddy = new PadelBuddy(new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 2));
    private IPlayer badplayer1 = PlayerFactory.createPlayer("Fredrik", "Axelsson", "test@gmail.com", "lorem ", 14, 1);
    private IPlayer badplayer2 = PlayerFactory.createPlayer("Fredrik", "Axelsson", "test@gmail.com", "lorem ", 14, 1);
    private IGame game1 = new PadelGame(badplayer1, "Gltk", new Date(2019, 11, 05), "60");
    private IGame game2 = new PadelGame(badplayer1, "Gltk", new Date(2019, 11, 05), "60");

    List<IGame> games = padelBuddy.getGames();


    @Test
    public void createAd_GameExist_ReturnsTrue() {
        int temp = games.size();
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
    public void getAvailableGames_CreateOeAdTwoGames_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).addPlayer(badplayer2);

        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(1).getPlayers()[0] = null;


        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");

        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        assertTrue(padelBuddy.getJoinableGames().size() == 2);
    }

    @Test
    public void getAvailableGames_CreateTwoAds_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        assertTrue(padelBuddy.getGames().size() == 2);
        assertTrue(padelBuddy.getJoinableGames().size() == 0);

    }

    @Test
    public void getAvailableGames_CreateOneGame_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).addPlayer(badplayer2);
        System.out.println(padelBuddy.getGames().size());
        assertTrue(padelBuddy.getJoinableGames().size() == 1);
    }

    @Test
    public void getUpcomingGames_OneExists_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(119, 11, 30, 15, 30), "90");
        List<IGame> upcomingGames = padelBuddy.getUpcomingGames();
        assertNotNull(upcomingGames.get(0));
        assertSame(upcomingGames.get(0), padelBuddy.getGames().get(0));
    }


    @Test
    public void JoinGame_UserisInUpcomingGame_ReturnsTrue() {
       // games.add(game1);
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.joinGame( padelBuddy.getGames().get(0));
        assertTrue(padelBuddy.getUpcomingGames().contains( padelBuddy.getGames().get(0)));
    }

    @Test
    public void JoinGame_GameTurnsUnavailable_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        assertTrue(padelBuddy.getJoinableGames().contains(padelBuddy.getGames().get(0)));
        padelBuddy.joinGame(game1);
        assertTrue(!padelBuddy.getJoinableGames().contains(game1));
    }

    @Test
    public void JoinGame_playerAlreadyinGame_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;        padelBuddy.joinGame(game1);
        padelBuddy.joinGame(padelBuddy.getGames().get(0));
        padelBuddy.joinGame(padelBuddy.getGames().get(0));

        assertTrue(game1.getPlayers()[1] != game1.getPlayers()[2]);

    }

    @Test
    public void JoinGame_playerUserIsInGame_ReturnsTrue() {
        games.add(game1);
        padelBuddy.joinGame(game1);
        assertTrue(game1.getPlayers()[1].getFirstName() == padelBuddy.getUser().getFirstName());

    }


    @Test
    public void LeaveGame_GameTurnsAvailable_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(119, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).getPlayers()[0] = badplayer1;
        padelBuddy.joinGame(padelBuddy.getGames().get(0));
        padelBuddy.leaveGame(padelBuddy.getGames().get(0));
        assertTrue(padelBuddy.getJoinableGames().contains(padelBuddy.getGames().get(0)));

    }

    @Test
    public void LeaveGame_playerIsNotInTheGame_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(119, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).getPlayers()[1] = badplayer1;
        padelBuddy.leaveGame(padelBuddy.getGames().get(0));
        assertTrue(padelBuddy.getJoinableGames().contains(padelBuddy.getGames().get(0)));

    }

    @Test
    public void GetPlayedGames_GameHasaResultbutNoDate_ReturnsTrue() {
        games.add(game1);
        padelBuddy.joinGame(game1);
        game1.setResult(2, 4);
        assertTrue(!(padelBuddy.getPlayedGames().contains(game1)));
    }

    @Test
    public void GetPlayedGames_HasResultAndNoUser_ReturnsTrue() {
        games.add(game1);
        game1.setResult(2, 4);
        assertTrue(!(padelBuddy.getPlayedGames().contains(game1)));
    }

    @Test
    public void GetPlayedGames_HasUserButNoResult_ReturnsTrue() {
        games.add(game1);
        padelBuddy.joinGame(game1);
        assertTrue(!(padelBuddy.getPlayedGames().contains(game1)));
    }

    @Test
    public void GetPlayedGames_HasResultUserValidDate_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(118, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.joinGame(padelBuddy.getGames().get(0));
        padelBuddy.getGames().get(0).setResult(2, 4);
        System.out.println(padelBuddy.getPlayedGames().size());
        assertTrue((padelBuddy.getPlayedGames().contains(padelBuddy.getGames().get(0))));
    }
}