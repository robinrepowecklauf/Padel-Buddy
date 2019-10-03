package com.danielkarlkvist.padelbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.danielkarlkvist.padelbuddy.Controller.CreateAdFragmentController;
import com.danielkarlkvist.padelbuddy.Controller.GamesFragmentController;
import com.danielkarlkvist.padelbuddy.Controller.HomeFragmentController;
import com.danielkarlkvist.padelbuddy.Controller.ProfileFragmentController;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Has the tab controllers as instance variables so the information always gets saved
    private HomeFragmentController homeFragmentController;
    private CreateAdFragmentController createAdFragmentController;
    private GamesFragmentController gamesFragmentController;
    private ProfileFragmentController profileFragmentController;

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationViewListener =
            // region bottomNavigationViewListener
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragmentController = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragmentController = homeFragmentController;
                            break;
                        case R.id.nav_create:
                            selectedFragmentController = createAdFragmentController;
                            break;
                        case R.id.nav_games:
                            selectedFragmentController = gamesFragmentController;
                            break;
                        case R.id.nav_profile:
                            selectedFragmentController = profileFragmentController;
                            break;
                        default:
                            Log.println(1, "tag", "Selected fragment that doesn't exist.");
                            selectedFragmentController = new HomeFragmentController();
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

        initializeBottomNavigationViewControllers();
        initializeBottomNavigationView();
    }


    private void initializeBottomNavigationViewControllers() {
        homeFragmentController = new HomeFragmentController();
        createAdFragmentController = new CreateAdFragmentController();
        gamesFragmentController = new GamesFragmentController();
        profileFragmentController = new ProfileFragmentController();
    }

    private void initializeBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationViewListener);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);  // Sets the current selected tab as Home when the app opens
    }
}
