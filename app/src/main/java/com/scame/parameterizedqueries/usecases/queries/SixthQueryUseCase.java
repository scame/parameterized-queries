package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.SixthQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class SixthQueryUseCase extends UseCaseSingle<List<SixthQueryModel>> {

    private QueriesDispatcher dispatcher;

    private String countryName;

    public SixthQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<SixthQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execSixthQuery(countryName)));
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
