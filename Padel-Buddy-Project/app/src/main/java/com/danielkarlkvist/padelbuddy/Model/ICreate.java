package com.danielkarlkvist.padelbuddy.Model;

import java.util.Date;

public interface ICreate {

    void createAd(String location, Date date, String length);

    IPlayer getPlayer();
}
