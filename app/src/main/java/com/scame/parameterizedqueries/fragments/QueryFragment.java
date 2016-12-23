package com.scame.parameterizedqueries.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

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

public class QueryFragment extends Fragment implements QueriesPresenter.QueriesView {

    @BindView(R.id.query_recycler)
    RecyclerView queryRv;

    @BindView(R.id.queries_spinner)
    Spinner queriesSpinner;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.query_input)
    EditText queryInput;

    @BindView(R.id.exec_query_btn)
    ImageButton execQueryBtn;

    @Inject
    QueriesPresenter<QueriesPresenter.QueriesView> presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.query_layout, container, false);
        ButterKnife.bind(this, fragmentView);
        inject();
        presenter.setView(this);

        return fragmentView;
    }

    private void inject() {
        if (getActivity() instanceof TabsActivity) {
            ((TabsActivity) getActivity()).getQueriesComponent().inject(this);
        }
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

    }
}
