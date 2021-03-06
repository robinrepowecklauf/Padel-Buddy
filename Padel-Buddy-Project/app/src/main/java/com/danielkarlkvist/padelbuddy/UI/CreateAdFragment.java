package com.danielkarlkvist.padelbuddy.UI;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.Model.ICreate;
import com.danielkarlkvist.padelbuddy.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * The CreateAdFragment class defines the Fragment where a user can create a game ad.
 *
 * @author Carl-Johan Björnson
 * @version 1.0
 * @since 2019-10-11
 */
public class CreateAdFragment extends Fragment {
    private TextView userFirstNameTextView;
    private RatingBar userProfileRatingBar;
    private ImageView userImageView;

    private RelativeLayout invitation1RelativeLayout;
    private RelativeLayout invitation2RelativeLayout;
    private Button invitationButton1;
    private Button invitationButton2;
    private Button player2RemoveButton;
    private Button player3RemoveButton;

    private Spinner padelArenaSpinner;

    private Button dateButton;
    private TextView chosenDateTextView;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    private Button timeButton;

    private TextView chosenTimeTextView;
    private TextView chosenGameLengthTextView;

    private ICreate iCreate;

    private Button createAdButton;

    public CreateAdFragment(ICreate iCreate) {
        this.iCreate = iCreate;
    }

    /**
     * Creates the view.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_ad, container, false);
        initializeViews(rootView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.padel_arenas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        padelArenaSpinner.setAdapter(adapter);

        setButtonListeners();

        userFirstNameTextView.setText(iCreate.getUser().getFirstName());
        userProfileRatingBar.setRating(iCreate.getUser().getProfileRating());

        return rootView;
    }

    private void initializeViews(View view) {
        padelArenaSpinner = view.findViewById(R.id.padelarena_spinner);

        dateButton = view.findViewById(R.id.date_button);
        chosenDateTextView = view.findViewById(R.id.chosen_date_textview);

        timeButton = view.findViewById(R.id.time_button);
        chosenTimeTextView = view.findViewById(R.id.chosen_start_time_textview);
        chosenGameLengthTextView = view.findViewById(R.id.chosen_game_length_textview);

        userFirstNameTextView = view.findViewById(R.id.player1_name_textview);
        userProfileRatingBar = view.findViewById(R.id.player1_ratingbar);

        userImageView = view.findViewById(R.id.player1_imageview);
        Bitmap playerImage = PlayerImageBinder.getImage(iCreate.getUser(), getContext());
        userImageView.setImageBitmap(playerImage);

        invitationButton1 = view.findViewById(R.id.invitation1_button);
        invitation1RelativeLayout = view.findViewById(R.id.invited_player2);
        invitationButton2 = view.findViewById(R.id.invitation2_button);
        invitation2RelativeLayout = view.findViewById(R.id.invited_player3);

        player2RemoveButton = view.findViewById(R.id.player2_remove_button);
        player3RemoveButton = view.findViewById(R.id.player3_remove_button);

        createAdButton = view.findViewById(R.id.create_ad_button);
    }

    private void setButtonListeners() {
        player2RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton1.setVisibility(View.VISIBLE);
                invitation1RelativeLayout.setVisibility(View.INVISIBLE);
            }
        });

        player3RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton2.setVisibility(View.VISIBLE);
                invitation2RelativeLayout.setVisibility(View.INVISIBLE);
            }
        });

        invitationButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton1.setVisibility(View.INVISIBLE);
                invitation1RelativeLayout.setVisibility(View.VISIBLE);
            }
        });

        invitationButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton2.setVisibility(View.INVISIBLE);
                invitation2RelativeLayout.setVisibility(View.VISIBLE);
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        dateButton.setOnClickListener(dateButtonOnClickListener);

        createAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAd();
            }
        });
    }

    private Button.OnClickListener dateButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    chosenDateTextView.setText(year + "/" + (month + 1) + "/" + day);
                }
            }, year, month, day);

            datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
            calendar.add(Calendar.DATE, 31);                           // Allows user to book one month ahead
            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            datePickerDialog.show();
        }
    };

    /**
     * Creates and opens Dialog to choose time for the game ad.
     */
    private void openDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog();
        timePickerDialog.show(getFragmentManager(), "timePickerDialog");
    }

    /**
     * Applies chosen time and game length to the game ad.
     *
     * @param time
     * @param length
     */
    public void applyTexts(String time, String length) {
        chosenTimeTextView.setText(time);
        chosenGameLengthTextView.setText(length);
    }

    private void createAd() {
        if (checkInputValues()) {
            iCreate.createAd(padelArenaSpinner.getSelectedItem().toString(), stringToDate(dateAndTimeString(chosenDateTextView.getText().toString(), chosenTimeTextView.getText().toString())), chosenGameLengthTextView.getText().toString());
        } else {
            Toast.makeText(getContext(), "VÄLJ TID!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkInputValues() {
        boolean isValid = true;
        String s1 = chosenDateTextView.getText().toString();
        String s2 = chosenGameLengthTextView.getText().toString();

        if (s1.equals("") || s2.equals("")) {
            isValid = false;
        }

        return isValid;
    }

    private String dateAndTimeString(String dateString, String timeString) {
        StringBuilder sb = new StringBuilder();
        sb.append(dateString);
        sb.append(" ");
        sb.append(timeString);

        return sb.toString();
    }

    private Date stringToDate(String dateString) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.ENGLISH);
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}

