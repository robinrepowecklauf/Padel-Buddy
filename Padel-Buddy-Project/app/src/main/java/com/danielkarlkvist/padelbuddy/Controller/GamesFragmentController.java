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
import androidx.viewpager.widget.ViewPager;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.R;
import com.google.android.material.tabs.TabLayout;

public class GamesFragmentController extends Fragment {

    private TabLayout gamesTabLayout;
    private ViewPager gamesViewPager;

    private RecyclerView gamesRecyclerView;
    private RecyclerView.Adapter gamesRecyclerViewAdapter;
    private RecyclerView.LayoutManager gamesRecyclerViewLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        gamesTabLayout = rootView.findViewById(R.id.games_tablayout);
        gamesViewPager = rootView.findViewById(R.id.games_viewpager);

        GamesViewPagerAdapter gamesViewPagerAdapter = new GamesViewPagerAdapter(getFragmentManager());

        gamesViewPagerAdapter.addFragment(new UpcomingGameFragment(), "Kommande matcher");
        gamesViewPagerAdapter.addFragment(new HistoryGameFragment(), "Tidigare matcher");

        gamesViewPager.setAdapter(gamesViewPagerAdapter);
        gamesTabLayout.setupWithViewPager(gamesViewPager);

        /*gamesRecyclerView = rootView.findViewById(R.id.games_recyclerView);
        gamesRecyclerView.setHasFixedSize(true);
        gamesRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());    //getActivity instead of this when used in fragment?
        gamesRecyclerViewAdapter = new GamesAdapter(PadelBuddy.getInstance().getGames());

        gamesRecyclerView.setLayoutManager(gamesRecyclerViewLayoutManager);
        gamesRecyclerView.setAdapter(gamesRecyclerViewAdapter);*/

        return rootView;
    }
}
