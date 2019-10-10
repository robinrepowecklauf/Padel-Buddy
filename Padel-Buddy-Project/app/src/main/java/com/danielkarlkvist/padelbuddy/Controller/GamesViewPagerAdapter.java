package com.danielkarlkvist.padelbuddy.Controller;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GamesViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> tabFragments = new ArrayList<>();
    List<String> tabFragmentTitles = new ArrayList<>();

    public GamesViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return tabFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabFragmentTitles.get(position);
    }

    @Override
    public int getCount() {
        return tabFragmentTitles.size();
    }

    public void addFragment(Fragment fragment, String title) {
        tabFragments.add(fragment);
        tabFragmentTitles.add(title);
    }
}