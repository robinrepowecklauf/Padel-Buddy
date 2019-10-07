package com.danielkarlkvist.padelbuddy.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;

import java.util.ArrayList;

public class CreateAdFragmentController extends Fragment {

    private RelativeLayout invitation1;
    private RelativeLayout invitation2;
    private Button invitationButton1;
    private Button invitationButton2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_ad, container, false);
        invitationButton1 = v.findViewById(R.id.invitation1_button);
        invitation1 = v.findViewById(R.id.invited_player2);
        invitationButton2 = v.findViewById(R.id.invitation2_button);
        invitation2 = v.findViewById(R.id.invited_player3);
        invitePlayers();

        return v;
    }

    private void invitePlayers() {
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
    }
}
