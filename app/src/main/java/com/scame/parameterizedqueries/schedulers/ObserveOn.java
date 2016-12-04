package com.scame.parameterizedqueries.schedulers;


import rx.Scheduler;

public interface ObserveOn {

    Scheduler getScheduler();
}
