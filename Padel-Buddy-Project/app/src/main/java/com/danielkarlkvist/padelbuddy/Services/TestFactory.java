package com.danielkarlkvist.padelbuddy.Services;


import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.Model.SkillLevel;


public class TestFactory {


    private static IPlayer user;
    private static PadelBuddy padelBuddy;

    public static void setCurrentUser(int i) {
        switch (i) {
            case 1:
                user = new Player("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
                break;
            case 2:
                user = new Player("Marcus", "Axelsson", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
                break;
            case 3:
                user = new Player("Robin", "Repo Weckaluf", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
                break;
        default:
            user = new Player("Fredrik", "Björnsson", "danielkarlkvist@gmail.com", "0701234567", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, SkillLevel.Nybörjare);
        }
    }

    private TestFactory() {

    }

    public static PadelBuddy getPadelBuddy() {
        return padelBuddy;
    }

    public static void createPadelBuddy() {
        padelBuddy = new PadelBuddy(user);
    }

    public static void createTestGames() {
        TestDataGames testDataGames = new TestDataGames();
        testDataGames.createTestGame(padelBuddy);
    }

    public static IPlayer getCurrentUser() {
        return user;
    }
}
