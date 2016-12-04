package com.scame.parameterizedqueries.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.scame.parameterizedqueries.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QueryFragment extends Fragment {

    @BindView(R.id.query_recycler)
    RecyclerView queryRv;

    @BindView(R.id.queries_spinner)
    Spinner queriesSpinner;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.query_input)
    EditText queryInput;

    @BindView(R.id.exec_query_btn)
    ImageButton execQueryBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.query_layout, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }
}
