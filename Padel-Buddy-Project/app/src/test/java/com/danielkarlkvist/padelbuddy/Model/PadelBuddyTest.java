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

    private List<IGame> games = padelBuddy.getGames();

    @Test
    public void createAd_GameExist_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        assertNotNull(padelBuddy.getGames().get(0));
    }

    @Test
    public void createAd_PlayerExist_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        assertNotNull(padelBuddy.getGames().get(0).getPlayers()[0]);
    }

    @Test
    public void removeAd_GamesExist_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        padelBuddy.removeAd(padelBuddy.getGames().get(0));
        assertEquals(0, padelBuddy.getGames().size());
    }

    @Test
    public void removeAd_RemoveOneAd_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12), "90");
        padelBuddy.removeAd(padelBuddy.getGames().get(0));
        assertEquals(1, padelBuddy.getGames().size());
    }

    @Test
    public void getAvailableGames_TwoAvailableGamesToJoin_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");

        // Create games without the user
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).addPlayer(badplayer2);
        padelBuddy.getGames().get(1).getPlayers()[0] = null;

        // Create games with the user
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");

        assertTrue(padelBuddy.getJoinableGames().size() == 2);
    }

    @Test
    public void getAvailableGames_NonJoinableGames_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");

        assertEquals(2, padelBuddy.getGames().size());
        assertEquals(0, padelBuddy.getJoinableGames().size());
    }

    @Test
    public void getAvailableGames_JoinableGames_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).addPlayer(badplayer2);
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
    public void joinGame_UserIsInUpcomingGame_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.joinGame(padelBuddy.getGames().get(0));
        assertTrue(padelBuddy.getUpcomingGames().contains(padelBuddy.getGames().get(0)));
    }

    @Test
    public void joinGame_GameTurnsUnavailable_ReturnsFalse() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        assertTrue(padelBuddy.getJoinableGames().contains(padelBuddy.getGames().get(0)));
        padelBuddy.joinGame(game1);
        assertFalse(padelBuddy.getJoinableGames().contains(game1));
    }

    @Test
    public void joinGame_PlayerAlreadyInGame_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.joinGame(game1);
        padelBuddy.joinGame(padelBuddy.getGames().get(0));
        padelBuddy.joinGame(padelBuddy.getGames().get(0));

        assertTrue(game1.getPlayers()[1] != game1.getPlayers()[2]);
    }

    @Test
    public void joinGame_PlayerIsInGame_ReturnsTrue() {
        games.add(game1);
        padelBuddy.joinGame(game1);

        assertEquals(game1.getPlayers()[1], padelBuddy.getUser());
    }


    @Test
    public void leaveGame_GameTurnsAvailable_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(119, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).getPlayers()[0] = badplayer1;
        padelBuddy.joinGame(padelBuddy.getGames().get(0));
        padelBuddy.leaveGame(padelBuddy.getGames().get(0));
        assertTrue(padelBuddy.getJoinableGames().contains(padelBuddy.getGames().get(0)));

    }

    @Test
    public void leaveGame_PlayerIsNotInTheGame_ReturnsTrue() {
        padelBuddy.createAd("Göteborg", new Date(119, 11, 30), "90");
        padelBuddy.getGames().get(0).getPlayers()[0] = null;
        padelBuddy.getGames().get(0).getPlayers()[1] = badplayer1;
        padelBuddy.leaveGame(padelBuddy.getGames().get(0));
        assertTrue(padelBuddy.getJoinableGames().contains(padelBuddy.getGames().get(0)));

    }

    @Test
    public void getPlayedGames_GameHasResultButNoDate_ReturnsFalse() {
        games.add(game1);
        padelBuddy.joinGame(game1);
        game1.setResult(2, 4);
        assertFalse(padelBuddy.getPlayedGames().contains(game1));
    }

    @Test
    public void getPlayedGames_HasResultAndNoUser_ReturnsFalse() {
        games.add(game1);
        game1.setResult(2, 4);
        assertFalse(padelBuddy.getPlayedGames().contains(game1));
    }

    @Test
    public void getPlayedGames_HasUserButNoResult_ReturnsFalse() {
        games.add(game1);
        padelBuddy.joinGame(game1);
        assertFalse((padelBuddy.getPlayedGames().contains(game1)));
    }
}