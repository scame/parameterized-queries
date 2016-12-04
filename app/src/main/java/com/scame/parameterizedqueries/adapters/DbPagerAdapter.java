package com.scame.parameterizedqueries.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.scame.parameterizedqueries.fragments.DbManagerFragment;
import com.scame.parameterizedqueries.fragments.QueryFragment;

public class DbPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 2;

    private String [] pageTitles = {"Manage", "Query"};

    private Context context;

    public DbPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return position == 0 ? new DbManagerFragment() : new QueryFragment();
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
