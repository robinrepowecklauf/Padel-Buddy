package com.danielkarlkvist.padelbuddy.Controller;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.R;

public class ProfileFragmentController extends Fragment implements View.OnClickListener {

    private TextView changeTextView;
    private TextView nameTextView;
    private EditText nameEditText;
    private TextView bioTextView;
    private EditText bioEditText;

    private boolean isInEditingMode = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        changeTextView = v.findViewById(R.id.profile_change);
        changeTextView.setOnClickListener(this);

        nameTextView = v.findViewById(R.id.profile_name);
        nameEditText = v.findViewById(R.id.profile_name_edit);

        bioTextView = v.findViewById(R.id.profile_bio);
        bioEditText = v.findViewById(R.id.profile_bio_edit);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.profile_change:
                if (!isInEditingMode) {
                    isInEditingMode = true;
                    editProfile(v);
                } else {
                    isInEditingMode = false;
                    hideKeyboard(v);
                    saveProfile(v);
                }
                break;
        }
    }

    private void editProfile(View view) {

        changeTextView.setText("Spara");
        changeTextView.setTextColor(Color.BLUE);

        nameTextView.setVisibility(View.INVISIBLE);
        bioTextView.setVisibility(View.INVISIBLE);

        editName();
        editBiography();
    }

    private void editName() {

        String previousName = nameTextView.getText().toString();
        nameEditText.setText(previousName);
        nameEditText.setVisibility(View.VISIBLE);
        placeCursorAfterText(nameEditText);
    }

    private void editBiography() {

        String previousBio = bioTextView.getText().toString();
        bioEditText.setText(previousBio);
        bioEditText.setVisibility(View.VISIBLE);
        placeCursorAfterText(bioEditText);
    }

    private void saveProfile(View view) {

        nameEditText.setVisibility(View.GONE);
        nameTextView.setVisibility(View.VISIBLE);

        bioEditText.setVisibility(View.GONE);
        bioTextView.setVisibility(View.VISIBLE);

        String newName = nameEditText.getText().toString();
        nameTextView.setText(newName);
        System.out.println(nameTextView.getText().toString());

        String newBio = bioEditText.getText().toString();
        bioTextView.setText(newBio);

        changeTextView.setText("Ändra");
        changeTextView.setTextColor(Color.BLUE);
    }

    private void placeCursorAfterText(EditText editText) {

        int textLength = editText.getText().toString().length();
        editText.setSelection(textLength);
    }

    private void hideKeyboard(View view) {

        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputManager != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
