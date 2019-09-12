package com.danielkarlkvist.padelbuddy.Model;

import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String password;
    private Profile profile;
    private List<GameAd> gameAds = new ArrayList<>();
    private int amountOfPublishedAds;

    private void createAd() {
        GameAd newGameAd = new GameAd();
        
        gameAds.add(newGameAd);
    }

    private void acceptAd() {

    }
}