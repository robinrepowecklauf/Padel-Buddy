package com.danielkarlkvist.padelbuddy.Services;

import android.content.Context;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;

/**
 * The ITestData interface defines the contract to create test games
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
interface ITestData {

    /**
     * Creates randomized hard coded test games
     *
     * @param padelBuddy
     * @param context
     */
    void createTestGames(PadelBuddy padelBuddy, Context context);
}
