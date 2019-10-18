package com.danielkarlkvist.padelbuddy.Services;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.Model.SkillLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

class TestDataGames implements ITestData {

    private Random rand = new Random();
    private List<IPlayer> players = new ArrayList<>();

    @Override
    public void createTestGames(PadelBuddy padelBuddy) {

        for (int i = 0; i < 15; i++) {
            padelBuddy.createAd("Padel center gbg", new Date(2019, rand.nextInt(12), rand.nextInt(31), rand.nextInt(24), rand.nextInt(61)), "10år");
        }

        createTestPlayers();

        for (int j = 0; j < padelBuddy.getGames().size(); j++) {
            for (int i = 0; i < 2; i++) {
                List<IPlayer> players = Arrays.asList(padelBuddy.getGames().get(j).getPlayers());
                int random = rand.nextInt(4);
                while (players.contains(this.players.get(random))) {
                    random = rand.nextInt(4);
                }
                padelBuddy.getGames().get(j).addPlayer(this.players.get(random));
            }
        }
    }

    private void createTestPlayers() {
        players.add(new Player("Robin", "Repo Wecklauf", "robinrepowecklauf@gmail.com", "0704549972", "lorem ipsum", 15, SkillLevel.Avancerad));
        players.add(new Player("Carl-Johan", "Björnson", "tes@gmail.com", "1", "lorem ", 14, SkillLevel.Medel));
        players.add(new Player("Marcus", "Creutz", "test@gail.com", "2", "lorem ", 13, SkillLevel.Nybörjare));
        players.add(new Player("Fredrik", "Axelsson", "tet@gmail.com", "3", "lorem ", 12, SkillLevel.Avancerad));
    }
}
