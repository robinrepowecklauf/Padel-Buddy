package com.danielkarlkvist.padelbuddy.Model;

/**
 * The IGame interface defines TODO ...
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public interface IPlayer {

    String getFirstName();

    String getLastName();

    String getFullName();

    String getBiography();

    int getGamesPlayed();

    float getProfileRating();

    double getSkillLevel();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setBiography(String biography);
}
