package com.scame.parameterizedqueries.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class QueryResultDialog extends DialogFragment {

    public QueryResultDialog() { }

    public static QueryResultDialog newInstance(String title) {
        QueryResultDialog frag = new QueryResultDialog();

        Bundle args = new Bundle();
        args.putString(QueryResultDialog.class.getCanonicalName(), title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String queryResultText = getArguments().getString(QueryResultDialog.class.getCanonicalName());
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Query result");
        alertDialogBuilder.setMessage(queryResultText);
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            dialog.dismiss();
        });

        return alertDialogBuilder.create();
    }
}
