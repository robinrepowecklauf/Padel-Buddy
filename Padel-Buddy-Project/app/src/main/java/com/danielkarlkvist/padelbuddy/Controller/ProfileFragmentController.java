package com.danielkarlkvist.padelbuddy.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
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

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines the profile-view for a user
 */

public class ProfileFragmentController extends Fragment implements View.OnClickListener {

    private TextView changeTextView;
    private TextView fullNameTextView;
    private TextView firstnameHintTextView;
    private TextView lastnameHintTextView;
    private TextView bioHintTextView;
    private EditText firstnameEditText;
    private EditText lastnameEditText;
    private TextView bioTextView;
    private EditText bioEditText;

    private PadelBuddy padelBuddy;
    private Player user;
    private TextView gamesPlayedTextView;

    private boolean isInEditingMode = false;

    /**
     * Puts the current information of a user into TextViews which is visible in the profile-view
     */

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        padelBuddy = PadelBuddy.getInstance();
        user = padelBuddy.getPlayer();
        initializeViews(v);

        changeTextView.setOnClickListener(this);

        fullNameTextView.setText(user.getFullName());
        bioTextView.setText(user.getBio());

        gamesPlayedTextView = v.findViewById(R.id.profile_games_played);
        gamesPlayedTextView.setText("Antal spelade matcher: " + (user.getGamesPlayed()));

        return v;
    }

    /**
     * Listener for the current View if changTextView is being pressed
     *
     * @param v current view of the app
     */

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.profile_change:
                if (!isInEditingMode || checkForSpecialCharacters(firstnameEditText) || checkForSpecialCharacters(lastnameEditText)) {
                    isInEditingMode = true;
                    editProfile();
                } else {
                    isInEditingMode = false;
                    hideKeyboard(v);
                    saveProfile();
                }
                break;
        }
    }

    /**
     * Initalizes all components that defines the profile-view
     *
     * @param v is the current view of the app
     */

    private void initializeViews(View v) {

        fullNameTextView = v.findViewById(R.id.profile_name);
        bioTextView = v.findViewById(R.id.profile_bio);
        firstnameHintTextView = v.findViewById(R.id.profile_firstname_hint);
        lastnameHintTextView = v.findViewById(R.id.profile_lastname_hint);
        bioHintTextView = v.findViewById(R.id.profile_bio_hint);
        changeTextView = v.findViewById(R.id.profile_change);

        firstnameEditText = v.findViewById(R.id.profile_firstname_edit);
        lastnameEditText = v.findViewById(R.id.profile_lastname_edit);
        bioEditText = v.findViewById(R.id.profile_bio_edit);
    }

    /**
     * Puts the profile in Edit Mode
     */

    private void editProfile() {

        changeTextView.setText("Spara");

        editUserInformation();
        changeVisibilityForEditMode();

        placeCursorAfterText(firstnameEditText);
    }

    /**
     * Places the current information of the user into EditText so it can be edited
     */

    private void editUserInformation() {
        firstnameEditText.setText(user.getFirstname());
        lastnameEditText.setText(user.getLastname());
        bioEditText.setText(user.getBio());
    }

    /**
     * Hides the static TextViews and shows all editable texts and input hints necessary to edit the profile
     */

    private void changeVisibilityForEditMode() {

        fullNameTextView.setVisibility(View.GONE);
        bioTextView.setVisibility(View.GONE);

        firstnameHintTextView.setVisibility(View.VISIBLE);
        lastnameHintTextView.setVisibility(View.VISIBLE);
        bioHintTextView.setVisibility(View.VISIBLE);

        firstnameEditText.setVisibility(View.VISIBLE);
        lastnameEditText.setVisibility(View.VISIBLE);
        bioEditText.setVisibility(View.VISIBLE);
    }

    /**
     * Hides the editable texts and input hints and shows all standard static TextViews
     */

    private void changeVisibilityForStandardMode() {

        firstnameEditText.setVisibility(View.GONE);
        lastnameEditText.setVisibility(View.GONE);

        bioEditText.setVisibility(View.GONE);

        firstnameHintTextView.setVisibility(View.GONE);
        lastnameHintTextView.setVisibility(View.GONE);
        bioHintTextView.setVisibility(View.GONE);


        fullNameTextView.setVisibility(View.VISIBLE);
        bioTextView.setVisibility(View.VISIBLE);

    }

    /**
     * Updates the user's name and biography
     */

    private void placeNewUserInformation() {

        user.setFirstname(firstnameEditText.getText().toString());
        user.setLastname(lastnameEditText.getText().toString());
        fullNameTextView.setText(user.getFullName());

        bioTextView.setText(bioEditText.getText().toString());
    }

    /**
     * Puts the profile in Standard Mode
     */

    private void saveProfile() {

        changeTextView.setText("Ändra");

        placeNewUserInformation();
        changeVisibilityForStandardMode();

    }

    /**
     * Places the cursor after any editable text
     *
     * @param editText is any editable text
     */

    private void placeCursorAfterText(EditText editText) {

        int textLength = editText.getText().toString().length();
        editText.setSelection(textLength);
    }

    /**
     * Hides the keyboard
     *
     * @param view the current view of the app
     */

    private void hideKeyboard(View view) {

        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputManager != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /**
     * Finds special characters in any editable text
     *
     * @param editText is any editable text
     * @return true if this method finds a special character
     */

    private boolean checkForSpecialCharacters(EditText editText) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(editText.getText().toString());

        return m.find();
    }
}
