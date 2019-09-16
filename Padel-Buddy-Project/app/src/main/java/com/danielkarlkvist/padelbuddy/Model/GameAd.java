package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameAd {
    private Profile[] profiles = new Profile[4];
    private String description;
    private Date time;
    private double skillevel;

    public GameAd(Profile[] profiles, String description, Date time, double skillevel) {
        this.profiles = profiles;
        this.description = description;
        this.time = time;
        this.skillevel = skillevel;
    }
}
