package com.danielkarlkvist.padelbuddy.Services;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.PlayerFactory;
import com.danielkarlkvist.padelbuddy.R;
import com.danielkarlkvist.padelbuddy.UI.PlayerImageBinder;

/**
 * The TestFactory class is the entry from outside of the model to create randomized hard coded games and players
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public class TestFactory {

    private TestFactory() {

    }

    /**
     * Creates and gets the user at the specified int value
     *
     * @param i
     * @param context
     * @return
     */
    public static IPlayer getUser(int i, Context context) {
        IPlayer user;

        switch (i) {
            case 1:
                user = PlayerFactory.createPlayer("Daniel", "Karlkvist", "danielkarlkvist@gmail.com", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore", 20, 1);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.blom));
                break;
            case 2:
                user = PlayerFactory.createPlayer("Robin", "Axelsson", "robin@gmail.com", "Grabbarna som skapat Padel Buddy borde få en 5:a i betyg mvh Robin repo wecklauf, inte Daniel", 20, 3);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.loket));
                break;
            case 3:
                user = PlayerFactory.createPlayer("Marcus", "Repo Weckaluf", "weklauf@gmail.com", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut ", 20, 2);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.linda));
                break;
            default:
                user = PlayerFactory.createPlayer("Fredrik", "Björnsson", "innebandy@gmail.com", "Bla bla bla jflkhadfbjkldasjkbfbabfabdfjsdaf", 20, 2);
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(context.getResources(), R.drawable.mikael));
        }

        return user;
    }

    public static void createTestGames(PadelBuddy padelBuddy, Context context) {
        TestDataGames testDataGames = new TestDataGames();
        testDataGames.createTestGames(padelBuddy, context);
    }
}
