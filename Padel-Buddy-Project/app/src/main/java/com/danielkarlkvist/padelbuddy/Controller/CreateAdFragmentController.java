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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.MainActivity;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreateAdFragmentController extends Fragment{
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

        padelArenaSpinner = v.findViewById(R.id.padelarena_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.padel_arenas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        padelArenaSpinner.setAdapter(adapter);

        dateButton = v.findViewById(R.id.date_button);
        chosenDateTextview = v.findViewById(R.id.chosen_date_textview);


        invitePlayers();
        PadelBuddy pb = PadelBuddy.getInstance();
        userFirstName.setText(pb.getPlayer().getFirstname());
        userProfileRating.setRating(pb.getPlayer().getProfileRating());

        return v;
    }


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
                        chosenDateTextview.setText(mDay + "/" + (mMonth+1) +"/" + mYear);
                    }
                }, year, month, day);

                dpd.getDatePicker().setMinDate(c.getTimeInMillis());
                c.add(Calendar.DATE,+31);                           // Allows user to book one month ahead
                dpd.getDatePicker().setMaxDate(c.getTimeInMillis());
                dpd.show();
            }
        });

    }
/*
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(calendar.getTime());
        chosenDateTextview.setText(currentDateString);

    }
*/
}

