package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.SecondQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class SecondQueryUseCase extends UseCaseSingle<List<SecondQueryModel>> {

    private QueriesDispatcher dispatcher;

    private String languageFamily;

    public SecondQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<SecondQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execSecondQuery(languageFamily)));
    }

    public String getLanguageFamily() {
        return languageFamily;
    }

    public void setLanguageFamily(String languageFamily) {
        this.languageFamily = languageFamily;
    }
}
