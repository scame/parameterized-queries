package com.scame.parameterizedqueries.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.scame.parameterizedqueries.R;
import com.scame.parameterizedqueries.activities.TabsActivity;
import com.scame.parameterizedqueries.models.queries.EighthQueryModel;
import com.scame.parameterizedqueries.models.queries.FifthQueryModel;
import com.scame.parameterizedqueries.models.queries.FirstQueryModel;
import com.scame.parameterizedqueries.models.queries.FourthQueryModel;
import com.scame.parameterizedqueries.models.queries.SecondQueryModel;
import com.scame.parameterizedqueries.models.queries.SeventhQueryModel;
import com.scame.parameterizedqueries.models.queries.SixthQueryModel;
import com.scame.parameterizedqueries.models.queries.ThirdQueryModel;
import com.scame.parameterizedqueries.presenters.QueriesPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QueryFragment extends Fragment implements QueriesPresenter.QueriesView {

    @BindView(R.id.queries_spinner)
    Spinner queriesSpinner;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.query_param_input)
    EditText queryParamInput;

    @BindView(R.id.query_text)
    TextView queryText;

    @BindView(R.id.exec_btn)
    Button execButton;

    @Inject
    QueriesPresenter<QueriesPresenter.QueriesView> presenter;

    private String[] queriesArray;

    private String[] queriesDescriptionArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.query_layout, container, false);
        ButterKnife.bind(this, fragmentView);
        inject();
        presenter.setView(this);
        queriesArray = getResources().getStringArray(R.array.queries_array);
        queriesDescriptionArray = getResources().getStringArray(R.array.queries_description_array);
        setupSpinnerListener();

        return fragmentView;
    }

    private void inject() {
        if (getActivity() instanceof TabsActivity) {
            ((TabsActivity) getActivity()).getQueriesComponent().inject(this);
        }
    }

    @OnClick(R.id.exec_btn)
    void onExecClick(View view) {
        if (validate()) {
            runQuery();
        } else {
            Toast.makeText(getContext(), "input is not valid", Toast.LENGTH_SHORT).show();
        }
    }

    private void runQuery() {
        switch (queriesSpinner.getSelectedItemPosition()) {
            case 0:
                presenter.execFirstQuery(Integer.valueOf(queryParamInput.getText().toString()));
                break;
            case 1:
                presenter.execSecondQuery(queryParamInput.getText().toString());
                break;
            case 2:
                presenter.execThirdQuery(Integer.valueOf(queryParamInput.getText().toString()));
                break;
            case 3:
                presenter.execFourthQuery(Integer.valueOf(queryParamInput.getText().toString()));
                break;
            case 4:
                presenter.execFifthQuery(Integer.valueOf(queryParamInput.getText().toString()));
                break;
            case 5:
                presenter.execSixthQuery(queryParamInput.getText().toString());
                break;
            case 6:
                presenter.execSeventhQuery(Integer.valueOf(queryParamInput.getText().toString()));
                break;
            case 7:
                presenter.execEighthQuery(queryParamInput.getText().toString());
                break;
        }
    }

    private boolean validate() {
        int position = queriesSpinner.getSelectedItemPosition();

        if (position == 0 || position == 2 || position == 3 || position == 4 || position == 6) {
            return validateAsNumber();
        } else {
            return validateAsString();
        }
    }

    private boolean validateAsString() {
        return !queryParamInput.getText().toString().isEmpty();
    }

    private boolean validateAsNumber() {
        return (validateAsString() && queryParamInput.getText().toString().matches("^-?\\d+$"));
    }

    private void setupSpinnerListener() {
        queriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                queryText.setText(queriesDescriptionArray[position]);
                queryParamInput.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void displayFirstQueryResult(List<FirstQueryModel> firstQueryModels) {
    }

    @Override
    public void displaySecondQueryResult(List<SecondQueryModel> secondQueryModels) {
    }

    @Override
    public void displayThirdQueryResult(List<ThirdQueryModel> thirdQueryModels) {
    }

    @Override
    public void displayFourthQueryResult(List<FourthQueryModel> fourthQueryModels) {
    }

    @Override
    public void displayFifthQueryResult(List<FifthQueryModel> fifthQueryModels) {
    }

    @Override
    public void displaySixthQueryResult(List<SixthQueryModel> sixthQueryModels) {
    }

    @Override
    public void displaySeventhQueryResult(List<SeventhQueryModel> seventhQueryModels) {
    }

    @Override
    public void displayEighthQueryResult(List<EighthQueryModel> eighthQueryModels) {
    }

    @Override
    public void reportError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }
}
