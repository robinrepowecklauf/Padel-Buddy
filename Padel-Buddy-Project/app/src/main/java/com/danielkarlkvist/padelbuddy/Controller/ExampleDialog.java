package com.danielkarlkvist.padelbuddy.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.danielkarlkvist.padelbuddy.R;

/**
 * The ExampleDialog class defines
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-10-11
 */

public class ExampleDialog extends AppCompatDialogFragment {

    private TimePicker timePicker1;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private ExampleDialogListener listener;
    private View view;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.test_time_picker, null);

        builder.setView(view)
                .setTitle("Välj tid för matchens start och längd")
                .setNegativeButton("Tillbaka", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String time = "" + timePicker1.getHour() + ":" + timePicker1.getMinute();

                        radioButton = getCheckedRadioButton(view);

                        String length = radioButton.getText().toString();
                        listener.applyTexts(time, length);
                    }
                });

        radioGroup = view.findViewById(R.id.length_radiogroup);
        radioButton = getCheckedRadioButton(view);

        timePicker1 = view.findViewById(R.id.timePicker1);
        timePicker1.setIs24HourView(true);

        return builder.create();
    }

    private RadioButton getCheckedRadioButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = view.findViewById(radioId);
        return radioButton;
    }

    /**
     * @param context
     */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    /**
     *
     */

    public interface ExampleDialogListener {
        void applyTexts(String time, String length);
    }
}
