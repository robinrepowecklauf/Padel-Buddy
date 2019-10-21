package com.danielkarlkvist.padelbuddy.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danielkarlkvist.padelbuddy.Model.IGame;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;

import java.util.List;

/**
 * The GameRecyclerViewFragment class defines a RecyclerView for games
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-10-11
 */

public class GameRecyclerViewFragment extends Fragment implements ITopScrollable {
    private PadelBuddy padelBuddy;
    private RecyclerView gameRecyclerView;
    private RecyclerView.Adapter gameRecyclerViewAdapter;
    private RecyclerView.LayoutManager gameRecyclerViewLayoutManager;

    private boolean joinable;

    private int fragmentId;
    private int recyclerViewId;
    private List<? extends IGame> games;

    public GameRecyclerViewFragment(int fragmentId, int recyclerViewId, List<? extends IGame> games, PadelBuddy padelBuddy, boolean joinable) {
        this.fragmentId = fragmentId;
        this.recyclerViewId = recyclerViewId;
        this.games = games;
        this.padelBuddy = padelBuddy;
        this.joinable = joinable;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(fragmentId, container, false);
        gameRecyclerView = rootView.findViewById(recyclerViewId);
        gameRecyclerView.setHasFixedSize(true);
        gameRecyclerViewLayoutManager = new LinearLayoutManager(getActivity());    //getActivity instead of this when used in fragment?
        gameRecyclerViewAdapter = new GameToRecyclerViewAdapter(games, padelBuddy, joinable, getContext());
        gameRecyclerView.setLayoutManager(gameRecyclerViewLayoutManager);
        gameRecyclerView.setAdapter(gameRecyclerViewAdapter);

        return rootView;
    }

    /**
     * Makes the user able to scroll to the top of the page if they click
     * on the BottomNavigationView icon that they are already inside of
     */

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
