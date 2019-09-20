package com.danielkarlkvist.padelbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.danielkarlkvist.padelbuddy.Controller.CreateAdFragmentController;
import com.danielkarlkvist.padelbuddy.Controller.GamesFragmentController;
import com.danielkarlkvist.padelbuddy.Controller.HomeFragmentController;
import com.danielkarlkvist.padelbuddy.Controller.ProfileFragmentController;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    HomeFragmentController homeFragmentController;
    CreateAdFragmentController createAdFragmentController;
    GamesFragmentController gamesFragmentController;
    ProfileFragmentController profileFragmentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        homeFragmentController = new HomeFragmentController();
        createAdFragmentController = new CreateAdFragmentController();
        gamesFragmentController = new GamesFragmentController();
        profileFragmentController = new ProfileFragmentController();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationViewListener);
        bottomNavigationView.setSelectedItemId(R.id.nav_home); // måste finnas för att startsidan inte ska bli activity_mains fragment_container utan home
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationViewListener =
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
}
