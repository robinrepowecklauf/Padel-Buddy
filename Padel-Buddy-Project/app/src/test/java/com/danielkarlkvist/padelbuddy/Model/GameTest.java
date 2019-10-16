package com.danielkarlkvist.padelbuddy.Model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class GameTest {

        @Test
        public void addPlayer_onePlayerIsAdded_ReturnsTrue() {
            Player player1 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Avancerad);
            Player player2 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Nybörjare);
            Game game = new Game(player1, "Gltk", new Date(2019, 11, 05));
            game.addPlayer(player2);
            IPlayer[] players = game.getPlayers();
            assertTrue(players[0].getFirstname()=="Fredrik");
            assertTrue(players[1].getFirstname()=="Axel");
            assertTrue(players[2]==null);
            assertTrue(players[3]==null);
        }

    @Test
    public void GetAverageSkillevel_averageiscorrect_ReturnsTrue(){
        Player player1 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Medel);


        Player player2 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Medel);
        Player player3 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Nybörjare);
        Player player4 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Nybörjare);
        Game game1 = new Game(player1, "Gltk", new Date(2019, 11, 05));
        game1.addPlayer(player2);
        game1.addPlayer(player3);
        game1.addPlayer(player4);

        Player player5 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Medel);
        Player player6 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Medel);
        Player player7 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Medel);
        Game game2 = new Game(player1, "Gltk", new Date(2019, 11, 05));

        game2.addPlayer(player5);
        game2.addPlayer(player6);
        game2.addPlayer(player7);

        Player player10 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Avancerad);
        Player player11 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Avancerad);
        Player player12 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Avancerad);
        Game game3 = new Game(player1, "Gltk", new Date(2019, 11, 05));


        game3.addPlayer(player10);
        game3.addPlayer(player11);
        game3.addPlayer(player12);


        Player player13 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Nybörjare);
        Player player14 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Nybörjare);
        Player player15 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Nybörjare);
        Game game4 = new Game(player1, "Gltk", new Date(2019, 11, 05));


        game4.addPlayer(player13);
        game4.addPlayer(player14);
        game4.addPlayer(player15);

        assertTrue(game1.getAverageSkillLevel()=="Medel");
        assertTrue(game2.getAverageSkillLevel()=="Medel");
        assertTrue(game3.getAverageSkillLevel()=="Avancerad");
        assertTrue(game4.getAverageSkillLevel()=="Nybörjare");

    }
    public void isFinishedGame_gameisfinished_ReturnsTrue() {
        Player player1 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Medel);
        Game game1 = new Game(player1, "Gltk", new Date(2019, 11, 05));
        game1.setResult(3,2);

        Player player2 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, SkillLevel.Medel);
        Game game2 = new Game(player2, "Gltk", new Date(2019, 11, 05));

        assertTrue(game1.isFinishedGame());
        assertTrue(!game2.isFinishedGame());
    }


    }

