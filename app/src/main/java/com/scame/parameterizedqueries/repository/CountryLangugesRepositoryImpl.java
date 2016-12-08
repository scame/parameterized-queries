package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.sqlite.CountryLanguagesBridgeTable;

import java.util.List;

import rx.Completable;
import rx.Single;

public class CountryLangugesRepositoryImpl implements CountryLanguagesRepository {

    private CountryLanguagesBridgeTable bridgeTable;

    public CountryLangugesRepositoryImpl(CountryLanguagesBridgeTable bridgeTable) {
        this.bridgeTable = bridgeTable;
    }

    @Override
    public Completable addCountryLanguagesRecord(CountryLanguagesModel countryLanguagesModel) {
        bridgeTable.addRecord(countryLanguagesModel);
        return Completable.complete();
    }

    @Override
    public Completable deleteCountryLanguagesRecord(CountryLanguagesModel countryLanguagesModel) {
        bridgeTable.deleteRecord(countryLanguagesModel);
        return Completable.complete();
    }

    @Override
    public Single<List<CountryLanguagesModel>> getAllCountriesLangRecords() {
        return Single.defer(() -> Single.just(bridgeTable.getAllCountriesLanguages()));
    }
}
