package com.danielkarlkvist.padelbuddy.Model;

class User {
    private String username;
    private String password;
    private Profile profile;
    private GameAd gameAd;


    private void createAd() {
        gameAd = new GameAd();
    }

    private void acceptAd() {

    }
}
