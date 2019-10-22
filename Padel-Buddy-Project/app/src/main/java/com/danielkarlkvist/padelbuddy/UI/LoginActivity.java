package com.danielkarlkvist.padelbuddy.UI;

import android.content.Intent;
import android.os.Bundle;

import com.danielkarlkvist.padelbuddy.MainActivity;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Services.TestFactory;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.danielkarlkvist.padelbuddy.R;

public class LoginActivity extends AppCompatActivity {
    private Button danielButton;
    private Button robinButton;
    private Button marcusButton;

    private static PadelBuddy padelBuddy;

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
                padelBuddy = new PadelBuddy(TestFactory.getUser(1, getApplicationContext()));
                startMainActivity();
            }
        });
        robinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                padelBuddy = new PadelBuddy(TestFactory.getUser(2, getApplicationContext()));
                startMainActivity();
            }
        });
        marcusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                padelBuddy = new PadelBuddy(TestFactory.getUser(3, getApplicationContext()));
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        TestFactory.createTestGames(padelBuddy, getApplicationContext());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public static PadelBuddy getPadelbuddy(){
        return padelBuddy;
    }
}


