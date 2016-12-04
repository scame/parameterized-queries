package com.scame.parameterizedqueries.usecases.country;


import com.scame.parameterizedqueries.models.CountryModel;
import com.scame.parameterizedqueries.repository.CountryRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class GetAllCountriesRecords extends UseCaseSingle<List<CountryModel>> {

    private CountryRepository countryRepository;

    public GetAllCountriesRecords(SubscribeOn subscribeOn, ObserveOn observeOn, CountryRepository countryRepository) {
        super(subscribeOn, observeOn);
        this.countryRepository = countryRepository;
    }

    @Override
    protected Single<List<CountryModel>> getUseCaseSingle() {
        return countryRepository.getAllCountries();
    }
}
