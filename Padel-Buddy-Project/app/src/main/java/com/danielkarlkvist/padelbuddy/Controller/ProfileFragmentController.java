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

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileFragmentController extends Fragment implements View.OnClickListener {

    private TextView changeTextView;
    private TextView nameTextView;
    private TextView firstnameHintTextView;
    private TextView lastnameHintTextView;
    private EditText firstnameEditText;
    private EditText lastnameEditText;
    private TextView bioTextView;
    private EditText bioEditText;
    private PadelBuddy padelBuddy;
    private Player user;

    private boolean isInEditingMode = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        changeTextView = v.findViewById(R.id.profile_change);
        changeTextView.setOnClickListener(this);

        firstnameHintTextView = v.findViewById(R.id.profile_firstname_hint);
        lastnameHintTextView = v.findViewById(R.id.profile_lastname_hint);

        padelBuddy = PadelBuddy.getInstance();
        user = padelBuddy.getPlayer();

        nameTextView = v.findViewById(R.id.profile_name);
        nameTextView.setText(user.getFullName());
        firstnameEditText = v.findViewById(R.id.profile_firstname_edit);
        lastnameEditText = v.findViewById(R.id.profile_lastname_edit);

        bioTextView = v.findViewById(R.id.profile_bio);
        bioTextView.setText(user.getBio());
        bioEditText = v.findViewById(R.id.profile_bio_edit);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.profile_change:
                if (!isInEditingMode || checkForSpecialCharacters(firstnameEditText) || checkForSpecialCharacters(lastnameEditText)) {
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

        firstnameHintTextView.setVisibility(View.VISIBLE);
        lastnameHintTextView.setVisibility(View.VISIBLE);

        editName();
        editBiography();
    }

    private void editName() {

        firstnameEditText.setText(user.getFirstname());
        lastnameEditText.setText(user.getLastname());
        firstnameEditText.setVisibility(View.VISIBLE);
        lastnameEditText.setVisibility(View.VISIBLE);
        placeCursorAfterText(firstnameEditText);
    }

    private void editBiography() {

        bioEditText.setText(user.getBio());
        bioEditText.setVisibility(View.VISIBLE);
    }

    private void saveProfile(View view) {

        firstnameEditText.setVisibility(View.GONE);
        lastnameEditText.setVisibility(View.GONE);

        firstnameHintTextView.setVisibility(View.GONE);
        lastnameHintTextView.setVisibility(View.GONE);

        user.setFirstname(firstnameEditText.getText().toString());
        user.setLastname(lastnameEditText.getText().toString());
        nameTextView.setText(user.getFullName());

        nameTextView.setVisibility(View.VISIBLE);

        bioEditText.setVisibility(View.GONE);
        bioTextView.setText(bioEditText.getText().toString());
        bioTextView.setVisibility(View.VISIBLE);

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

    private boolean checkForSpecialCharacters(EditText editText) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(editText.getText().toString());
        boolean b = m.find();

        if (b) {
            editText.setTextColor(Color.RED);
            return true;
        }

        return false;
    }
}
