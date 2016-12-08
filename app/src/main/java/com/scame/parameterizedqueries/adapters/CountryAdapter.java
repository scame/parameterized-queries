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

    public CountryAdapter(List<CountryModel> countries) {
        this.countries = countries;
    }

    static class CountriesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.country_id_tv)
        EditText countryId;

        @BindView(R.id.country_name_tv)
        EditText countryName;

        @BindView(R.id.country_population_tv)
        EditText countryPopulation;

        public CountriesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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
            viewHolder = new CountriesHolder(itemView);
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
        countriesHolder.countryId.setText(model.getId());
        countriesHolder.countryName.setText(model.getName());
        countriesHolder.countryPopulation.setText(model.getPopulation());
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
