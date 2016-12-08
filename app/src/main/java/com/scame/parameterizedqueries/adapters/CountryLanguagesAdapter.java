package com.scame.parameterizedqueries.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.models.CountryLanguagesModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryLanguagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_VIEW_HEADER = 0;
    private static final int ITEM_VIEW_DATA = 1;

    private List<CountryLanguagesModel> countryLanguages;

    public CountryLanguagesAdapter(List<CountryLanguagesModel> countryLanguages) {
        this.countryLanguages = countryLanguages;
    }

    static class CountryLanguagesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.country_lang_id_tv)
        EditText id;

        @BindView(R.id.country_id_tv)
        EditText countryId;

        @BindView(R.id.language_id_tv)
        EditText languageId;

        public CountryLanguagesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private static class CountryLanguagesHeaderHolder extends RecyclerView.ViewHolder {
        public CountryLanguagesHeaderHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == ITEM_VIEW_HEADER) {
            View itemView = inflater.inflate(R.layout.country_languages_header, parent, false);
            viewHolder = new CountryLanguagesHeaderHolder(itemView);
        } else if (viewType == ITEM_VIEW_DATA) {
            View itemView = inflater.inflate(R.layout.country_languages_row, parent, false);
            viewHolder = new CountryLanguagesHolder(itemView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CountryLanguagesHolder) {
            bindCountryLanguagesHolder((CountryLanguagesHolder) holder, countryLanguages.get(position - 1));
        }
    }

    private void bindCountryLanguagesHolder(CountryLanguagesHolder holder, CountryLanguagesModel model) {
        holder.id.setText(model.getId());
        holder.countryId.setText(model.getCountryId());
        holder.languageId.setText(model.getLanguageId());
    }

    @Override
    public int getItemCount() {
        return countryLanguages == null ? 1 : countryLanguages.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ITEM_VIEW_HEADER : ITEM_VIEW_DATA;
    }
}
