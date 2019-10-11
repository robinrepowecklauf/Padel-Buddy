package com.danielkarlkvist.padelbuddy.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.R;
import com.google.android.material.tabs.TabLayout;

public class GamesFragment extends Fragment implements ScrollToTop {

    private TabLayout gamesTabLayout;
    private ViewPager gamesViewPager;

    private GamesViewPagerAdapter gamesViewPagerAdapter;
    private GameRecyclerViewFragment upcomingGameFragment = new GameRecyclerViewFragment(R.layout.games_game_tab, R.id.games_recyclerView, PadelBuddy.getInstance().getUpcomingGames());
    private GameRecyclerViewFragment historyGameFragment = new GameRecyclerViewFragment(R.layout.games_game_tab, R.id.games_recyclerView, PadelBuddy.getInstance().getPlayedGames());


    boolean hasOpenedController = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        gamesTabLayout = rootView.findViewById(R.id.games_tablayout);
        gamesViewPager = rootView.findViewById(R.id.games_viewpager);

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


    @Override
    public void scrollToTop() {
        GameRecyclerViewFragment temp;
        for (int i = 0; i < gamesViewPagerAdapter.tabFragments.size(); i++) {
            if ( i == gamesTabLayout.getSelectedTabPosition()) {
                temp = (GameRecyclerViewFragment) gamesViewPagerAdapter.getItem(i);
                temp.getGameRecyclerViewLayoutManager().smoothScrollToPosition(temp.getGameRecyclerView(), null, 0);
            }

        }
    }


}
