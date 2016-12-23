package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.ThirdQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class ThirdQueryUseCase extends UseCaseSingle<List<ThirdQueryModel>> {

    private QueriesDispatcher dispatcher;

    private int countriesNumber;

    public ThirdQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<ThirdQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execThirdQuery(countriesNumber)));
    }

    public int getCountriesNumber() {
        return countriesNumber;
    }

    public void setCountriesNumber(int countriesNumber) {
        this.countriesNumber = countriesNumber;
    }
}
