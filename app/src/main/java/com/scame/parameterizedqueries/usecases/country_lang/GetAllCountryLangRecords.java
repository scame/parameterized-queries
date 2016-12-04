package com.scame.parameterizedqueries.usecases.country_lang;


import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.repository.CountryLanguagesRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class GetAllCountryLangRecords extends UseCaseSingle<List<CountryLanguagesModel>> {

    private CountryLanguagesRepository countryLanguagesRepository;

    public GetAllCountryLangRecords(SubscribeOn subscribeOn, ObserveOn observeOn, CountryLanguagesRepository repository) {
        super(subscribeOn, observeOn);
        this.countryLanguagesRepository = repository;
    }

    @Override
    protected Single<List<CountryLanguagesModel>> getUseCaseSingle() {
        return countryLanguagesRepository.getAllCountriesLangRecords();
    }
}
