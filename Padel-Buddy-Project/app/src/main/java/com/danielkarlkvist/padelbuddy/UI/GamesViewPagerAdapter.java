package com.danielkarlkvist.padelbuddy.UI;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * The GamesViewPagerAdapter class defines an adapter between a ViewPager and a Fragment
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-10-05
 */
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

    /**
     * Add new tab-fragments. Used in GamesFragment to createTestData tabs
     *
     * @param fragment current fragment
     * @param title    title of the new fragment
     */
    public void addFragment(Fragment fragment, String title) {
        tabFragments.add(fragment);
        tabFragmentTitles.add(title);
    }
}
