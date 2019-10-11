package com.danielkarlkvist.padelbuddy.Controller;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;

import java.util.Calendar;

/**
 * The CreateAdFragment class defines the Fragment where a user can create a game ad.
 *
 * @author Carl-Johan Björnson
 *
 * @version 1.0
 * @since 2019-10-11
 */

public class CreateAdFragment extends Fragment {
    private TextView userFirstName;
    private RatingBar userProfileRating;

    private RelativeLayout invitation1;
    private RelativeLayout invitation2;
    private Button invitationButton1;
    private Button invitationButton2;
    private Button player2RemoveButton;
    private Button player3RemoveButton;

    private Spinner padelArenaSpinner;

    private Button dateButton;
    private TextView chosenDateTextview;

    private Calendar c;
    private DatePickerDialog dpd;

    private Button dialogButton;

    private TextView chosenTimeTextview;
    private TextView chosenGameLengthTextview;

    private Player user;

    public CreateAdFragment(Player user) {
        this.user = user;
    }

    /**
     *  Creates the view, assigns all xml components and adds listeners.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_ad, container, false);
        invitationButton1 = v.findViewById(R.id.invitation1_button);
        invitation1 = v.findViewById(R.id.invited_player2);
        invitationButton2 = v.findViewById(R.id.invitation2_button);
        invitation2 = v.findViewById(R.id.invited_player3);
        player2RemoveButton = v.findViewById(R.id.player2_remove_button);
        player3RemoveButton = v.findViewById(R.id.player3_remove_button);
        userFirstName = v.findViewById(R.id.player1_name_textview);
        userProfileRating = v.findViewById(R.id.player1_ratingbar);

        dialogButton = v.findViewById(R.id.time_button);

        chosenTimeTextview = v.findViewById(R.id.chosen_start_time_textview);
        chosenGameLengthTextview = v.findViewById(R.id.chosen_game_length_textview);

        padelArenaSpinner = v.findViewById(R.id.padelarena_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.padel_arenas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        padelArenaSpinner.setAdapter(adapter);

        dateButton = v.findViewById(R.id.date_button);
        chosenDateTextview = v.findViewById(R.id.chosen_date_textview);

        invitePlayers();

        userFirstName.setText(user.getFirstname());
        userProfileRating.setRating(user.getProfileRating());

        return v;
    }

    /**
     *
     */

    private void invitePlayers() {
        player2RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton1.setVisibility(View.VISIBLE);
                invitation1.setVisibility(View.INVISIBLE);
            }
        });

        player3RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton2.setVisibility(View.VISIBLE);
                invitation2.setVisibility(View.INVISIBLE);
            }
        });

        invitationButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton1.setVisibility(View.INVISIBLE);
                invitation1.setVisibility(View.VISIBLE);
            }
        });

        invitationButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invitationButton2.setVisibility(View.INVISIBLE);
                invitation2.setVisibility(View.VISIBLE);
            }
        });

        /**
         *
         */

        //Should it be here?
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        chosenDateTextview.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                }, year, month, day);

                dpd.getDatePicker().setMinDate(c.getTimeInMillis());
                c.add(Calendar.DATE, +31);                           // Allows user to book one month ahead
                dpd.getDatePicker().setMaxDate(c.getTimeInMillis());
                dpd.show();
            }
        });

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

    /**
     *  Creates and opens Dialog to chose time for the game ad.
     */

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getFragmentManager(), "example dialog");
    }

    /**
     * Applies chosen time and game length to the game ad.
     * @param time
     * @param length
     */
    public void applyTexts(String time, String length) {
        chosenTimeTextview.setText(time);
        chosenGameLengthTextview.setText(length);
    }
}

