package com.danielkarlkvist.padelbuddy.Model;

import de.hdodenhof.circleimageview.CircleImageView;

public interface IPlayer {

    String getFirstname();

    String getLastname();

    String getFullName();

    String getBio();

    void setFirstname(String firstname);

    void setLastname(String lastname);

    void setBio(String bio);

    int getGamesPlayed();

    float getProfileRating();

    double getSkillLevel();

}
