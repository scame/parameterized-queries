package com.scame.parameterizedqueries.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.adapters.CapitalAdapter;
import com.scame.parameterizedqueries.adapters.CountryAdapter;
import com.scame.parameterizedqueries.adapters.LanguageAdapter;
import com.scame.parameterizedqueries.models.CountryLanguagesModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DbManagerFragment extends Fragment {

    @BindView(R.id.db_manager_recycler)
    RecyclerView dbManagerRv;

    @BindView(R.id.tables_spinner)
    Spinner tablesSpinner;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private CapitalAdapter capitalAdapter;

    private CountryAdapter countryAdapter;

    private LanguageAdapter languageAdapter;

    private CountryLanguagesModel countryLanguagesModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.db_manager_layout, container, false);
        ButterKnife.bind(this, fragmentView);


        return fragmentView;
    }
}
