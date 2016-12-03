package com.scame.parameterizedqueries.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scame.parameterizedqueries.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DatabaseOptionsFragment extends Fragment {

    public static final String QUERY_OPTION = "query";
    public static final String UPDATE_OPTION = "update";
    public static final String DELETE_OPTION = "delete";
    public static final String INSERT_OPTION = "insert";

    @BindView(R.id.query_db_tv)
    TextView queryDbTv;

    @BindView(R.id.delete_tv)
    TextView deleteRecordsTv;

    @BindView(R.id.insert_tv)
    TextView insertRecordsTv;

    @BindView(R.id.update_tv)
    TextView updateRecordsTv;

    private DatabaseOptionsListener optionsListener;

    public interface DatabaseOptionsListener {

        void onOptionClick(String databaseOption);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DatabaseOptionsListener) {
            optionsListener = ((DatabaseOptionsListener) context);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.database_options, container, false);
        ButterKnife.bind(this, fragmentView);
        setOptionsListeners();

        return fragmentView;
    }

    private void setOptionsListeners() {
        queryDbTv.setOnClickListener(v -> optionsListener.onOptionClick(QUERY_OPTION));
        deleteRecordsTv.setOnClickListener(v -> optionsListener.onOptionClick(DELETE_OPTION));
        insertRecordsTv.setOnClickListener(v -> optionsListener.onOptionClick(INSERT_OPTION));
        updateRecordsTv.setOnClickListener(v -> optionsListener.onOptionClick(UPDATE_OPTION));
    }
}
