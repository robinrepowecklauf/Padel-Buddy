package com.danielkarlkvist.padelbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Services.TestFactory;
import com.danielkarlkvist.padelbuddy.UI.CreateAdFragment;
import com.danielkarlkvist.padelbuddy.UI.GamesFragment;
import com.danielkarlkvist.padelbuddy.UI.GameRecyclerViewFragment;
import com.danielkarlkvist.padelbuddy.UI.LoginActivity;
import com.danielkarlkvist.padelbuddy.UI.ProfileFragment;
import com.danielkarlkvist.padelbuddy.UI.ITimePickerDialogListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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

    private PadelBuddy padelBuddy = LoginActivity.getPadelbuddy();

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
                                homeFragmentController = new GameRecyclerViewFragment(R.layout.fragment_home,R.id.home_recyclerview, padelBuddy.getAvailableGames(),padelBuddy);
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
                            selectedFragmentController = new GameRecyclerViewFragment(R.layout.fragment_home, R.id.home_recyclerview, padelBuddy.getGames(),padelBuddy);
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

        if (padelBuddy == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            padelBuddy = LoginActivity.getPadelbuddy();

            initializeBottomNavigationViewControllers();
            initializeBottomNavigationView();
        }
    }

    /**
     * Instantiates the main Fragments in the app
     */
    private void initializeBottomNavigationViewControllers() {
        homeFragmentController = new GameRecyclerViewFragment(R.layout.fragment_home,R.id.home_recyclerview, padelBuddy.getAvailableGames(),padelBuddy);
        createAdFragment = new CreateAdFragment(padelBuddy);
        gamesFragment = new GamesFragment(padelBuddy);
        profileFragment = new ProfileFragment(padelBuddy.getUser());
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
