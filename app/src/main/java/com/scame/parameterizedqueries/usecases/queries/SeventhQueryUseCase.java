package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.SeventhQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class SeventhQueryUseCase extends UseCaseSingle<List<SeventhQueryModel>> {

    private QueriesDispatcher dispatcher;

    private int countryPopulation;

    public SeventhQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<SeventhQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execSeventhQuery(countryPopulation)));
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }
}
