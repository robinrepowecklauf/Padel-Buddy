package com.danielkarlkvist.padelbuddy.Services;


import android.content.Context;
import android.graphics.BitmapFactory;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.Model.SkillLevel;
import com.danielkarlkvist.padelbuddy.R;
import com.danielkarlkvist.padelbuddy.UI.PlayerImageBinder;

import java.io.File;


public class TestFactory {
    private static TestFactory testFactory;
    private static IPlayer user;
    private static PadelBuddy padelBuddy;
    private static Context mContext;

    private TestFactory() {

    }

    public static PadelBuddy getPadelBuddy() {
        return padelBuddy;
    }

    public static void setCurrentUser(int i) {
        switch (i) {
            case 1:
                user = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.blom));
                break;
            case 2:
                user = new Player("Robin", "Axelsson", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.loket));
                break;
            case 3:
                user = new Player("Marcus", "Repo Weckaluf", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.linda));
                break;
            default:
                user = new Player("Fredrik", "Björnsson", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(mContext.getResources(), R.drawable.mikael));
        }
    }


    public static void initialize(Context context) {
        padelBuddy = new PadelBuddy(user);
        mContext = context;
    }

    public static void createTestGames() {
        TestDataGames testDataGames = new TestDataGames();
        testDataGames.createTestGames(padelBuddy, mContext);
    }

}
