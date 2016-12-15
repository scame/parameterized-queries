package com.scame.parameterizedqueries.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.models.CountryModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_VIEW_HEADER = 0;
    private static final int ITEM_VIEW_DATA = 1;

    private List<CountryModel> countries;

    private TextChangedListener textListener;

    public CountryAdapter(List<CountryModel> countries, TextChangedListener textListener) {
        this.countries = countries;
        this.textListener = textListener;
    }

    public static class CountriesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.country_id_tv)
        EditText countryId;

        @BindView(R.id.country_name_tv)
        EditText countryName;

        @BindView(R.id.country_population_tv)
        EditText countryPopulation;

        private EditTextWatcher editTextWatcher;

        public CountriesHolder(View itemView, TextChangedListener textListener) {
            super(itemView);
            editTextWatcher = new EditTextWatcher(textListener, this);
            ButterKnife.bind(this, itemView);

            countryId.addTextChangedListener(editTextWatcher);
            countryName.addTextChangedListener(editTextWatcher);
            countryPopulation.addTextChangedListener(editTextWatcher);
        }

        public boolean validate() {
            return !(!countryId.getText().toString().matches("^-?\\d+$")
                    || countryName.getText().toString().isEmpty()
                    || !countryPopulation.getText().toString().matches("^-?\\d+$"));
        }

        public CountryModel getCountryModel() {
            return new CountryModel(Integer.valueOf(countryId.getText().toString()),
                    countryName.getText().toString(),
                    Integer.valueOf(countryPopulation.getText().toString()));
        }
    }

    private static class CountriesHeaderHolder extends RecyclerView.ViewHolder {
        public CountriesHeaderHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == ITEM_VIEW_HEADER) {
            View itemView = inflater.inflate(R.layout.country_table_header, parent, false);
            viewHolder = new CountriesHeaderHolder(itemView);
        } else if (viewType == ITEM_VIEW_DATA) {
            View itemView = inflater.inflate(R.layout.country_table_row, parent, false);
            viewHolder = new CountriesHolder(itemView, textListener);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CountriesHolder) {
            bindCountriesHolder((CountriesHolder) holder, countries.get(position - 1));
        }
    }

    private void bindCountriesHolder(CountriesHolder countriesHolder, CountryModel model) {
        if (model.getId() != -1) {
            countriesHolder.countryId.setText(String.valueOf(model.getId()));
            countriesHolder.countryName.setText(model.getName());
            countriesHolder.countryPopulation.setText(String.valueOf(model.getPopulation()));
        }
    }

    @Override
    public int getItemCount() {
        return countries == null ? 1 : countries.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ITEM_VIEW_HEADER : ITEM_VIEW_DATA;
    }
}
