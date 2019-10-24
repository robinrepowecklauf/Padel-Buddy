package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

/**
 * The PadelGame class holds values and methods which represents a padel game
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
class PadelGame extends Game {

    PadelGame(IPlayer player, String location, Date date, String gameLength) {
        super(player, 4, location, date, gameLength);
    }
}
