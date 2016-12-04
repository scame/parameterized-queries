package com.scame.parameterizedqueries.schedulers;


import rx.Scheduler;

public interface SubscribeOn {

    Scheduler getScheduler();
}
