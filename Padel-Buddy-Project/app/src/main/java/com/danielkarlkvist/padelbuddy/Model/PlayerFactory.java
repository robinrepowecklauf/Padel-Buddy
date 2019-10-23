package com.danielkarlkvist.padelbuddy.Model;

/**
 * The PlayerFactory class defines TODO ...
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public class PlayerFactory {

    private PlayerFactory() {

    }
    
    public static IPlayer createPlayer(String firstName, String lastName, String mail, String biography, int age, double skillLevel) {
        return new Player(firstName, lastName, mail, biography, age, skillLevel);
    }
}
