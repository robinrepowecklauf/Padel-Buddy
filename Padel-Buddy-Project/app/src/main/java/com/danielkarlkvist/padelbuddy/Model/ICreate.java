package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

/**
 * The ICreate interface defines TODO björne knows
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public interface ICreate {

    IPlayer getUser();

    void createAd(String location, Date date, String length);
}
