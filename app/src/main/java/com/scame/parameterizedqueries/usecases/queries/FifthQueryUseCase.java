package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.FifthQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class FifthQueryUseCase extends UseCaseSingle<List<FifthQueryModel>> {

    private QueriesDispatcher dispatcher;

    private int countryPopulation;

    public FifthQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<FifthQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execFifthQuery(countryPopulation)));
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }
}
