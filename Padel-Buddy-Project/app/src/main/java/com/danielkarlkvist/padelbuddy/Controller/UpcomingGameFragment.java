package com.danielkarlkvist.padelbuddy.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.R;

public class UpcomingGameFragment extends Fragment {
    private RecyclerView gamesRecyclerView;
    private RecyclerView.Adapter gamesRecyclerViewAdapter;
    private RecyclerView.LayoutManager gamesRecyclerViewLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_upcoming_game, container, false);

        gamesRecyclerView = rootView.findViewById(R.id.upcoming_games_recyclerView);
        gamesRecyclerView.setHasFixedSize(true);
        gamesRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        gamesRecyclerViewAdapter = new GamesAdapter(PadelBuddy.getInstance().getGames());

        gamesRecyclerView.setLayoutManager(gamesRecyclerViewLayoutManager);
        gamesRecyclerView.setAdapter(gamesRecyclerViewAdapter);

        return rootView;
    }
}

