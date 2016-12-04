package com.scame.parameterizedqueries.usecases;


import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;

import rx.Single;
import rx.functions.Action1;

public abstract class UseCaseSingle<T> extends UseCase<T> {

    private Single<T> single;

    public UseCaseSingle(SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(subscribeOn, observeOn);
    }

    public void executeSingle(Action1<? super T> onSuccess, Action1<Throwable> onError) {
        if (single == null) {
            single = getUseCaseSingle()
                    .subscribeOn(subscribeOn.getScheduler())
                    .observeOn(observeOn.getScheduler())
                    .doOnSuccess(t -> t = null)
                    .doOnError(t -> t = null);
        }
        subscription = single.subscribe(onSuccess, onError);
    }

    protected abstract Single<T> getUseCaseSingle();
}
