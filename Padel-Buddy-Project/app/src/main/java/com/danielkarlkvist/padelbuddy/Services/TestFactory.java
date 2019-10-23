package com.danielkarlkvist.padelbuddy.Services;


import android.content.Context;
import android.graphics.BitmapFactory;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;
import com.danielkarlkvist.padelbuddy.UI.PlayerImageBinder;


public class TestFactory {
    //private static TestFactory testFactory;
    private static IPlayer user;

    private TestFactory() {

    }

    public static IPlayer setCurrentUser(int i, Context context) {
        switch (i) {
            case 1:
                user = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 1);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.blom));
                break;
            case 2:
                user = new Player("Robin", "Axelsson", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 3);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.loket));
                break;
            case 3:
                user = new Player("Marcus", "Repo Weckaluf", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 2);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.linda));
                break;
            default:
                user = new Player("Fredrik", "Björnsson", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 2);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.mikael));
        }
        return user;
    }

    public static void createTestGames(PadelBuddy padelBuddy, Context context) {
        TestDataGames testDataGames = new TestDataGames();
        testDataGames.createTestGames(padelBuddy, context);
    }

}
