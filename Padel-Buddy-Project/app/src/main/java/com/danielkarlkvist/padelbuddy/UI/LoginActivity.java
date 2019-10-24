package com.danielkarlkvist.padelbuddy.UI;

import android.content.Intent;
import android.os.Bundle;

import com.danielkarlkvist.padelbuddy.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.danielkarlkvist.padelbuddy.R;

/**
 * The LoginActivity class is the activity where the user will register or log in
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public class LoginActivity extends AppCompatActivity {
    private Button danielButton;
    private Button robinButton;
    private Button marcusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();
        initializeButtonListeners();
    }

    private void initializeViews() {
        danielButton = findViewById(R.id.test_daniel_button);
        robinButton = findViewById(R.id.test_robin_button);
        marcusButton = findViewById(R.id.test_marcus_button);
    }

    private void initializeButtonListeners() {
        danielButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setPadelBuddy(1, getApplicationContext());
                startMainActivity();
            }
        });
        robinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setPadelBuddy(2, getApplicationContext());
                startMainActivity();
            }
        });
        marcusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setPadelBuddy(3, getApplicationContext());
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


