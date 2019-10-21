package com.danielkarlkvist.padelbuddy.Model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class GameTest {

    private Player badplayer1 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 1);
    private Player badplayer2 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 1);
    private Player badplayer3 = new Player("Marcus", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 1);
    private Player medelplayer2 = new Player("Carl", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 2);
    private Player medelplayer3 = new Player("Daniel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 2);
    private Player advancedplayer5 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 3);
    private Player advancedplayer6 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 3);
    private Player advancedplayer7 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 3);
    private Player defaultplayer = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 10);


    private IGame game = new PadelGame(badplayer1, "Gltk", new Date(2019, 11, 05), "90");

    @Test
    public void addPlayer_onePlayerIsAdded_ReturnsTrue() {
        IGame game = new PadelGame(badplayer1, "Gltk", new Date(2019, 11, 05), "60");
        game.addPlayer(badplayer2);
        IPlayer[] players = game.getPlayers();
        assertTrue(players[0].getFirstname() == "Fredrik");
        assertTrue(players[1].getFirstname() == "Axel");
        assertTrue(players[2] == null);
        assertTrue(players[3] == null);
    }

    /**
     * Fredrik creates the game and is therefore on index zero
     */
    @Test
    public void addPlayer_gameIsFull_ReturnsTrue() {
        game.addPlayer(badplayer2);//Axel
        game.addPlayer(badplayer3);//Marcus
        game.addPlayer(medelplayer2);//Carl
        game.addPlayer(medelplayer3); //Daniel
        IPlayer[] players = game.getPlayers();
        assertTrue(players[0].getFirstname() == "Fredrik");
        assertTrue(players[1].getFirstname() == "Axel");
        assertTrue(players[2].getFirstname() == "Marcus");
        assertTrue(players[3].getFirstname() == "Carl");
    }


    @Test
    public void GetAverageSkillevel_gameWithOnePlayer_ReturnsTrue() {
        assertTrue(game.getAverageSkillLevel() == "Nybörjare");
    }

    @Test
    public void GetAverageSkillevel_threeOfSame_ReturnsTrue() {
        game.addPlayer(badplayer2);
        game.addPlayer(badplayer3);
        game.addPlayer(medelplayer2);
        assertTrue(game.getAverageSkillLevel() == "Nybörjare");
    }

    @Test
    public void GetAverageSkillevel_twoOfEach_ReturnsTrue() {
        game.addPlayer(badplayer2);
        game.addPlayer(medelplayer2);
        game.addPlayer(medelplayer3);
        assertTrue(game.getAverageSkillLevel() == "Medel");
    }

    @Test
    public void GetAverageSkillevel_twoAdvancedtwoBad_ReturnsTrue() {
        game.addPlayer(badplayer2);
        game.addPlayer(advancedplayer5);
        game.addPlayer(advancedplayer6);
        assertTrue(game.getAverageSkillLevel() == "Medel");
    }
    @Test
    public void GetAverageSkillevel_ThreeAdvancedOneBad_ReturnsTrue() {
        game.addPlayer(advancedplayer7);
        game.addPlayer(advancedplayer5);
        game.addPlayer(advancedplayer6);
        assertTrue(game.getAverageSkillLevel() == "Avancerad");
    }

    @Test
    public void GetAverageSkillevel_OneDefault_ReturnsTrue() {
        game.addPlayer(defaultplayer);
        game.addPlayer(badplayer1);
        game.addPlayer(badplayer3);
        System.out.println(game.getAverageSkillLevel());
        assertTrue(game.getAverageSkillLevel() == "Nybörjare");
    }

    @Test
    public void isFinishedGame_gameisfinished_ReturnsTrue() {
        Player player1 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 2);
        IGame game1 = new PadelGame(player1, "Gltk", new Date(2019, 11, 05), "90");
        game1.setResult(3, 2);
        assertTrue(game1.isFinishedGame());
    }


    @Test
    public void isFinishedGame_gameisnotfinished_ReturnsTrue() {
        Player player2 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 2);
        IGame game2 = new PadelGame(player2, "Gltk", new Date(2019, 11, 05), "90");
        assertTrue(!game2.isFinishedGame());
    }
}




