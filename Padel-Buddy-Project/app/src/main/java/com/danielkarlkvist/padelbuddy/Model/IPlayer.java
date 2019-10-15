package com.danielkarlkvist.padelbuddy.Model;

import de.hdodenhof.circleimageview.CircleImageView;

public interface IPlayer {
    String getFirstname();

    String getLastname();

    String getFullName();
    void setFirstname(String firstname);

    void setLastname(String lastname);

    String getBio();

    void setBio(String bio);

    float getProfileRating();

    int getGamesPlayed();
    void setImage(CircleImageView image);

    SkillLevel getSkillLevel();
    CircleImageView getImage();
}
