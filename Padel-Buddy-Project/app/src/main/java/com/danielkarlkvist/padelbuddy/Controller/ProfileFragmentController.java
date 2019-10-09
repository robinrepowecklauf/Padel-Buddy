package com.danielkarlkvist.padelbuddy.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * The ProfileFragmentController class defines and manages a
 * profile for the user
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */

public class ProfileFragmentController extends Fragment {

    private static final int PERMISSION_CODE = 1001;

    private Button editProfileButton;
    private Button editImageButton;

    private TextView fullNameTextView;
    private TextView firstnameHintTextView;
    private TextView lastnameHintTextView;
    private TextView bioHintTextView;
    private TextView gamesPlayedTextView;
    private TextView bioTextView;

    private EditText firstnameEditText;
    private EditText lastnameEditText;
    private EditText bioEditText;

    private CircleImageView userCircularImageView;

    private PadelBuddy padelBuddy;
    private Player user;

    private boolean isInEditingMode = false;
    private String blockCharacterSet = "!#€%&/()=?`^¡”¥¢‰{}≠¿1234567890+¨',_\©®™℅[]<>@$*\":;.~|•√π÷×¶∆°£;

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
        initializeListenerToButton();

        fullNameTextView.setText(user.getFullName());
        bioTextView.setText(user.getBio());

        firstnameEditText.setFilters(new InputFilter[] { filter });
        lastnameEditText.setFilters(new InputFilter[] { filter });

        gamesPlayedTextView.setText("Antal spelade matcher: " + (user.getGamesPlayed()));

        return v;
    }

    /**
     * Add listener to buttons
     */

    private void initializeListenerToButton() {
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isInEditingMode) {
                    isInEditingMode = true;
                    editProfile();
                } else {
                    isInEditingMode = false;
                    hideKeyboard(v);
                    saveProfile();
                }
            }
        });

        editImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageFromGallery();
            }
        });

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
        editProfileButton = v.findViewById(R.id.edit_profile_button);

        firstnameEditText = v.findViewById(R.id.profile_firstname_edit);
        lastnameEditText = v.findViewById(R.id.profile_lastname_edit);
        bioEditText = v.findViewById(R.id.profile_bio_edit);
        editImageButton = v.findViewById(R.id.pick_new_image_button);
        userCircularImageView = v.findViewById(R.id.profile_image);
        gamesPlayedTextView = v.findViewById(R.id.profile_games_played);
    }

    /**
     * Puts the profile in Edit Mode
     */

    private void editProfile() {

        editProfileButton.setText("Spara");

        editUserInformation();
        changeVisibilityForEditMode();

        placeCursorAfterText(firstnameEditText);
    }

    /**
     * Open the option to pick images and crop it
     */

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("outputX", 256);
        intent.putExtra("outputY", 256);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 1);
    }

    /**
     * Handle result of picked image
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            // error
            return;
        }
        if (requestCode == 1) {
            final Bundle extras = data.getExtras();
            if (extras != null) {
                //Get image
                Bitmap newProfilePic = extras.getParcelable("data");
                userCircularImageView.setImageBitmap(newProfilePic);
                user.setImage(userCircularImageView);
            }
        }
    }

    /**
     * Handle result runtime permission
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            pickImageFromGallery();
        }
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

        fullNameTextView.setVisibility(View.INVISIBLE);
        bioTextView.setVisibility(View.INVISIBLE);

        firstnameHintTextView.setVisibility(View.VISIBLE);
        lastnameHintTextView.setVisibility(View.VISIBLE);
        bioHintTextView.setVisibility(View.VISIBLE);

        firstnameEditText.setVisibility(View.VISIBLE);
        lastnameEditText.setVisibility(View.VISIBLE);
        bioEditText.setVisibility(View.VISIBLE);
        editImageButton.setVisibility(View.VISIBLE);
    }

    /**
     * Hides the editable texts and input hints and shows all standard static TextViews
     */

    private void changeVisibilityForStandardMode() {

        firstnameEditText.setVisibility(View.INVISIBLE);
        lastnameEditText.setVisibility(View.INVISIBLE);
        editImageButton.setVisibility(View.INVISIBLE);

        bioEditText.setVisibility(View.INVISIBLE);

        firstnameHintTextView.setVisibility(View.INVISIBLE);
        lastnameHintTextView.setVisibility(View.INVISIBLE);
        bioHintTextView.setVisibility(View.INVISIBLE);


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

        user.setBio(bioEditText.getText().toString());
        bioTextView.setText(user.getBio());
    }

    /**
     * Puts the profile in Standard Mode
     */

    private void saveProfile() {

        editProfileButton.setText("Ändra");

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

    private InputFilter filter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            if (source != null && blockCharacterSet.contains(("" + source))) {
                return "";
            }
            return null;
        }
    };
}
