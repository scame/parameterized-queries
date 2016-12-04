package com.scame.parameterizedqueries.usecases.country;


import com.scame.parameterizedqueries.models.CountryModel;
import com.scame.parameterizedqueries.repository.CountryRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class AddCountryRecord extends UseCaseCompletable {

    private CountryRepository countryRepository;

    private CountryModel countryModel;

    public AddCountryRecord(SubscribeOn subscribeOn, ObserveOn observeOn, CountryRepository countryRepository) {
        super(subscribeOn, observeOn);
        this.countryRepository = countryRepository;
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return countryRepository.addRecord(countryModel);
    }

    public void setCountryModel(CountryModel countryModel) {
        this.countryModel = countryModel;
    }

    public CountryModel getCountryModel() {
        return countryModel;
    }
}
