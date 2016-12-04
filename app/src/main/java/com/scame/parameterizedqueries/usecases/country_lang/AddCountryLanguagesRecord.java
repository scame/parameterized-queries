package com.scame.parameterizedqueries.usecases.country_lang;


import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.repository.CountryLanguagesRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class AddCountryLanguagesRecord extends UseCaseCompletable {

    private CountryLanguagesRepository countryLanguagesRepository;

    private CountryLanguagesModel model;

    public AddCountryLanguagesRecord(SubscribeOn subscribeOn, ObserveOn observeOn, CountryLanguagesRepository repository) {
        super(subscribeOn, observeOn);
        this.countryLanguagesRepository = repository;
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return countryLanguagesRepository.addCountryLanguagesRecord(model);
    }

    public void setModel(CountryLanguagesModel model) {
        this.model = model;
    }

    public CountryLanguagesModel getModel() {
        return model;
    }
}
