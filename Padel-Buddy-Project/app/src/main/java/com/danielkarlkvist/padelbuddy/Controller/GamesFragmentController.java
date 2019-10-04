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

public class GamesFragmentController extends Fragment {

    private RecyclerView gamesRecyclerView;
    private RecyclerView.Adapter gamesRecyclerViewAdapter;
    private RecyclerView.LayoutManager gamesRecyclerViewLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        gamesRecyclerView = rootView.findViewById(R.id.recyclerView);
        gamesRecyclerView.setHasFixedSize(true);
        gamesRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());    //getActivity instead of this when used in fragment?
        gamesRecyclerViewAdapter = new GameAdAdapter(PadelBuddy.getInstance().getGames());

        gamesRecyclerView.setLayoutManager(gamesRecyclerViewLayoutManager);
        gamesRecyclerView.setAdapter(gamesRecyclerViewAdapter);

        return rootView;
    }
}
