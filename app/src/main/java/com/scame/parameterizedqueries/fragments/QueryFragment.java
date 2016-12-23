package com.scame.parameterizedqueries.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

    private String[] queriesDescriptionArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.query_layout, container, false);
        ButterKnife.bind(this, fragmentView);
        inject();
        presenter.setView(this);
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
        String firstQueryResult = buildFirstQueryResult(firstQueryModels);
        openQueryResultDialog(firstQueryResult);
    }

    private String buildFirstQueryResult(List<FirstQueryModel> firstQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (FirstQueryModel firstQueryModel : firstQueryModels) {
            builder.append(firstQueryModel.getCountry()).append(" ")
                    .append(firstQueryModel.getLanguage()).append(" ")
                    .append(firstQueryModel.getNativeSpeakers()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void displaySecondQueryResult(List<SecondQueryModel> secondQueryModels) {
        String secondQueryResult = buildSecondQueryResult(secondQueryModels);
        openQueryResultDialog(secondQueryResult);
    }

    private String buildSecondQueryResult(List<SecondQueryModel> secondQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (SecondQueryModel secondQueryModel : secondQueryModels) {
            builder.append(secondQueryModel.getCountry()).append(" ")
                    .append(secondQueryModel.getLanguageFamily()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void displayThirdQueryResult(List<ThirdQueryModel> thirdQueryModels) {
        String thirdQueryResult = buildThirdQueryResult(thirdQueryModels);
        openQueryResultDialog(thirdQueryResult);
    }

    private String buildThirdQueryResult(List<ThirdQueryModel> thirdQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (ThirdQueryModel thirdQueryModel : thirdQueryModels) {
            builder.append(thirdQueryModel.getLanguage()).append(" ")
                    .append(thirdQueryModel.getNumberOfCountries()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void displayFourthQueryResult(List<FourthQueryModel> fourthQueryModels) {
        String fourthQueryResult = buildFourthQueryResult(fourthQueryModels);
        openQueryResultDialog(fourthQueryResult);
    }

    private String buildFourthQueryResult(List<FourthQueryModel> fourthQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (FourthQueryModel fourthQueryModel : fourthQueryModels) {
            builder.append(fourthQueryModel.getLanguage()).append(" \n");
        }
        return builder.toString();
    }

    @Override
    public void displayFifthQueryResult(List<FifthQueryModel> fifthQueryModels) {
        String fifthQueryResult = buildFifthQueryResult(fifthQueryModels);
        openQueryResultDialog(fifthQueryResult);
    }

    private String buildFifthQueryResult(List<FifthQueryModel> fifthQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (FifthQueryModel fifthQueryModel : fifthQueryModels) {
            builder.append(fifthQueryModel.getCountry()).append(" ")
                    .append(fifthQueryModel.getCapital()).append(" ")
                    .append(fifthQueryModel.getCountryPopulation()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void displaySixthQueryResult(List<SixthQueryModel> sixthQueryModels) {
        String sixthQueryResult = buildSixthQueryResult(sixthQueryModels);
        openQueryResultDialog(sixthQueryResult);
    }

    private String buildSixthQueryResult(List<SixthQueryModel> sixthQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (SixthQueryModel sixthQueryModel : sixthQueryModels) {
            builder.append(sixthQueryModel.getCountry()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void displaySeventhQueryResult(List<SeventhQueryModel> seventhQueryModels) {
        String seventhQueryResult = buildSeventhQueryResult(seventhQueryModels);
        openQueryResultDialog(seventhQueryResult);
    }

    private String buildSeventhQueryResult(List<SeventhQueryModel> seventhQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (SeventhQueryModel seventhQueryModel : seventhQueryModels) {
            builder.append(seventhQueryModel.getLanguage()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void displayEighthQueryResult(List<EighthQueryModel> eighthQueryModels) {
        String eighthQueryResult = buildEighthQueryResult(eighthQueryModels);
        openQueryResultDialog(eighthQueryResult);
    }

    private String buildEighthQueryResult(List<EighthQueryModel> eighthQueryModels) {
        StringBuilder builder = new StringBuilder();

        for (EighthQueryModel eighthQueryModel : eighthQueryModels) {
            builder.append(eighthQueryModel.getCountry()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void reportError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    private void openQueryResultDialog(String queryResult) {
        FragmentManager fragmentManager = getChildFragmentManager();
        QueryResultDialog resultDialog = QueryResultDialog.newInstance(queryResult);
        resultDialog.show(fragmentManager, null);
    }
}
