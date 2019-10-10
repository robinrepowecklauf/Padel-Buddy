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

    private GamesViewPagerAdapter gamesViewPagerAdapter;
    private UpcomingGameFragment upcomingGameFragment = new UpcomingGameFragment();
    private UpcomingGameFragment historyGameFragment = new UpcomingGameFragment();

    boolean hasOpenedController = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        gamesTabLayout = rootView.findViewById(R.id.games_tablayout);
        gamesViewPager = rootView.findViewById(R.id.games_viewpager);

        upcomingGameFragment.setGames(PadelBuddy.getInstance().getUpcomingGames());
        historyGameFragment.setGames(PadelBuddy.getInstance().getPlayedGames());
        
        // Create a GamesViewPagerAdapter and add fragments with titles to it
        gamesViewPagerAdapter = new GamesViewPagerAdapter(getChildFragmentManager());
        gamesViewPagerAdapter.addFragment(upcomingGameFragment, "Kommande matcher");
        gamesViewPagerAdapter.addFragment(historyGameFragment, "Tidigare matcher");

        // Setup adapter
        gamesViewPager.setAdapter(gamesViewPagerAdapter);
        gamesTabLayout.setupWithViewPager(gamesViewPager);

        hasOpenedController = true;

        return rootView;
    }
}
