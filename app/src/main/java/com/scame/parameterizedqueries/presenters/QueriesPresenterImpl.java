package com.scame.parameterizedqueries.presenters;


import com.scame.parameterizedqueries.usecases.queries.EighthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.FifthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.FirstQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.FourthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.SecondQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.SeventhQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.SixthQueryUseCase;
import com.scame.parameterizedqueries.usecases.queries.ThirdQueryUseCase;

import rx.functions.Action1;

public class QueriesPresenterImpl<T extends QueriesPresenter.QueriesView> implements QueriesPresenter<T> {

    private T view;

    private FirstQueryUseCase firstQueryUseCase;
    private SecondQueryUseCase secondQueryUseCase;
    private ThirdQueryUseCase thirdQueryUseCase;
    private FourthQueryUseCase fourthQueryUseCase;
    private FifthQueryUseCase fifthQueryUseCase;
    private SixthQueryUseCase sixthQueryUseCase;
    private SeventhQueryUseCase seventhQueryUseCase;
    private EighthQueryUseCase eighthQueryUseCase;

    public QueriesPresenterImpl(FirstQueryUseCase firstQueryUseCase,
                                SecondQueryUseCase secondQueryUseCase,
                                ThirdQueryUseCase thirdQueryUseCase,
                                FourthQueryUseCase fourthQueryUseCase,
                                FifthQueryUseCase fifthQueryUseCase,
                                SixthQueryUseCase sixthQueryUseCase,
                                SeventhQueryUseCase seventhQueryUseCase,
                                EighthQueryUseCase eighthQueryUseCase) {
        this.firstQueryUseCase = firstQueryUseCase;
        this.secondQueryUseCase = secondQueryUseCase;
        this.thirdQueryUseCase = thirdQueryUseCase;
        this.fourthQueryUseCase = fourthQueryUseCase;
        this.fifthQueryUseCase = fifthQueryUseCase;
        this.sixthQueryUseCase = sixthQueryUseCase;
        this.seventhQueryUseCase = seventhQueryUseCase;
        this.eighthQueryUseCase = eighthQueryUseCase;
    }

    @Override
    public void execFirstQuery(int nativeSpeakers) {
        firstQueryUseCase.setNativeSpeakers(nativeSpeakers);
        firstQueryUseCase.executeSingle(firstQueryModels -> {
            if (view != null) view.displayFirstQueryResult(firstQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void execSecondQuery(String languageFamily) {
        secondQueryUseCase.setLanguageFamily(languageFamily);
        secondQueryUseCase.executeSingle(secondQueryModels -> {
            if (view != null) view.displaySecondQueryResult(secondQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void execThirdQuery(int countriesNumber) {
        thirdQueryUseCase.setCountriesNumber(countriesNumber);
        thirdQueryUseCase.executeSingle(thirdQueryModels -> {
            if (view != null) view.displayThirdQueryResult(thirdQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void execFourthQuery(int capitalPopulation) {
        fourthQueryUseCase.setCapitalPopulation(capitalPopulation);
        fourthQueryUseCase.executeSingle(fourthQueryModels -> {
            if (view != null) view.displayFourthQueryResult(fourthQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void execFifthQuery(int countryPopulation) {
        fifthQueryUseCase.setCountryPopulation(countryPopulation);
        fifthQueryUseCase.executeSingle(fifthQueryModels -> {
            if (view != null) view.displayFifthQueryResult(fifthQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void execSixthQuery(String countryName) {
        sixthQueryUseCase.setCountryName(countryName);
        sixthQueryUseCase.executeSingle(sixthQueryModels -> {
            if (view != null) view.displaySixthQueryResult(sixthQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void execSeventhQuery(int countryPopulation) {
        seventhQueryUseCase.setCountryPopulation(countryPopulation);
        seventhQueryUseCase.executeSingle(seventhQueryModels -> {
            if (view != null) view.displaySeventhQueryResult(seventhQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void execEighthQuery(String languageFamily) {
        eighthQueryUseCase.setLanguageFamily(languageFamily);
        eighthQueryUseCase.executeSingle(eighthQueryModels -> {
            if (view != null) view.displayEighthQueryResult(eighthQueryModels);
        }, newErrorCallback());
    }

    @Override
    public void setView(T view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
        firstQueryUseCase.unsubscribe();
        secondQueryUseCase.unsubscribe();
        thirdQueryUseCase.unsubscribe();
        fourthQueryUseCase.unsubscribe();
        fifthQueryUseCase.unsubscribe();
        sixthQueryUseCase.unsubscribe();
        seventhQueryUseCase.unsubscribe();
        eighthQueryUseCase.unsubscribe();
    }

    private Action1<Throwable> newErrorCallback() {
        return throwable -> {
            if (view != null) view.reportError(throwable.getLocalizedMessage());
        };
    }
}
