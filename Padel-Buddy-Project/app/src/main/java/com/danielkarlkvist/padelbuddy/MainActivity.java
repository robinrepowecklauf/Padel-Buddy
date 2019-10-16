package com.danielkarlkvist.padelbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.danielkarlkvist.padelbuddy.Controller.CreateAdFragment;
import com.danielkarlkvist.padelbuddy.Controller.GamesFragment;
import com.danielkarlkvist.padelbuddy.Controller.GameRecyclerViewFragment;
import com.danielkarlkvist.padelbuddy.Controller.ProfileFragment;
import com.danielkarlkvist.padelbuddy.Controller.ITimePickerDialogListener;
import com.danielkarlkvist.padelbuddy.Model.Game;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ITimePickerDialogListener {

    /**
     * The MainActivity class is the base of the project.
     *
     * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
     * Carl-Johan Björnson och Fredrik Lilliecreutz
     * @version 1.0
     * @since 2019-09-05
     */

    // Has the tab controllers as instance variables so the waiting_for_player_picture always gets saved
    private GameRecyclerViewFragment homeFragmentController;
    private CreateAdFragment createAdFragment;
    private GamesFragment gamesFragment;
    private ProfileFragment profileFragment;
    private Fragment selectedFragmentController = null;

    private PadelBuddy padelBuddy;

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationViewListener =
            // region bottomNavigationViewListener
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            if (selectedFragmentController == homeFragmentController) {
                                homeFragmentController.scrollToTop();
                                break;
                            } else {
                                selectedFragmentController = homeFragmentController;
                                break;
                            }
                        case R.id.nav_create:
                            selectedFragmentController = createAdFragment;
                            break;
                        case R.id.nav_games:
                            if (selectedFragmentController == gamesFragment) {
                                gamesFragment.scrollToTop();
                                break;
                            } else {
                                selectedFragmentController = gamesFragment;
                                break;
                            }
                        case R.id.nav_profile:
                            selectedFragmentController = profileFragment;
                            break;
                        default:
                            Log.println(1, "tag", "Selected fragment that doesn't exist.");
                            selectedFragmentController = new GameRecyclerViewFragment(R.layout.fragment_home, R.id.home_recyclerview, padelBuddy.getGames());
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragmentController).commit();

                    return true;
                }
            };
    // endregion bottomNavigationViewListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  // Always portrait mode

        padelBuddy = new PadelBuddy();

        createRandomGames();

        initializeBottomNavigationViewControllers();
        initializeBottomNavigationView();
    }

    /**
     * Creates random games for showing purposes
     */
    private void createRandomGames() {
        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            padelBuddy.createAd("Padel center gbg", new Date(2019, rand.nextInt(12), rand.nextInt(31),rand.nextInt(24), rand.nextInt(61)),"60/90");
        }

        List<Game> testGames = padelBuddy.getGames();
        List<IPlayer> testPlayers = padelBuddy.testPlayers;

        for (int j = 0; j < testGames.size(); j++) {
            for (int i = 0; i < 2; i++) {
                List<IPlayer> players = Arrays.asList(testGames.get(j).getPlayers());
                int random = rand.nextInt(4);
                while (players.contains(testPlayers.get(random))) {
                    random = rand.nextInt(4);
                }
                testGames.get(j).addPlayer(testPlayers.get(random));
            }
        }
    }

    /**
     * Instantiates the main Fragments in the app
     */
    private void initializeBottomNavigationViewControllers() {
        homeFragmentController = new GameRecyclerViewFragment(R.layout.fragment_home, R.id.home_recyclerview, padelBuddy.getGames());
        createAdFragment = new CreateAdFragment(padelBuddy);
        gamesFragment = new GamesFragment(padelBuddy.getUpcomingGames(), padelBuddy.getPlayedGames());
        profileFragment = new ProfileFragment(padelBuddy.getPlayer());
    }

    /**
     * Instantiates the BottomNavigationView
     */
    private void initializeBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationViewListener);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);  // Sets the current selected tab as Home when the app opens
    }

    /**
     * Put the text in CreateAdFragment
     *
     * @param time   current time
     * @param length current length
     */
    @Override
    public void applyTexts(String time, String length) {
        createAdFragment.applyTexts(time, length);
    }
}
