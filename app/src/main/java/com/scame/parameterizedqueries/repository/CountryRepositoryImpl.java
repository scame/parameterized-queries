package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.CountryModel;
import com.scame.parameterizedqueries.sqlite.CountryTable;

import java.util.List;

import rx.Completable;
import rx.Single;

public class CountryRepositoryImpl implements CountryRepository {

    private CountryTable countryTable;

    public CountryRepositoryImpl(CountryTable countryTable) {
        this.countryTable = countryTable;
    }

    @Override
    public Completable updateRecord(CountryModel countryModel) {
        countryTable.updateRecord(countryModel);
        return Completable.complete();
    }

    @Override
    public Completable deleteRecord(CountryModel countryModel) {
        countryTable.deleteRecord(countryModel);
        return Completable.complete();
    }

    @Override
    public Completable addRecord(CountryModel countryModel) {
        countryTable.addRecord(countryModel);
        return Completable.complete();
    }

    @Override
    public Single<List<CountryModel>> getAllCountries() {
        return Single.defer(() -> Single.just(countryTable.getAllCountries()));
    }
}
