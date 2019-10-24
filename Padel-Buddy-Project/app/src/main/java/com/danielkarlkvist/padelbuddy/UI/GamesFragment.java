package com.danielkarlkvist.padelbuddy.UI;

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

/**
 * The GamesFragment class defines a tab layout for upcoming and recently played games
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-10-11
 */
public class GamesFragment extends Fragment implements ITopScrollable {
    private TabLayout gamesTabLayout;
    private ViewPager gamesViewPager;

    private GamesViewPagerAdapter gamesViewPagerAdapter;
    private GameRecyclerViewFragment upcomingGameFragment;
    private GameRecyclerViewFragment historyGameFragment;

    boolean hasOpenedController = false;
    private PadelBuddy padelBuddy;

    public GamesFragment(PadelBuddy padelBuddy) {
        this.padelBuddy = padelBuddy;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        gamesTabLayout = rootView.findViewById(R.id.games_tablayout);
        gamesViewPager = rootView.findViewById(R.id.games_viewpager);

        upcomingGameFragment = new GameRecyclerViewFragment(R.layout.games_game_tab, R.id.games_recyclerview, padelBuddy.getUpcomingGames(), padelBuddy, false);
        historyGameFragment = new GameRecyclerViewFragment(R.layout.games_game_tab, R.id.games_recyclerview, padelBuddy.getPlayedGames(), padelBuddy, false);

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
            if (i == gamesTabLayout.getSelectedTabPosition()) {
                temp = (GameRecyclerViewFragment) gamesViewPagerAdapter.getItem(i);
                temp.getGameRecyclerViewLayoutManager().smoothScrollToPosition(temp.getGameRecyclerView(), null, 0);
            }
        }
    }
}
