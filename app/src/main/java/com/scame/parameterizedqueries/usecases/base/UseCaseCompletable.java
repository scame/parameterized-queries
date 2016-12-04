package com.scame.parameterizedqueries.usecases.base;


import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;

import rx.Completable;
import rx.functions.Action0;
import rx.functions.Action1;

public abstract class UseCaseCompletable extends UseCase {

    private Completable completable;

    public UseCaseCompletable(SubscribeOn subscribeOn, ObserveOn observeOn) {
        super(subscribeOn, observeOn);
    }

    public void executeCompletable(Action0 onComplete, Action1<Throwable> onError) {
        if (completable == null) {
            completable = getUseCaseCompletable()
                    .subscribeOn(subscribeOn.getScheduler())
                    .observeOn(observeOn.getScheduler())
                    .doOnError((t) -> completable = null)
                    .doOnCompleted(() -> completable = null);
        }
        subscription = completable.subscribe(onError, onComplete);
    }

    protected abstract Completable getUseCaseCompletable();
}
