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

    private TextChangedListener textListener;

    public LanguageAdapter(List<LanguageModel> languages, TextChangedListener textListener) {
        this.languages = languages;
        this.textListener = textListener;
    }

    public static class LanguagesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.language_id_tv)
        EditText languageId;

        @BindView(R.id.language_name_tv)
        EditText languageName;

        @BindView(R.id.native_speakers_tv)
        EditText nativeSpeakers;

        @BindView(R.id.language_family_tv)
        EditText languageFamily;

        private EditTextWatcher editTextWatcher;

        public LanguagesHolder(View itemView, TextChangedListener textListener) {
            super(itemView);
            editTextWatcher = new EditTextWatcher(textListener, this);
            ButterKnife.bind(this, itemView);

            languageId.addTextChangedListener(editTextWatcher);
            languageName.addTextChangedListener(editTextWatcher);
            nativeSpeakers.addTextChangedListener(editTextWatcher);
            languageFamily.addTextChangedListener(editTextWatcher);
        }

        public boolean validate() {
            return !(languageName.getText().toString().isEmpty() ||
                    !nativeSpeakers.getText().toString().matches("^-?\\d+$") ||
                    languageFamily.getText().toString().isEmpty());
        }

        public LanguageModel getLanguageModel() {
            int id = languageId.getText().toString().isEmpty() ? 0 : Integer.valueOf(languageId.getText().toString());
            return new LanguageModel(id, languageName.getText().toString(),
                    Integer.valueOf(nativeSpeakers.getText().toString()),
                    languageFamily.getText().toString());
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
            viewHolder = new LanguagesHolder(itemView, textListener);
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
            languagesHolder.languageId.setText("");
            languagesHolder.languageName.setText("");
            languagesHolder.languageFamily.setText("");
            languagesHolder.nativeSpeakers.setText("");
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
