package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

/**
 * The ICreate interface is implemented by PadelBuddy and used to remove unnecessary
 * functionality for classes which should only be able to create an ad
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public interface ICreate {

    /**
     * @return Returns the user of the app
     */
    IPlayer getUser();

    /**
     * Used to create a Game and add it to the list in PadelBuddy
     *
     * @param location
     * @param date
     * @param length
     */
    void createAd(String location, Date date, String length);
}
