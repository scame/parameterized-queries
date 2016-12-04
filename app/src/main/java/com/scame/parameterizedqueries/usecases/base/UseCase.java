package com.scame.parameterizedqueries.usecases.base;


import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class UseCase<T> {
    protected SubscribeOn subscribeOn;
    protected ObserveOn observeOn;
    protected Subscription subscription = Subscriptions.empty();

    public UseCase(SubscribeOn subscribeOn, ObserveOn observeOn) {
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
