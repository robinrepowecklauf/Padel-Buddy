package com.danielkarlkvist.padelbuddy.Model;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class GameTest {


    @Test
    public void addPlayer_onePlayerIsAdded_ReturnsTrue() {
        Player player1 = new Player("Fredrik", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 5);
        Player player2 = new Player("Axel", "Axelsson", "test@gmail.com", "123", "lorem ", 14, 5);
        Game game = new Game(player1, "Gltk", new Date(2019, 11, 05));
        game.addPlayer(player2);
        Player[] players = game.getPlayers();
        assertTrue(players[0].getFirstname()=="Fredrik");
        assertTrue(players[1].getFirstname()=="Axel");
        assertTrue(players[2]==null);
        assertTrue(players[3]==null);
    }

}