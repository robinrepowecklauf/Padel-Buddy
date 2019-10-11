package com.danielkarlkvist.padelbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.danielkarlkvist.padelbuddy.Controller.CreateAdFragment;
import com.danielkarlkvist.padelbuddy.Controller.ExampleDialog;
import com.danielkarlkvist.padelbuddy.Controller.GamesFragment;
import com.danielkarlkvist.padelbuddy.Controller.GameRecyclerViewFragment;
import com.danielkarlkvist.padelbuddy.Controller.ProfileFragment;
import com.danielkarlkvist.padelbuddy.Model.Game;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

// TODO fix better javadoc for mainactivity

/**
 * The MainActivity class is the base of the project.
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since   2019-09-05
 */


    // Has the tab controllers as instance variables so the information always gets saved
    private GameRecyclerViewFragment homeFragmentController;
    private CreateAdFragment createAdFragment;
    private GamesFragment gamesFragment;
    private ProfileFragment profileFragment;
    private Fragment selectedFragmentController = null;

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationViewListener =
            // region bottomNavigationViewListener
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            if(selectedFragmentController == homeFragmentController) {
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
                            if(selectedFragmentController == gamesFragment) {
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
                            selectedFragmentController = new GameRecyclerViewFragment(R.layout.fragment_home, R.id.home_recyclerview, PadelBuddy.getInstance().getGames());
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

        createRandomGames();

        initializeBottomNavigationViewControllers();
        initializeBottomNavigationView();
    }

    private void createRandomGames() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            PadelBuddy.getInstance().createAd("Padel center gbg", new Date(2019, rand.nextInt(12), rand.nextInt(31),rand.nextInt(24), rand.nextInt(61)));
        }

        PadelBuddy padelBuddy = PadelBuddy.getInstance();
        ArrayList<Game> testGames = padelBuddy.getGames();
        List<Player> testPlayers = PadelBuddy.testPlayers;
        
        testGames.get(0).addPlayer(testPlayers.get(0));
        testGames.get(0).addPlayer(testPlayers.get(1));
        testGames.get(0).addPlayer(testPlayers.get(2));
        testGames.get(0).addPlayer(testPlayers.get(3));


    }

    private void initializeBottomNavigationViewControllers() {
        homeFragmentController = new GameRecyclerViewFragment(R.layout.fragment_home, R.id.home_recyclerview, PadelBuddy.getInstance().getGames());
        createAdFragment = new CreateAdFragment();
        gamesFragment = new GamesFragment();
        profileFragment = new ProfileFragment();
    }

    private void initializeBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationViewListener);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);  // Sets the current selected tab as Home when the app opens
    }

    @Override
    public void applyTexts(String time) {
        createAdFragment.applyTexts(time);
    }
}
