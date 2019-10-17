package com.danielkarlkvist.padelbuddy.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.R;

public class LoginFragment extends Fragment {
    Button danielButton;
    Button robinButton;
    Button marcusButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.test_login_screen, container, false);

        initializeViews(rootView);
        initializeButtonListeners();

        return rootView;
    }

    private void initializeViews(View view) {
        danielButton = view.findViewById(R.id.test_daniel_button);
        robinButton = view.findViewById(R.id.test_robin_button);
        marcusButton = view.findViewById(R.id.test_marcus_button);
    }

    private void initializeButtonListeners() {
        danielButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
