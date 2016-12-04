package com.scame.parameterizedqueries.usecases.country_lang;


import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.repository.CountryLanguagesRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class DeleteCountryLanguagesRecord extends UseCaseCompletable {

    private CountryLanguagesRepository countryLanguagesRepository;

    private CountryLanguagesModel model;

    public DeleteCountryLanguagesRecord(SubscribeOn subscribeOn, ObserveOn observeOn, CountryLanguagesRepository repository) {
        super(subscribeOn, observeOn);
        this.countryLanguagesRepository = repository;
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return countryLanguagesRepository.deleteCountryLanguagesRecord(model);
    }

    public void setModel(CountryLanguagesModel model) {
        this.model = model;
    }

    public CountryLanguagesModel getModel() {
        return model;
    }
}
