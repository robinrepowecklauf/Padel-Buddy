package com.danielkarlkvist.padelbuddy.Services;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.Model.SkillLevel;

import java.util.ArrayList;
import java.util.List;

class TestDataPlayers implements ITestData {

    List<IPlayer> players = new ArrayList<>();

    @Override
    public List<IPlayer> create() {
        players.add(new Player("Robin", "Repo Wecklauf", "robinrepowecklauf@gmail.com", "0704549972", "lorem ipsum", 15, SkillLevel.Avancerad));
        players.add(new Player("Carl-Johan", "Björnson", "tes@gmail.com", "1", "lorem ", 14, SkillLevel.Medel));
        players.add(new Player("Marcus", "Creutz", "test@gail.com", "2", "lorem ", 13, SkillLevel.Nybörjare));
        players.add(new Player("Fredrik", "Axelsson", "tet@gmail.com", "3", "lorem ", 12, SkillLevel.Avancerad));

        return players;
    }
}

