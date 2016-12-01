package com.scame.parameterizedqueries.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.fragments.DeletionFragment;
import com.scame.parameterizedqueries.fragments.InsertionFragment;
import com.scame.parameterizedqueries.fragments.QueryFragment;
import com.scame.parameterizedqueries.fragments.UpdateFragment;

public class DatabaseOptionsActivity extends AppCompatActivity implements DatabaseOptionsFragment.DatabaseOptionsListener {

    private static final String DATABASE_OPTIONS_FRAGM = "dbOptionsFragment";
    private static final String DELETION_FRAGM = "deletionFragment";
    private static final String INSERTION_FRAGM = "insertionFragment";
    private static final String QUERY_FRAGMENT = "queryFragment";
    private static final String UPDATE_FRAGMENT = "updateFragment";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_activity_layout);

        setupDefaultFragment();
    }

    private void setupDefaultFragment() {
        if (getSupportFragmentManager().getFragments() == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_activity_fl, new DatabaseOptionsFragment(), DATABASE_OPTIONS_FRAGM)
                    .commit();
        }
    }

    private void replaceFragment(String tag, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_activity_fl, fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onOptionClick(String databaseOption) {
        switch (databaseOption) {
            case DatabaseOptionsFragment.DELETE_OPTION:
                replaceFragment(DELETION_FRAGM, new DeletionFragment());
                break;
            case DatabaseOptionsFragment.INSERT_OPTION:
                replaceFragment(INSERTION_FRAGM, new InsertionFragment());
                break;
            case DatabaseOptionsFragment.QUERY_OPTION:
                replaceFragment(QUERY_FRAGMENT, new QueryFragment());
                break;
            case DatabaseOptionsFragment.UPDATE_OPTION:
                replaceFragment(UPDATE_FRAGMENT, new UpdateFragment());
                break;
        }
    }
}
