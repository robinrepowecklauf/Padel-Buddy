package com.danielkarlkvist.padelbuddy.Services;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;
import com.danielkarlkvist.padelbuddy.UI.PlayerImageBinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The TestDataGames class defines TODO ...
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
class TestDataGames implements ITestData {
    private Random rand = new Random();
    private List<IPlayer> players = new ArrayList<>();
    private List<String> locations = new ArrayList<>();
    private Context context;

    private final int amountOfTimeLengths = 2;  // TODO create local variable

    private IPlayer getRandomPlayer() {
        int random = rand.nextInt(players.size());

        return players.get(random);
    }

    private String getRandomLocation() {
        int random = rand.nextInt(locations.size());

        return locations.get(random);
    }

    private Date getRandomDate() {
        Date gameDate = new Date(119, rand.nextInt(12), rand.nextInt(31), rand.nextInt(24), rand.nextInt(61));

        return gameDate;
    }

    private String getRandomTimeLength() {
        int random = rand.nextInt(amountOfTimeLengths);

        if (random == 0) {
            return "60 min";
        }

        return "90 min";
    }

    @Override
    public void createTestGames(PadelBuddy padelBuddy, Context context) {
        this.context = context;

        createTestPlayers();
        createTestLocations();

        for (int i = 0; i < 200; i++) {
            padelBuddy.createAd(getRandomLocation(), getRandomDate(), getRandomTimeLength());
            IPlayer[] players = padelBuddy.getGames().get(i).getPlayers();
            players[0] = null;
        }

        for (int i = 0; i < 20; i++) {
            padelBuddy.createAd(getRandomLocation(), getRandomDate(), getRandomTimeLength());
        }

        for (int i = 0; i < padelBuddy.getGames().size(); i++) {
            int bound = padelBuddy.getGames().get(i).getPlayers().length;

            int randomAmountOfPlayersInGame;
            if (padelBuddy.getGames().get(i).getPlayers()[0] != null) {
                randomAmountOfPlayersInGame = rand.nextInt(bound);
            } else {
                randomAmountOfPlayersInGame = rand.nextInt(bound) + 1;
            }

            IPlayer[] removedPlayers = new Player[randomAmountOfPlayersInGame];

            for (int j = 0; j < randomAmountOfPlayersInGame; j++) {
                IPlayer player = getRandomPlayer();

                players.remove(player);
                removedPlayers[j] = player;

                padelBuddy.getGames().get(i).addPlayer(player);
            }

            addToPlayers(removedPlayers);
        }
    }

    private void createTestPlayers() {
        Player player = new Player("Robin", "Repo Wecklauf", "robinrepowecklauf@gmail.com", "0704549972", "lorem ipsum", 12, 2);
        bindPlayerImage(player, R.drawable.loket);
        players.add(player);

        player = new Player("Daniel", "Karlkvist", "gmail@danielkarlkvist.com", "0704529972", "lorem ipsum dipsum dolores sit amet", 20, 2);
        bindPlayerImage(player, R.drawable.profile_picture);
        players.add(player);

        player = new Player("Carl-Johan", "Björnson", "calleballe@live.se", "1", "lorem ", 35, 1);
        bindPlayerImage(player, R.drawable.profile_picture);
        players.add(player);

        player = new Player("Marcus", "Creutz", "test@gail.com", "2", "lorem ", 99, 1);
        bindPlayerImage(player, R.drawable.linda);
        players.add(player);

        player = new Player("Fredrik", "Axelsson", "emailrandomizer@fredrik.com", "3", "lorem ", 77, 3);
        bindPlayerImage(player, R.drawable.mikael);
        players.add(player);

        player = new Player("Johan", "Karlsson", "anotheremail@hello.com", "3", "lorem ", 1010, 2);
        bindPlayerImage(player, R.drawable.mikael);
        players.add(player);

        player = new Player("Björne", "Innebandysson", "sdkljjsdklskss@gmail.com", "3", "lorem ", 1, 3);
        bindPlayerImage(player, R.drawable.innebandysson);
        players.add(player);

        player = new Player("Repo", "Weckrobin", "tet@jsjsjsjsjsjs.com", "3", "lorem ", 1 + 2, 3);
        bindPlayerImage(player, R.drawable.linda);
        players.add(player);

        player = new Player("Mac", "Ish", "ttetetetetet@gmail.com", "3", "lorem ", 3 + 4, 1);
        bindPlayerImage(player, R.drawable.loket);
        players.add(player);

        player = new Player("Danne", "Fantom", "tet@gmail.com", "3", "lorem ", 5, 2);
        bindPlayerImage(player, R.drawable.profile_picture);
        players.add(player);

        player = new Player("Gammel", "Kröken", "teteessadsad@gmail.com", "3", "lorem ", 55, 3);
        bindPlayerImage(player, R.drawable.linda);
        players.add(player);

        player = new Player("Ettganska", "LångtnamnxDDD", "sssssssssssssss@gmail.com", "3", "lorem ", 555, 3);
        bindPlayerImage(player, R.drawable.blom);
        players.add(player);

        player = new Player("Åsa-Nisse", "Nisse-Åsa", "s@b.com", "3", "lorem ", 12, 2);
        bindPlayerImage(player, R.drawable.blom);
        players.add(player);

        player = new Player("Krokodil", "Flakdärbak", "full@patet.com", "3", "lorem ", 12, 3);
        bindPlayerImage(player, R.drawable.krokodil);
        players.add(player);
    }

    private void bindPlayerImage(IPlayer player, int image) {
        PlayerImageBinder.bind(player, BitmapFactory.decodeResource(context.getResources(), image));
    }

    private void createTestLocations() {
        locations.add("Padel center");
        locations.add("PDL Trollhättan");
        locations.add("PDL Göteborg");
        locations.add("GLTK Tennisklubb");
        locations.add("Padelfabriken");
        locations.add("Padel mästarna");
        locations.add("Padel pros");
        locations.add("Pro padels");
        locations.add("Björnes innepadelklubb");
    }

    private void addToPlayers(IPlayer[] removedPlayers) {
        for (IPlayer player : removedPlayers) {
            players.add(player);    // TODO replace with addAll
        }
    }
}