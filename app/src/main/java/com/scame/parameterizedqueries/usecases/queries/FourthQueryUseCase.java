package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.FourthQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class FourthQueryUseCase extends UseCaseSingle<List<FourthQueryModel>> {

    private QueriesDispatcher dispatcher;

    private int capitalPopulation;

    public FourthQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<FourthQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execFourthQuery(capitalPopulation)));
    }

    public int getCapitalPopulation() {
        return capitalPopulation;
    }

    public void setCapitalPopulation(int capitalPopulation) {
        this.capitalPopulation = capitalPopulation;
    }
}
