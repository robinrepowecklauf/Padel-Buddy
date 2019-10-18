package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

public class PadelGame extends Game {

    PadelGame(IPlayer player, String location, Date date, String gameLength){super(player, 4, location, date, gameLength);}
}
