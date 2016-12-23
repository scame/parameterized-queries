package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.FirstQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class FirstQueryUseCase extends UseCaseSingle<List<FirstQueryModel>> {

    private QueriesDispatcher dispatcher;

    private int nativeSpeakers;

    public FirstQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<FirstQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execFirstQuery(nativeSpeakers)));
    }

    public int getNativeSpeakers() {
        return nativeSpeakers;
    }

    public void setNativeSpeakers(int nativeSpeakers) {
        this.nativeSpeakers = nativeSpeakers;
    }
}
