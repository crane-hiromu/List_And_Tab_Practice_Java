package com.example.list_and_tab_practice_java;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.list_and_tab_practice_java.Fragments.MainPageListFragment;
import com.example.list_and_tab_practice_java.Fragments.MainPageRecycleFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private CharSequence[] tabTitles = {"タブ1", "タブ2"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // MARK: FragmentPagerAdapter

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainPageListFragment();
            case 1:
                return new MainPageRecycleFragment();
            default:
                return null;
        }
    }
}
