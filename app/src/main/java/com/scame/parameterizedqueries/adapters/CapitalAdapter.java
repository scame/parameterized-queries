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

    private static final int ITEM_VIEW_HEADER = 0;
    private static final int ITEM_VIEW_DATA = 1;

    private List<CapitalModel> capitals;

    public CapitalAdapter(List<CapitalModel> capitals) {
        this.capitals = capitals;
    }

    static class CapitalsHolder extends RecyclerView.ViewHolder {

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

    private static class CapitalsHeaderHolder extends RecyclerView.ViewHolder {
        public CapitalsHeaderHolder(View itemView) {
            super(itemView);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == ITEM_VIEW_HEADER) {
            View itemView = inflater.inflate(R.layout.capital_table_header, parent, false);
            viewHolder = new CapitalsHeaderHolder(itemView);
        } else if (viewType == ITEM_VIEW_DATA) {
            View itemView = inflater.inflate(R.layout.capital_table_row, parent, false);
            viewHolder = new CapitalsHolder(itemView);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CapitalsHolder) {
            bindCapitalsHolder((CapitalsHolder) holder, capitals.get(position - 1));
        }
    }

    private void bindCapitalsHolder(CapitalsHolder capitalsHolder, CapitalModel model) {
        if (model.getId() != -1) {
            capitalsHolder.capitalId.setText(String.valueOf(model.getId()));
            capitalsHolder.countryId.setText(String.valueOf(model.getCountryId()));
            capitalsHolder.capitalName.setText(model.getName());
            capitalsHolder.capitalPopulation.setText(String.valueOf(model.getPopulation()));
        }
    }

    @Override
    public int getItemCount() {
        return capitals == null ? 1 : capitals.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ITEM_VIEW_HEADER : ITEM_VIEW_DATA;
    }
}
