package com.scame.parameterizedqueries.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.models.CountryLanguagesModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryLanguagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CountryLanguagesModel> countryLanguages;

    public CountryLanguagesAdapter(List<CountryLanguagesModel> countryLanguages) {
        this.countryLanguages = countryLanguages;
    }

    private static class CountryLanguagesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.country_lang_id_tv)
        TextView id;

        @BindView(R.id.country_id_tv)
        TextView countryId;

        @BindView(R.id.language_id_tv)
        TextView languageId;

        public CountryLanguagesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_languages_layout, parent, false);
        return new CountryLanguagesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountryLanguagesHolder countryLanguagesHolder = ((CountryLanguagesHolder) holder);
        CountryLanguagesModel model = countryLanguages.get(position);

        countryLanguagesHolder.id.setText(model.getId());
        countryLanguagesHolder.countryId.setText(model.getCountryId());
        countryLanguagesHolder.languageId.setText(model.getLanguageId());
    }

    @Override
    public int getItemCount() {
        return countryLanguages == null ? 0 : countryLanguages.size();
    }
}
