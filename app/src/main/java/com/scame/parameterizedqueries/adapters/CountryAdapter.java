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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_table_row, parent, false);
        return new CountriesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountriesHolder countriesHolder = ((CountriesHolder) holder);
        CountryModel model = countries.get(position);

        countriesHolder.countryId.setText(model.getId());
        countriesHolder.countryName.setText(model.getName());
        countriesHolder.countryPopulation.setText(model.getPopulation());
    }

    @Override
    public int getItemCount() {
        return countries == null ? 0 : countries.size();
    }
}
