package com.scame.parameterizedqueries.presenters;


import com.scame.parameterizedqueries.models.queries.EighthQueryModel;
import com.scame.parameterizedqueries.models.queries.FifthQueryModel;
import com.scame.parameterizedqueries.models.queries.FirstQueryModel;
import com.scame.parameterizedqueries.models.queries.FourthQueryModel;
import com.scame.parameterizedqueries.models.queries.SecondQueryModel;
import com.scame.parameterizedqueries.models.queries.SeventhQueryModel;
import com.scame.parameterizedqueries.models.queries.SixthQueryModel;
import com.scame.parameterizedqueries.models.queries.ThirdQueryModel;

import java.util.List;

public interface QueriesPresenter<T> extends Presenter<T> {

    interface QueriesView {

        void displayFirstQueryResult(List<FirstQueryModel> firstQueryModels);

        void displaySecondQueryResult(List<SecondQueryModel> secondQueryModels);

        void displayThirdQueryResult(List<ThirdQueryModel> thirdQueryModels);

        void displayFourthQueryResult(List<FourthQueryModel> fourthQueryModels);

        void displayFifthQueryResult(List<FifthQueryModel> fifthQueryModels);

        void displaySixthQueryResult(List<SixthQueryModel> sixthQueryModels);

        void displaySeventhQueryResult(List<SeventhQueryModel> seventhQueryModels);

        void displayEighthQueryResult(List<EighthQueryModel> eighthQueryModels);

        void reportError(String error);
    }

    void execFirstQuery(int nativeSpeakers);

    void execSecondQuery(String languageFamily);

    void execThirdQuery(int countriesNumber);

    void execFourthQuery(int capitalPopulation);

    void execFifthQuery(int countryPopulation);

    void execSixthQuery(String countryName);

    void execSeventhQuery(int countryPopulation);

    void execEighthQuery(String languageFamily);
}
