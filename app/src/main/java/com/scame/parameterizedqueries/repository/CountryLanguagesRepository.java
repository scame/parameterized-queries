package com.scame.parameterizedqueries.repository;


import com.scame.parameterizedqueries.models.CountryLanguagesModel;

import java.util.List;

import rx.Completable;
import rx.Single;

public interface CountryLanguagesRepository {

    Completable updateCountryLanguagesRecord(CountryLanguagesModel countryLanguagesModel);

    Completable addCountryLanguagesRecord(CountryLanguagesModel countryLanguagesModel);

    Completable deleteCountryLanguagesRecord(CountryLanguagesModel countryLanguagesModel);

    Single<List<CountryLanguagesModel>> getAllCountriesLangRecords();
}
