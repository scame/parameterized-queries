package com.scame.parameterizedqueries.usecases.country;


import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.base.UseCaseCompletable;

import rx.Completable;

public class AddCountryRecord extends UseCaseCompletable {

    public AddCountryRecord(SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(subscribeOn, observeOn);
    }

    @Override
    protected Completable getUseCaseCompletable() {
        return null;
    }
}
