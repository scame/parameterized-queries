package com.scame.parameterizedqueries.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scame.parameterizedqueries.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DbManagerFragment extends Fragment {

    @BindView(R.id.db_manager_recycler)
    RecyclerView dbManagerRv;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.db_manager_layout, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }
}
