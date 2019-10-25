package com.danielkarlkvist.padelbuddy.Model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class GameTest {

    private IPlayer badplayer1 = PlayerFactory.createPlayer("Fredrik", "Axelsson", "test@gmail.com", "lorem ", 14, 1);
    private IPlayer badplayer2 = PlayerFactory.createPlayer("Axel", "Axelsson", "test@gmail.com", "lorem ", 14, 1);
    private IPlayer badplayer3 = PlayerFactory.createPlayer("Marcus", "Axelsson", "test@gmail.com", "lorem ", 14, 1);
    private IPlayer medelplayer2 = PlayerFactory.createPlayer("Carl", "Axelsson", "test@gmail.com", "lorem ", 14, 2);
    private IPlayer medelplayer3 = PlayerFactory.createPlayer("Daniel", "Axelsson", "test@gmail.com", "lorem ", 14, 2);
    private IPlayer advancedplayer5 = PlayerFactory.createPlayer("Fredrik", "Axelsson", "test@gmail.com", "lorem ", 14, 3);
    private IPlayer advancedplayer6 = PlayerFactory.createPlayer("Axel", "Axelsson", "test@gmail.com", "lorem ", 14, 3);
    private IPlayer advancedplayer7 = PlayerFactory.createPlayer("Axel", "Axelsson", "test@gmail.com", "lorem ", 14, 3);
    private IPlayer defaultplayer = PlayerFactory.createPlayer("Axel", "Axelsson", "test@gmail.com", "lorem ", 14, 10);

    private IGame game = new PadelGame(badplayer1, "Gltk", new Date(2019, 11, 05), "90");

    @Test
    public void addPlayer_OnePlayerIsAdded_ReturnsTrue() {
        game.addPlayer(badplayer2);
        IPlayer[] players = game.getPlayers();
        assertNotNull(players[0]);
        assertNotNull(players[1]);
        assertNull(players[2]);
        assertNull(players[3]);
        assertEquals(players[1], badplayer2);
    }

    /**
     * Fredrik creates the game and is therefore on index zero
     */
    @Test
    public void addPlayer_GameIsFull_ReturnsTrue() {
        game.addPlayer(badplayer2);//Axel
        game.addPlayer(badplayer3);//Marcus
        game.addPlayer(medelplayer2);//Carl
        game.addPlayer(medelplayer3); //Daniel
        IPlayer[] players = game.getPlayers();
        assertNotNull(players[0]);
        assertNotNull(players[1]);
        assertNotNull(players[2]);
        assertNotNull(players[3]);
    }

    @Test
    public void getAverageSkillLevel_GameWithOneSkillLevel_ReturnsTrue() {
        assertTrue(game.getAverageSkillLevel() == "Nybörjare");
    }

    @Test
    public void getAverageSkillLevel_ThreeOfSame_ReturnsTrue() {
        game.addPlayer(badplayer2);
        game.addPlayer(badplayer3);
        game.addPlayer(medelplayer2);
        assertTrue(game.getAverageSkillLevel() == "Nybörjare");
    }

    @Test
    public void getAverageSkillLevel_TwoOfEach_ReturnsTrue() {
        game.addPlayer(badplayer2);
        game.addPlayer(medelplayer2);
        game.addPlayer(medelplayer3);
        assertTrue(game.getAverageSkillLevel() == "Medel");
    }

    @Test
    public void getAverageSkillLevel_TwoAdvancedAndTwoBad_ReturnsTrue() {
        game.addPlayer(badplayer2);
        game.addPlayer(advancedplayer5);
        game.addPlayer(advancedplayer6);
        assertTrue(game.getAverageSkillLevel() == "Medel");
    }

    @Test
    public void getAverageSkillLevel_ThreeAdvancedAndOneBad_ReturnsTrue() {
        game.addPlayer(advancedplayer7);
        game.addPlayer(advancedplayer5);
        game.addPlayer(advancedplayer6);
        assertTrue(game.getAverageSkillLevel() == "Avancerad");
    }

    @Test
    public void getAverageSkillLevel_OneDefault_ReturnsTrue() {
        game.addPlayer(defaultplayer);
        game.addPlayer(badplayer1);
        game.addPlayer(badplayer3);
        assertTrue(game.getAverageSkillLevel() == "Medel");
    }

    @Test
    public void isFinishedGame_GameIsFinished_ReturnsTrue() {
        IPlayer player1 = PlayerFactory.createPlayer("Fredrik", "Axelsson", "test@gmail.com", "lorem ", 14, 2);
        IGame game1 = new PadelGame(player1, "Gltk", new Date(2019, 11, 05), "90");
        game1.setResult(3, 2);
        assertTrue(game1.isFinishedGame());
    }

    @Test
    public void isFinishedGame_GameIsNotFinished_ReturnsFalse() {
        IPlayer player2 = PlayerFactory.createPlayer("Fredrik", "Axelsson", "test@gmail.com", "lorem ", 14, 2);
        IGame game2 = new PadelGame(player2, "Gltk", new Date(2019, 11, 05), "90");
        assertFalse(game2.isFinishedGame());
    }

    @Test
    public void getDateAsString_CorrectOutput_ReturnsTrue() {
        IPlayer player1 = PlayerFactory.createPlayer("Marcus", "Axelsson", "marcus@gmail.se", "Hej hopp", 20, 2.0);
        IGame game1 = new PadelGame(player1, "Gltk", new Date(119, 10, 5, 12, 58), "90");
        String s = game1.getDateAsString();
        assertEquals(s, "05 Nov 12:58");
    }
}




