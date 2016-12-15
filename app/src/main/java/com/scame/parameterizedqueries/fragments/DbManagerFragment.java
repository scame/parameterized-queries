package com.scame.parameterizedqueries.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.activities.TabsActivity;
import com.scame.parameterizedqueries.adapters.CapitalAdapter;
import com.scame.parameterizedqueries.adapters.CountryAdapter;
import com.scame.parameterizedqueries.adapters.CountryLanguagesAdapter;
import com.scame.parameterizedqueries.adapters.LanguageAdapter;
import com.scame.parameterizedqueries.adapters.TextChangedListener;
import com.scame.parameterizedqueries.models.CapitalModel;
import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.models.CountryModel;
import com.scame.parameterizedqueries.models.LanguageModel;
import com.scame.parameterizedqueries.presenters.DbManagerPresenter;

import java.util.Collections;
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

    private ActionMode currentActionMode;

    private CapitalAdapter capitalAdapter;

    private CountryAdapter countryAdapter;

    private LanguageAdapter languageAdapter;

    private CountryLanguagesAdapter countryLanguagesAdapter;

    private List<CapitalModel> capitals = Collections.emptyList();

    private List<CountryModel> countries = Collections.emptyList();

    private List<LanguageModel> languages = Collections.emptyList();

    private List<CountryLanguagesModel> countryLanguages = Collections.emptyList();

    private String[] tablesArray;

    private int editedItemPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.db_manager_layout, container, false);
        ButterKnife.bind(this, fragmentView);
        inject();
        presenter.setView(this);
        setupSpinnerListener();
        setupItemTouchHelper();
        tablesArray = getResources().getStringArray(R.array.tables_array);

        return fragmentView;
    }

    private void setupItemTouchHelper() {
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int adapterPosition = viewHolder.getAdapterPosition();
                String selectedTable = tablesSpinner.getSelectedItem().toString();
                processSwipedItem(selectedTable, adapterPosition);
            }


            @Override
            public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (isNotSwipeable(viewHolder.getAdapterPosition())) {
                    return 0;
                }
                return super.getSwipeDirs(recyclerView, viewHolder);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(dbManagerRv);
    }

    private void processSwipedItem(String selectedTable, int adapterPosition) {
        RecyclerView.ViewHolder viewHolder = dbManagerRv.findViewHolderForAdapterPosition(adapterPosition);

        if (selectedTable.equals(tablesArray[COUNTRY_INDEX])) {
            CountryAdapter.CountriesHolder holder = (CountryAdapter.CountriesHolder) viewHolder;
            presenter.deleteCountryRecord(holder.getCountryModel());
            presenter.requestCountryData();
        } else if (selectedTable.equals(tablesArray[LANGUAGE_INDEX])) {
            LanguageAdapter.LanguagesHolder holder = (LanguageAdapter.LanguagesHolder) viewHolder;
            presenter.deleteLanguageRecord(holder.getLanguageModel());
            presenter.requestLanguageData();

        } else if (selectedTable.equals(tablesArray[CAPITAL_INDEX])) {
            CapitalAdapter.CapitalsHolder holder = (CapitalAdapter.CapitalsHolder) viewHolder;
            presenter.deleteCapitalRecord(holder.getCapitalModel());
            presenter.requestCapitalData();

        } else if (selectedTable.equals(tablesArray[COUNTRY_LANGS_INDEX])) {
            CountryLanguagesAdapter.CountryLanguagesHolder holder = (CountryLanguagesAdapter.CountryLanguagesHolder) viewHolder;
            presenter.deleteCountryLangsRecord(holder.getCountryLanguagesModel());
            presenter.requestCountryLangsData();
        }
    }

    private boolean isNotSwipeable(int adapterPosition) {
        if (adapterPosition == 0) return true;

        String selectedTable = tablesSpinner.getSelectedItem().toString();
        if (selectedTable.equals(tablesArray[COUNTRY_INDEX])) {
            if (countries.size() == adapterPosition) return true;
        } else if (selectedTable.equals(tablesArray[LANGUAGE_INDEX])) {
            if (languages.size() == adapterPosition) return true;
        } else if (selectedTable.equals(tablesArray[CAPITAL_INDEX])) {
            if (capitals.size() == adapterPosition) return true;
        } else if (selectedTable.equals(tablesArray[COUNTRY_LANGS_INDEX])) {
            if (countryLanguages.size() == adapterPosition) return true;
        }
        return false;
    }

    private void setupSpinnerListener() {
        tablesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedTable = parent.getItemAtPosition(position).toString();
                requestTable(selectedTable);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void requestTable(String selectedTable) {
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

    private ActionMode.Callback modeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("Actions");
            mode.getMenuInflater().inflate(R.menu.actions_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }


        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_save_or_edit:
                    handleSaveOrEditClick();
                    mode.finish();
                    return true;
                case R.id.menu_cancel:
                    String selectedTable = tablesSpinner.getSelectedItem().toString();
                    requestTable(selectedTable);
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            currentActionMode = null;
        }
    };

    private void handleSaveOrEditClick() {
        String selectedTable = tablesSpinner.getSelectedItem().toString();
        if (selectedTable.equals(tablesArray[COUNTRY_INDEX])) {
            if (countries.size() == editedItemPosition) {
                handleCountryInsert();
            } else {
                handleCountryUpdate();
            }
        } else if (selectedTable.equals(tablesArray[LANGUAGE_INDEX])) {
            if (languages.size() == editedItemPosition) {
                handleLanguageInsert();
            } else {
                handleLanguageUpdate();
            }
        } else if (selectedTable.equals(tablesArray[CAPITAL_INDEX])) {
            if (capitals.size() == editedItemPosition) {
                handleCapitalInsert();
            } else {
                handleCapitalUpdate();
            }
        } else if (selectedTable.equals(tablesArray[COUNTRY_LANGS_INDEX])) {
            if (countryLanguages.size() == editedItemPosition) {
                handleCountryLangsInsert();
            } else {
                handleCountryLangsUpdate();
            }
        }
    }

    private void handleCountryLangsUpdate() {
        CountryLanguagesAdapter.CountryLanguagesHolder holder = (CountryLanguagesAdapter.CountryLanguagesHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.updateCountryLangsRecord(holder.getCountryLanguagesModel());
            presenter.requestCountryLangsData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }

    private void handleCountryLangsInsert() {
        CountryLanguagesAdapter.CountryLanguagesHolder holder = (CountryLanguagesAdapter.CountryLanguagesHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.addCountryLangsRecord(holder.getCountryLanguagesModel());
            presenter.requestCountryLangsData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }

    private void handleCapitalUpdate() {
        CapitalAdapter.CapitalsHolder holder = (CapitalAdapter.CapitalsHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.updateCapitalRecord(holder.getCapitalModel());
            presenter.requestCapitalData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }

    private void handleCapitalInsert() {
        CapitalAdapter.CapitalsHolder holder = (CapitalAdapter.CapitalsHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.addCapitalRecord(holder.getCapitalModel());
            presenter.requestCapitalData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }

    private void handleLanguageUpdate() {
        LanguageAdapter.LanguagesHolder holder = (LanguageAdapter.LanguagesHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.updateLanguageRecord(holder.getLanguageModel());
            presenter.requestLanguageData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }

    private void handleLanguageInsert() {
        LanguageAdapter.LanguagesHolder holder = (LanguageAdapter.LanguagesHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.addLanguageRecord(holder.getLanguageModel());
            presenter.requestLanguageData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }

    private void handleCountryInsert() {
        CountryAdapter.CountriesHolder holder = (CountryAdapter.CountriesHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.addCountryRecord(holder.getCountryModel());
            presenter.requestCountryData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }

    private void handleCountryUpdate() {
        CountryAdapter.CountriesHolder holder = (CountryAdapter.CountriesHolder) dbManagerRv
                .findViewHolderForAdapterPosition(editedItemPosition);
        if (holder.validate()) {
            presenter.updateCountryRecord(holder.getCountryModel());
            presenter.requestCountryData();
        } else {
            Toast.makeText(getContext(), "Validation failure", Toast.LENGTH_LONG).show();
        }
    }


    private void inject() {
        if (getActivity() instanceof TabsActivity) {
            ((TabsActivity) getActivity()).getDbManagerComponent().inject(this);
        }
    }

    @Override
    public void displayCountryData(List<CountryModel> countries) {
        this.countries = countries;
        countryAdapter = new CountryAdapter(countries, textListener);
        initRecycler(countryAdapter);
    }

    @Override
    public void displayCapitalData(List<CapitalModel> capitals) {
        this.capitals = capitals;
        capitalAdapter = new CapitalAdapter(capitals, textListener);
        initRecycler(capitalAdapter);
    }

    @Override
    public void displayLanguageData(List<LanguageModel> languages) {
        this.languages = languages;
        languageAdapter = new LanguageAdapter(languages, textListener);
        initRecycler(languageAdapter);
    }

    @Override
    public void displayCountryLangsData(List<CountryLanguagesModel> countryLanguages) {
        this.countryLanguages = countryLanguages;
        countryLanguagesAdapter = new CountryLanguagesAdapter(countryLanguages, textListener);
        initRecycler(countryLanguagesAdapter);
    }

    private void initRecycler(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        dbManagerRv.setAdapter(adapter);
        dbManagerRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private final TextChangedListener textListener = (adapterPosition, length) -> {
        if (currentActionMode == null || adapterPosition != editedItemPosition) {
            editedItemPosition = adapterPosition;
            currentActionMode = toolbar.startActionMode(modeCallBack);
        }
    };
}
