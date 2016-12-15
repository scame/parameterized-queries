package com.scame.parameterizedqueries.usecases.country_lang;


import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.repository.CountryLanguagesRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class UpdateCountryLanguagesRecord extends UseCaseCompletable {

    private CountryLanguagesRepository countryLanguagesRepository;

    private CountryLanguagesModel countryLanguagesModel;

    public UpdateCountryLanguagesRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                        CountryLanguagesRepository countryLanguagesRepository) {
        super(subscribeOn, observeOn);
        this.countryLanguagesRepository = countryLanguagesRepository;
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return countryLanguagesRepository.updateCountryLanguagesRecord(countryLanguagesModel);
    }

    public void setCountryLanguagesModel(CountryLanguagesModel countryLanguagesModel) {
        this.countryLanguagesModel = countryLanguagesModel;
    }

    public CountryLanguagesModel getCountryLanguagesModel() {
        return countryLanguagesModel;
    }
}
