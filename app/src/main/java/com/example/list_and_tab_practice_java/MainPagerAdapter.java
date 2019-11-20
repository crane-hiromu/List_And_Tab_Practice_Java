package com.example.list_and_tab_practice_java;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.list_and_tab_practice_java.fragments.list.MainListFragment;
import com.example.list_and_tab_practice_java.fragments.recycle.MainRecycleFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private CharSequence[] tabTitles = {"list", "list+holder", "list+binding", "recycle"};

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
            case 1:
            case 2:
                return new MainListFragment(position);
            case 3:
                return new MainRecycleFragment();
            default:
                return null;
        }
    }
}
