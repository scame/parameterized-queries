package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.CountryModel;

import java.util.List;

import rx.Completable;
import rx.Single;

public interface CountryRepository {

    Completable deleteRecord(CountryModel countryModel);

    Completable addRecord(CountryModel countryModel);

    Single<List<CountryModel>> getAllCountries();
}
