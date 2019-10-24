package com.danielkarlkvist.padelbuddy.Services;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.PlayerFactory;
import com.danielkarlkvist.padelbuddy.R;
import com.danielkarlkvist.padelbuddy.UI.PlayerImageBinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The TestDataGames class defines methods and values to create hard coded test games (& players)
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

            IPlayer[] removedPlayers = new IPlayer[randomAmountOfPlayersInGame];

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
        IPlayer player = PlayerFactory.createPlayer("Robin", "Repo Wecklauf", "robinrepowecklauf@gmail.com", "lorem ipsum", 12, 2);
        bindPlayerImage(player, R.drawable.loket);
        players.add(player);

        player = PlayerFactory.createPlayer("Daniel", "Karlkvist", "gmail@danielkarlkvist.com", "lorem ipsum dipsum dolores sit amet", 20, 2);
        bindPlayerImage(player, R.drawable.profile_picture);
        players.add(player);

        player = PlayerFactory.createPlayer("Carl-Johan", "Björnson", "calleballe@live.se", "lorem ", 35, 1);
        bindPlayerImage(player, R.drawable.profile_picture);
        players.add(player);

        player = PlayerFactory.createPlayer("Marcus", "Creutz", "test@gail.com", "lorem ", 99, 1);
        bindPlayerImage(player, R.drawable.linda);
        players.add(player);

        player = PlayerFactory.createPlayer("Fredrik", "Axelsson", "emailrandomizer@fredrik.com", "lorem ", 77, 3);
        bindPlayerImage(player, R.drawable.mikael);
        players.add(player);

        player = PlayerFactory.createPlayer("Johan", "Karlsson", "anotheremail@hello.com", "lorem ", 1010, 2);
        bindPlayerImage(player, R.drawable.mikael);
        players.add(player);

        player = PlayerFactory.createPlayer("Björne", "Innebandysson", "sdkljjsdklskss@gmail.com", "lorem ", 1, 3);
        bindPlayerImage(player, R.drawable.innebandysson);
        players.add(player);

        player = PlayerFactory.createPlayer("Repo", "Weckrobin", "tet@jsjsjsjsjsjs.com", "lorem ", 1 + 2, 3);
        bindPlayerImage(player, R.drawable.linda);
        players.add(player);

        player = PlayerFactory.createPlayer("Mac", "Ish", "ttetetetetet@gmail.com", "lorem ", 3 + 4, 1);
        bindPlayerImage(player, R.drawable.loket);
        players.add(player);

        player = PlayerFactory.createPlayer("Danne", "Fantom", "tet@gmail.com", "lorem ", 5, 2);
        bindPlayerImage(player, R.drawable.profile_picture);
        players.add(player);

        player = PlayerFactory.createPlayer("Gammel", "Kröken", "teteessadsad@gmail.com", "lorem ", 55, 3);
        bindPlayerImage(player, R.drawable.linda);
        players.add(player);

        player = PlayerFactory.createPlayer("Ettganska", "LångtnamnxDDD", "sssssssssssssss@gmail.com", "lorem ", 555, 3);
        bindPlayerImage(player, R.drawable.blom);
        players.add(player);

        player = PlayerFactory.createPlayer("Åsa-Nisse", "Nisse-Åsa", "s@b.com", "lorem ", 12, 2);
        bindPlayerImage(player, R.drawable.blom);
        players.add(player);

        player = PlayerFactory.createPlayer("Krokodil", "Flakdärbak", "full@patet.com", "lorem ", 12, 3);
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