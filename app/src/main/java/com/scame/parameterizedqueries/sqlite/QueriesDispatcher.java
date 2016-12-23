package com.scame.parameterizedqueries.sqlite;


import com.scame.parameterizedqueries.models.queries.EighthQueryModel;
import com.scame.parameterizedqueries.models.queries.FifthQueryModel;
import com.scame.parameterizedqueries.models.queries.FirstQueryModel;
import com.scame.parameterizedqueries.models.queries.FourthQueryModel;
import com.scame.parameterizedqueries.models.queries.SecondQueryModel;
import com.scame.parameterizedqueries.models.queries.SeventhQueryModel;
import com.scame.parameterizedqueries.models.queries.SixthQueryModel;
import com.scame.parameterizedqueries.models.queries.ThirdQueryModel;
import com.scame.parameterizedqueries.sqlite.queries.EighthQuery;
import com.scame.parameterizedqueries.sqlite.queries.FifthQuery;
import com.scame.parameterizedqueries.sqlite.queries.FirstQuery;
import com.scame.parameterizedqueries.sqlite.queries.FourthQuery;
import com.scame.parameterizedqueries.sqlite.queries.SecondQuery;
import com.scame.parameterizedqueries.sqlite.queries.SeventhQuery;
import com.scame.parameterizedqueries.sqlite.queries.SixthQuery;
import com.scame.parameterizedqueries.sqlite.queries.ThirdQuery;

import java.util.List;

public class QueriesDispatcher {

    private final FirstQuery firstQuery;

    private final SecondQuery secondQuery;

    private final ThirdQuery thirdQuery;

    private final FourthQuery fourthQuery;

    private final FifthQuery fifthQuery;

    private final SixthQuery sixthQuery;

    private final SeventhQuery seventhQuery;

    private final EighthQuery eighthQuery;

    public QueriesDispatcher(DatabaseOpenHelper openHelper) {
        this.firstQuery = new FirstQuery(openHelper);
        this.secondQuery = new SecondQuery(openHelper);
        this.thirdQuery = new ThirdQuery(openHelper);
        this.fourthQuery = new FourthQuery(openHelper);
        this.fifthQuery = new FifthQuery(openHelper);
        this.sixthQuery = new SixthQuery(openHelper);
        this.seventhQuery = new SeventhQuery(openHelper);
        this.eighthQuery = new EighthQuery(openHelper);
    }

    public List<FirstQueryModel> execFirstQuery(int nativeSpeakers) {
        return firstQuery.execFirstQuery(nativeSpeakers);
    }

    public List<SecondQueryModel> execSecondQuery(String languageFamily) {
        return secondQuery.execSecondQuery(languageFamily);
    }

    public List<ThirdQueryModel> execThirdQuery(int countriesNumber) {
        return thirdQuery.execThirdQuery(countriesNumber);
    }

    public List<FourthQueryModel> execFourthQuery(int capitalPopulation) {
        return fourthQuery.execFourthQuery(capitalPopulation);
    }

    public List<FifthQueryModel> execFifthQuery(int countryPopulation) {
        return fifthQuery.execFifthQuery(countryPopulation);
    }

    public List<SixthQueryModel> execSixthQuery(String countryName) {
        return sixthQuery.execSixthQuery(countryName);
    }

    public List<SeventhQueryModel> execSeventhQuery(int countryPopulation) {
        return seventhQuery.execSeventhQuery(countryPopulation);
    }

    public List<EighthQueryModel> execEighthQuery(String languageFamily) {
        return eighthQuery.execEighthQuery(languageFamily);
    }
}
