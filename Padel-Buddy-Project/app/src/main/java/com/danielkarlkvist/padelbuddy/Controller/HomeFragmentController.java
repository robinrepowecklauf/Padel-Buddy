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
public class HomeFragmentController extends Fragment {

    private RecyclerView homeRecyclerView;
    private RecyclerView.Adapter homeRecyclerViewAdapter;
    private RecyclerView.LayoutManager homeRecyclerViewLayoutManager;

    private boolean hasOpenedController = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Only performs these actions once in the app
        if (!hasOpenedController) {
            PadelBuddy.getInstance().createAd("Padel center gbg", new Date());
            hasOpenedController = true;
        }

        homeRecyclerView = rootView.findViewById(R.id.recyclerView);
        homeRecyclerView.setHasFixedSize(true);
        homeRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());    //getActivity instead of this when used in fragment?
        homeRecyclerViewAdapter = new GameAdAdapter(PadelBuddy.getInstance().getGames());

        homeRecyclerView.setLayoutManager(homeRecyclerViewLayoutManager);
        homeRecyclerView.setAdapter(homeRecyclerViewAdapter);

        return rootView;
    }
}
