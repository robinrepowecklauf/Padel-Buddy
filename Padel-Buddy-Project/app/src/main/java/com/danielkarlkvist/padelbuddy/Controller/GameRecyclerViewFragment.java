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

import java.util.Date;

/**
 * Controller for the home tab
 */
public class GameRecyclerViewFragment extends Fragment implements ScrollToTop{

    private RecyclerView homeRecyclerView;
    private RecyclerView.Adapter homeRecyclerViewAdapter;
    private RecyclerView.LayoutManager homeRecyclerViewLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        homeRecyclerView = rootView.findViewById(R.id.recyclerView);
        homeRecyclerView.setHasFixedSize(true);
        homeRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());    //getActivity instead of this when used in fragment?
        homeRecyclerViewAdapter = new GameAdAdapter(PadelBuddy.getInstance().getGames());

        homeRecyclerView.setLayoutManager(homeRecyclerViewLayoutManager);
        homeRecyclerView.setAdapter(homeRecyclerViewAdapter);

        return rootView;
    }

    @Override
    public void scrollToTop() {
        homeRecyclerViewLayoutManager.smoothScrollToPosition(homeRecyclerView, null, 0);
    }
}
