package com.danielkarlkvist.padelbuddy.Services;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;

import java.util.List;

public interface ITestData {

    void createTestGame(PadelBuddy padelBuddy);

    List createTestPlayer();
}
