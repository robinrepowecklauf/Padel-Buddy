package com.danielkarlkvist.padelbuddy.Model;

/**
 * The PlayerFactory class is a factory and facade to create a Player outside of the Model package
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public class PlayerFactory {

    private PlayerFactory() {

    }

    /**
     * Creates and returns an IPlayer based on the parameters
     *
     * @param firstName
     * @param lastName
     * @param mail
     * @param biography
     * @param age
     * @param skillLevel
     * @return Returns an IPlayer based on the parameters
     */
    public static IPlayer createPlayer(String firstName, String lastName, String mail, String biography, int age, double skillLevel) {
        return new Player(firstName, lastName, mail, biography, age, skillLevel);
    }
}
