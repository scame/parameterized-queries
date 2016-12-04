package com.scame.parameterizedqueries.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.adapters.DbPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabsActivity extends AppCompatActivity {

    private static final String DB_MANAGER_FRAGM = "dbManagerFragment";
    private static final String QUERY_FRAGMENT = "queryFragment";

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.sliding_tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_activity_layout);
        ButterKnife.bind(this);

        setupPages();
    }

    private void setupPages() {
        viewPager.setAdapter(new DbPagerAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(viewPager);
    }
}
