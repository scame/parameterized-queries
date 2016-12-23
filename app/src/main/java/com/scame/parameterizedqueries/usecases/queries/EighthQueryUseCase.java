package com.scame.parameterizedqueries.usecases.queries;


import com.scame.parameterizedqueries.models.queries.EighthQueryModel;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;
import com.scame.parameterizedqueries.usecases.base.UseCaseSingle;

import java.util.List;

import rx.Single;

public class EighthQueryUseCase extends UseCaseSingle<List<EighthQueryModel>> {

    private QueriesDispatcher dispatcher;

    private String languageFamily;

    public EighthQueryUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, QueriesDispatcher dispatcher) {
        super(subscribeOn, observeOn);
        this.dispatcher = dispatcher;
    }

    @Override
    protected Single<List<EighthQueryModel>> getUseCaseSingle() {
        return Single.defer(() -> Single.just(dispatcher.execEighthQuery(languageFamily)));
    }

    public String getLanguageFamily() {
        return languageFamily;
    }

    public void setLanguageFamily(String languageFamily) {
        this.languageFamily = languageFamily;
    }
}
