package com.danielkarlkvist.padelbuddy.UI;

import android.content.Intent;
import android.os.Bundle;

import com.danielkarlkvist.padelbuddy.MainActivity;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.Services.TestFactory;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.danielkarlkvist.padelbuddy.R;

public class LoginActivity extends AppCompatActivity {
    private IPlayer currentUser;

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
                TestFactory.setCurrentUser(1);
                startMainActivity();
            }
        });
        robinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestFactory.setCurrentUser(2);
                startMainActivity();
            }
        });
        marcusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestFactory.setCurrentUser(3);
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        TestFactory.createPadelBuddy();
        TestFactory.createTestGames();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

