package com.danielkarlkvist.padelbuddy.Model;

/**
 * The IPlayer interface defines the methods that should be able to run of a Player outside of the Model
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

    float getProfileRating();

    double getSkillLevel();

    void setSkillLevel(double skillLevel);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setBiography(String biography);
}
