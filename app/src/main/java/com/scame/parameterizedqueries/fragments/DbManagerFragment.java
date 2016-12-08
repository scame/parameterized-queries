package com.scame.parameterizedqueries.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.activities.TabsActivity;
import com.scame.parameterizedqueries.adapters.CapitalAdapter;
import com.scame.parameterizedqueries.adapters.CountryAdapter;
import com.scame.parameterizedqueries.adapters.CountryLanguagesAdapter;
import com.scame.parameterizedqueries.adapters.LanguageAdapter;
import com.scame.parameterizedqueries.models.CapitalModel;
import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.models.CountryModel;
import com.scame.parameterizedqueries.models.LanguageModel;
import com.scame.parameterizedqueries.presenters.DbManagerPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DbManagerFragment extends Fragment implements DbManagerPresenter.DbManagerView {

    private static final int COUNTRY_INDEX = 0;
    private static final int LANGUAGE_INDEX = 1;
    private static final int CAPITAL_INDEX = 2;
    private static final int COUNTRY_LANGS_INDEX = 3;

    @BindView(R.id.db_manager_recycler)
    RecyclerView dbManagerRv;

    @BindView(R.id.tables_spinner)
    Spinner tablesSpinner;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    DbManagerPresenter<DbManagerPresenter.DbManagerView> presenter;

    private CapitalAdapter capitalAdapter;

    private CountryAdapter countryAdapter;

    private LanguageAdapter languageAdapter;

    private CountryLanguagesAdapter countryLanguagesAdapter;

    private List<CapitalModel> capitals;

    private List<CountryModel> countries;

    private List<LanguageModel> languages;

    private List<CountryLanguagesModel> countryLanguages;

    private String[] tablesArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.db_manager_layout, container, false);
        ButterKnife.bind(this, fragmentView);
        inject();
        presenter.setView(this);
        setupSpinnerListener();
        tablesArray = getResources().getStringArray(R.array.tables_array);

        return fragmentView;
    }

    private void setupSpinnerListener() {
        tablesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedTable = parent.getItemAtPosition(position).toString();

                if (selectedTable.equals(tablesArray[COUNTRY_INDEX])) {
                    presenter.requestCountryData();
                } else if (selectedTable.equals(tablesArray[LANGUAGE_INDEX])) {
                    presenter.requestLanguageData();
                } else if (selectedTable.equals(tablesArray[CAPITAL_INDEX])) {
                    presenter.requestCapitalData();
                } else if (selectedTable.equals(tablesArray[COUNTRY_LANGS_INDEX])) {
                    presenter.requestCountryLangsData();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void inject() {
        if (getActivity() instanceof TabsActivity) {
            ((TabsActivity) getActivity()).getDbManagerComponent().inject(this);
        }
    }

    @Override
    public void displayCountryData(List<CountryModel> countries) {
        Log.i("onxCountryData", countries.size() + "");
        this.countries = countries;
        countryAdapter = new CountryAdapter(countries);
        initRecycler(countryAdapter);
    }

    @Override
    public void displayCapitalData(List<CapitalModel> capitals) {
        Log.i("onxCapitalData", capitals.size() + "");
        this.capitals = capitals;
        capitalAdapter = new CapitalAdapter(capitals);
        initRecycler(capitalAdapter);
    }

    @Override
    public void displayLanguageData(List<LanguageModel> languages) {
        Log.i("onxLang", languages.size() + "");
        this.languages = languages;
        languageAdapter = new LanguageAdapter(languages);
        initRecycler(languageAdapter);
    }

    @Override
    public void displayCountryLangsData(List<CountryLanguagesModel> countryLanguages) {
        Log.i("onxCountryLangs", countryLanguages.size() + "");
        this.countryLanguages = countryLanguages;
        countryLanguagesAdapter = new CountryLanguagesAdapter(countryLanguages);
        initRecycler(countryLanguagesAdapter);
    }

    private void initRecycler(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        dbManagerRv.setAdapter(adapter);
        dbManagerRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
