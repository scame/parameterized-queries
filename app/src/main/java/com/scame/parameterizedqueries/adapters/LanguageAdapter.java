package com.scame.parameterizedqueries.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.models.LanguageModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LanguageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<LanguageModel> languages;

    public LanguageAdapter(List<LanguageModel> languages) {
        this.languages = languages;
    }

    static class LanguagesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.language_id_tv)
        EditText languageId;

        @BindView(R.id.language_name_tv)
        EditText languageName;

        @BindView(R.id.native_speakers_tv)
        EditText nativeSpeakers;

        @BindView(R.id.language_family_tv)
        EditText languageFamily;

        public LanguagesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_table_row, parent, false);
        return new LanguagesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LanguagesHolder languagesHolder = ((LanguagesHolder) holder);
        LanguageModel model = languages.get(position);

        languagesHolder.languageId.setText(model.getId());
        languagesHolder.languageName.setText(model.getName());
        languagesHolder.languageFamily.setText(model.getLanguageFamily());
        languagesHolder.nativeSpeakers.setText(model.getNativeSpeakers());
    }

    @Override
    public int getItemCount() {
        return languages == null ? 0 : languages.size();
    }
}
