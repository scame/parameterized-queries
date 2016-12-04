package com.scame.parameterizedqueries.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.models.CapitalModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CapitalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CapitalModel> capitals;

    public CapitalAdapter(List<CapitalModel> capitals) {
        this.capitals = capitals;
    }

    private static class CapitalsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.capital_id_tv)
        EditText capitalId;

        @BindView(R.id.country_id_tv)
        EditText countryId;

        @BindView(R.id.capital_name_tv)
        EditText capitalName;

        @BindView(R.id.capital_population_tv)
        EditText capitalPopulation;

        public CapitalsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.capital_table_row, parent, false);
        return new CapitalsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CapitalsHolder capitalsHolder = ((CapitalsHolder) holder);
        CapitalModel model = capitals.get(position);

        capitalsHolder.capitalId.setText(model.getId());
        capitalsHolder.countryId.setText(model.getCountryId());
        capitalsHolder.capitalName.setText(model.getName());
        capitalsHolder.capitalPopulation.setText(model.getPopulation());
    }

    @Override
    public int getItemCount() {
        return capitals == null ? 0 : capitals.size();
    }
}
