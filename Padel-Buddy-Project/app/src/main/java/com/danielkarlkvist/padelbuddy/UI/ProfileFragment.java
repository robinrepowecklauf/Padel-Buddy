package com.danielkarlkvist.padelbuddy.UI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.MainActivity;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * The ProfileFragment class defines and manages a
 * profile for the user
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public class ProfileFragment extends Fragment {
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    private Button editProfileButton;
    private Button editImageButton;

    private TextView fullNameTextView;
    private TextView firstNameHintTextView;
    private TextView lastNameHintTextView;
    private TextView bioHintTextView;
    private TextView gamesPlayedTextView;
    private TextView bioTextView;

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText biographyEditText;

    private CircleImageView userCircleImageView;

    private PadelBuddy padelBuddy;
    private IPlayer user;

    private boolean isInEditingMode = false;
    private String blockCharacterSet = "!#€%&/()=?`^¡”¥¢‰{}≠¿1234567890+¨',_©®™℅[]<>@$*:;.~|•√π÷×¶∆°£ ";

    public ProfileFragment(PadelBuddy padelBuddy) {
        this.padelBuddy = padelBuddy;
        this.user = padelBuddy.getUser();
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        initializeViews(rootView);
        initializeButtonListeners();

        Bitmap playerImage = PlayerImageBinder.getImage(user, getContext());
        userCircleImageView.setImageBitmap(playerImage);

        fullNameTextView.setText(user.getFullName());
        bioTextView.setText(user.getBiography());

        firstNameEditText.setFilters(new InputFilter[]{filter});
        lastNameEditText.setFilters(new InputFilter[]{filter});

        int amountOfPlayedGames = padelBuddy.getPlayedGames().size();
        gamesPlayedTextView.setText("Antal spelade matcher: " + amountOfPlayedGames);

        return rootView;
    }

    // Add listener to buttons and checks that the user's firstNameEditText and lastNameEditText is not empty when pressing "Spara"
    private void initializeButtonListeners() {
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isInEditingMode) {
                    isInEditingMode = true;
                    editProfile();
                } else if (!firstNameEditText.getText().toString().equals("") && !lastNameEditText.getText().toString().equals("")) {
                    isInEditingMode = false;
                    hideKeyboard(view);
                    saveProfile();
                }
            }
        });

        editImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        // Permission not granted, request it
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        // Show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        pickImageFromGallery();
                    }
                } else {
                    pickImageFromGallery();
                }
            }
        });
    }

    private void initializeViews(View view) {
        fullNameTextView = view.findViewById(R.id.profile_name);
        bioTextView = view.findViewById(R.id.profile_bio);
        gamesPlayedTextView = view.findViewById(R.id.profile_games_played);
        userCircleImageView = view.findViewById(R.id.profile_image);

        firstNameHintTextView = view.findViewById(R.id.profile_firstname_hint);
        lastNameHintTextView = view.findViewById(R.id.profile_lastname_hint);
        bioHintTextView = view.findViewById(R.id.profile_bio_hint);

        editProfileButton = view.findViewById(R.id.edit_profile_button);

        firstNameEditText = view.findViewById(R.id.profile_firstname_edit);
        lastNameEditText = view.findViewById(R.id.profile_lastname_edit);
        biographyEditText = view.findViewById(R.id.profile_bio_edit);
        editImageButton = view.findViewById(R.id.pick_new_image_button);
    }

    // Puts the profile in Edit Mode
    private void editProfile() {
        editProfileButton.setText("Spara");

        editUserInformation();
        changeVisibilityForEditMode();

        placeCursorAfterText(firstNameEditText);
    }

    // Open the option to pick images and crop it
    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    // Handle result of picked image
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            userCircleImageView.setImageURI(data.getData());
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(), data.getData());
                PlayerImageBinder.bind(user, bitmap);
            } catch (Exception e) {
                PlayerImageBinder.bind(user, BitmapFactory.decodeResource(getResources(), R.drawable.no_profile_picture));
                Toast.makeText(getContext(), "Could not import image.", Toast.LENGTH_LONG);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            pickImageFromGallery();
        }
    }

    // Places the current waiting_for_player_picture of the user into EditText so it can be edited
    private void editUserInformation() {
        firstNameEditText.setText(user.getFirstName());
        lastNameEditText.setText(user.getLastName());
        biographyEditText.setText(user.getBiography());
    }

    // Hides the static TextViews and shows all editable texts and input hints necessary to edit the profile
    private void changeVisibilityForEditMode() {
        fullNameTextView.setVisibility(View.INVISIBLE);
        bioTextView.setVisibility(View.INVISIBLE);

        firstNameHintTextView.setVisibility(View.VISIBLE);
        lastNameHintTextView.setVisibility(View.VISIBLE);
        bioHintTextView.setVisibility(View.VISIBLE);

        firstNameEditText.setVisibility(View.VISIBLE);
        lastNameEditText.setVisibility(View.VISIBLE);
        biographyEditText.setVisibility(View.VISIBLE);
        editImageButton.setVisibility(View.VISIBLE);
    }

    // Hides the editable texts and input hints and shows all standard static TextViews
    private void changeVisibilityForStandardMode() {
        firstNameEditText.setVisibility(View.INVISIBLE);
        lastNameEditText.setVisibility(View.INVISIBLE);
        editImageButton.setVisibility(View.INVISIBLE);

        biographyEditText.setVisibility(View.INVISIBLE);

        firstNameHintTextView.setVisibility(View.INVISIBLE);
        lastNameHintTextView.setVisibility(View.INVISIBLE);
        bioHintTextView.setVisibility(View.INVISIBLE);


        fullNameTextView.setVisibility(View.VISIBLE);
        bioTextView.setVisibility(View.VISIBLE);
    }

    // Updates the user's name and biography
    private void placeNewUserInformation() {
        user.setFirstName(firstNameEditText.getText().toString());
        user.setLastName(lastNameEditText.getText().toString());
        fullNameTextView.setText(user.getFullName());

        user.setBiography(biographyEditText.getText().toString());
        bioTextView.setText(user.getBiography());
    }

    // Puts the profile in Standard Mode
    private void saveProfile() {
        editProfileButton.setText("Ändra");

        placeNewUserInformation();
        changeVisibilityForStandardMode();
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

    // A filter that block a specific String of characters 'blockCharacterSet' from the user to put in as firstname and lastname
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
