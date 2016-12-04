package com.scame.parameterizedqueries.di.modules;


import android.content.Context;

import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    SubscribeOn provideSubscribeOn() {
        return Schedulers::newThread;
    }

    @Provides
    @Singleton
    ObserveOn provideObserveOn() {
        return AndroidSchedulers::mainThread;
    }
}
