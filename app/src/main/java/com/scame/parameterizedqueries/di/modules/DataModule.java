package com.scame.parameterizedqueries.di.modules;

import android.content.Context;

import com.scame.parameterizedqueries.repository.CapitalRepository;
import com.scame.parameterizedqueries.repository.CapitalRepositoryImpl;
import com.scame.parameterizedqueries.repository.CountryLanguagesRepository;
import com.scame.parameterizedqueries.repository.CountryLangugesRepositoryImpl;
import com.scame.parameterizedqueries.repository.CountryRepository;
import com.scame.parameterizedqueries.repository.CountryRepositoryImpl;
import com.scame.parameterizedqueries.repository.LanguageRepository;
import com.scame.parameterizedqueries.repository.LanguageRepositoryImpl;
import com.scame.parameterizedqueries.sqlite.CapitalTable;
import com.scame.parameterizedqueries.sqlite.CountryLanguagesBridgeTable;
import com.scame.parameterizedqueries.sqlite.CountryTable;
import com.scame.parameterizedqueries.sqlite.DatabaseOpenHelper;
import com.scame.parameterizedqueries.sqlite.LanguageTable;
import com.scame.parameterizedqueries.sqlite.QueriesDispatcher;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    DatabaseOpenHelper provideDatabaseOpenHelper(Context context) {
        return new DatabaseOpenHelper(context);
    }

    @Provides
    @Singleton
    CountryTable provideCountryTable(DatabaseOpenHelper databaseOpenHelper) {
        return new CountryTable(databaseOpenHelper);
    }

    @Provides
    @Singleton
    CapitalTable provideCapitalTable(DatabaseOpenHelper databaseOpenHelper) {
        return new CapitalTable(databaseOpenHelper);
    }

    @Provides
    @Singleton
    LanguageTable provideLanguageTable(DatabaseOpenHelper databaseOpenHelper) {
        return new LanguageTable(databaseOpenHelper);
    }

    @Provides
    @Singleton
    CountryLanguagesBridgeTable provideBridgeTable(DatabaseOpenHelper databaseOpenHelper) {
        return new CountryLanguagesBridgeTable(databaseOpenHelper);
    }

    @Provides
    @Singleton
    CountryRepository provideCountryRepository(CountryTable countryTable) {
        return new CountryRepositoryImpl(countryTable);
    }

    @Provides
    @Singleton
    LanguageRepository provideLanguageRepository(LanguageTable languageTable) {
        return new LanguageRepositoryImpl(languageTable);
    }

    @Provides
    @Singleton
    CapitalRepository provideCapitalRepository(CapitalTable capitalTable) {
        return new CapitalRepositoryImpl(capitalTable);
    }

    @Provides
    @Singleton
    CountryLanguagesRepository provideCountryLanguagesRepository(CountryLanguagesBridgeTable bridgeTable) {
        return new CountryLangugesRepositoryImpl(bridgeTable);
    }

    @Provides
    @Singleton
    QueriesDispatcher provideQueriesManager(DatabaseOpenHelper openHelper) {
        return new QueriesDispatcher(openHelper);
    }
}
