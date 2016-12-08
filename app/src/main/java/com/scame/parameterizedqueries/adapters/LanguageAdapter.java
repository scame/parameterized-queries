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

    private static final int ITEM_VIEW_HEADER = 0;
    private static final int ITEM_VIEW_DATA = 1;

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

    private static class LanguagesHeaderHolder extends RecyclerView.ViewHolder {
        public LanguagesHeaderHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == ITEM_VIEW_HEADER) {
            View itemView = inflater.inflate(R.layout.language_table_header, parent, false);
            viewHolder = new LanguagesHeaderHolder(itemView);
        } else if (viewType == ITEM_VIEW_DATA) {
            View itemView = inflater.inflate(R.layout.language_table_row, parent, false);
            viewHolder = new LanguagesHolder(itemView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LanguagesHolder) {
            bindLanguagesHolder((LanguagesHolder) holder, languages.get(position - 1));
        }
    }

    private void bindLanguagesHolder(LanguagesHolder languagesHolder, LanguageModel model) {
        if (model.getId() != -1) {
            languagesHolder.languageId.setText(String.valueOf(model.getId()));
            languagesHolder.languageName.setText(model.getName());
            languagesHolder.languageFamily.setText(model.getLanguageFamily());
            languagesHolder.nativeSpeakers.setText(String.valueOf(model.getNativeSpeakers()));
        } else {
            languagesHolder.languageId.setClickable(true);
            languagesHolder.languageId.setFocusable(true);
        }
    }

    @Override
    public int getItemCount() {
        return languages == null ? 1 : languages.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ITEM_VIEW_HEADER : ITEM_VIEW_DATA;
    }
}
