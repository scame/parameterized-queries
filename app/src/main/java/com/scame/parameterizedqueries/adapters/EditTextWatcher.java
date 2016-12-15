package com.scame.parameterizedqueries.adapters;


import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;

public class EditTextWatcher implements TextWatcher {

    private TextChangedListener textListener;

    private RecyclerView.ViewHolder viewHolder;

    public EditTextWatcher(TextChangedListener textListener, RecyclerView.ViewHolder viewHolder) {
        this.textListener = textListener;
        this.viewHolder = viewHolder;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        textListener.onTextChange(viewHolder.getAdapterPosition(), s.length());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
