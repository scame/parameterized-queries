package com.scame.parameterizedqueries.di.components;


import com.scame.parameterizedqueries.di.modules.ApplicationModule;
import com.scame.parameterizedqueries.di.modules.DataModule;
import com.scame.parameterizedqueries.repository.CapitalRepository;
import com.scame.parameterizedqueries.repository.CountryLanguagesRepository;
import com.scame.parameterizedqueries.repository.CountryRepository;
import com.scame.parameterizedqueries.repository.LanguageRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {

    QueriesDispatcher provideQueriesManager();

    CountryRepository provideCountryRepository();

    LanguageRepository provideLanguageRepository();

    CapitalRepository provideCapitalRepository();

    CountryLanguagesRepository provideCountryLanguagesRepository();

    SubscribeOn getSubscribeOn();

    ObserveOn getObserveOn();
}
