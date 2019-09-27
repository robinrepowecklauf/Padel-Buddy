package com.danielkarlkvist.padelbuddy.Controller;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.R;

public class ProfileFragmentController extends Fragment implements View.OnClickListener {

    TextView changeTextView;
    TextView nameTextView;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        changeTextView = v.findViewById(R.id.profile_change);
        changeTextView.setOnClickListener(this);

        nameTextView = v.findViewById(R.id.profile_name);
        editText = v.findViewById(R.id.profile_name_edit);


        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile_change:
                editProfile(v);
                break;
        }
    }

    private void editProfile(View view) {
        nameTextView.setVisibility(View.INVISIBLE);
        String previousName = nameTextView.getText().toString();
        editText.setText(previousName);
        editText.setVisibility(View.VISIBLE);
        placeCursorAfterText(editText);
    }

    private void placeCursorAfterText(EditText editText) {
        int textLength = editText.getText().toString().length();
        editText.setSelection(textLength);
    }
}
