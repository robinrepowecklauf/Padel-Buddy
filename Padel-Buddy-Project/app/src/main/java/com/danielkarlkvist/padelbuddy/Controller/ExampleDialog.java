package com.danielkarlkvist.padelbuddy.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.danielkarlkvist.padelbuddy.R;

public class ExampleDialog extends AppCompatDialogFragment {
    private TimePicker timePicker1;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.test_time_picker,null);

        builder.setView(view)
                .setTitle("testTitle")
                .setNegativeButton("testCancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("TestOk", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String time = ""+timePicker1.getHour() + ":" +timePicker1.getMinute();
                listener.applyTexts(time);
            }
        });

        timePicker1 = view.findViewById(R.id.timePicker1);
        timePicker1.setIs24HourView(true);

        return builder.create();
    }

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

    public interface ExampleDialogListener{
        void applyTexts(String time);
    }
}
