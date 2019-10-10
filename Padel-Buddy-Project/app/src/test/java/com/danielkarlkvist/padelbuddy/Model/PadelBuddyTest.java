package com.danielkarlkvist.padelbuddy.Model;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import javax.crypto.BadPaddingException;

import static org.junit.Assert.*;

public class PadelBuddyTest {

    private PadelBuddy padelBuddy;


    @Test
    public void createAd_GameExist_ReturnsTrue() {
        padelBuddy = PadelBuddy.getInstance();
        int temp = padelBuddy.getGames().size();
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12));
        assertTrue(padelBuddy.getGames().size() == temp+1);
    }
    @Test
    public void createAd_PlayerExist_ReturnsTrue() {
        padelBuddy = PadelBuddy.getInstance();
        padelBuddy.createAd("Göteborg", new Date(2019, 11, 12));
        assertTrue(padelBuddy.getGames().get(padelBuddy.getGames().size()-1).hasPlayer());
    }

}