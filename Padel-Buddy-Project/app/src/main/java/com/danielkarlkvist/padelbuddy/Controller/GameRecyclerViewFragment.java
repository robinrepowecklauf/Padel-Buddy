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

import com.danielkarlkvist.padelbuddy.Model.Game;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.R;

import java.util.ArrayList;

/**
 * Controller for the home tab
 */
public class GameRecyclerViewFragment extends Fragment implements ScrollToTop{

    private RecyclerView gameRecyclerView;
    private RecyclerView.Adapter gameRecyclerViewAdapter;
    private RecyclerView.LayoutManager gameRecyclerViewLayoutManager;

    private int fragmentId;
    private int recyclerViewId;
    private ArrayList<Game> games;

    public GameRecyclerViewFragment(int fragmentId, int recyclerViewId, ArrayList<Game> games) {
        this.fragmentId = fragmentId;
        this.recyclerViewId = recyclerViewId;
        this.games = games;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(fragmentId, container, false);

        gameRecyclerView = rootView.findViewById(recyclerViewId);
        gameRecyclerView.setHasFixedSize(true);
        gameRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());    //getActivity instead of this when used in fragment?
        gameRecyclerViewAdapter = new GameToRecyclerViewAdapter(games);

        gameRecyclerView.setLayoutManager(gameRecyclerViewLayoutManager);
        gameRecyclerView.setAdapter(gameRecyclerViewAdapter);

        return rootView;
    }

    @Override
    public void scrollToTop() {
        gameRecyclerViewLayoutManager.smoothScrollToPosition(gameRecyclerView, null, 0);
    }

    public RecyclerView getGameRecyclerView() {
        return gameRecyclerView;
    }

    public RecyclerView.LayoutManager getGameRecyclerViewLayoutManager() {
        return gameRecyclerViewLayoutManager;
    }
}
