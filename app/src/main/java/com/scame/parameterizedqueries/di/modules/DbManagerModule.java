package com.scame.parameterizedqueries.di.modules;


import com.scame.parameterizedqueries.di.PerActivity;
import com.scame.parameterizedqueries.presenters.DbManagerPresenter;
import com.scame.parameterizedqueries.presenters.DbManagerPresenterImpl;
import com.scame.parameterizedqueries.repository.CapitalRepository;
import com.scame.parameterizedqueries.repository.CountryLanguagesRepository;
import com.scame.parameterizedqueries.repository.CountryRepository;
import com.scame.parameterizedqueries.repository.LanguageRepository;
import com.scame.parameterizedqueries.schedulers.ObserveOn;
import com.scame.parameterizedqueries.schedulers.SubscribeOn;
import com.scame.parameterizedqueries.usecases.capital.AddCapitalRecord;
import com.scame.parameterizedqueries.usecases.capital.CapitalUseCases;
import com.scame.parameterizedqueries.usecases.capital.DeleteCapitalRecord;
import com.scame.parameterizedqueries.usecases.capital.GetAllCapitalsRecords;
import com.scame.parameterizedqueries.usecases.country.AddCountryRecord;
import com.scame.parameterizedqueries.usecases.country.CountryUseCases;
import com.scame.parameterizedqueries.usecases.country.DeleteCountryRecord;
import com.scame.parameterizedqueries.usecases.country.GetAllCountriesRecords;
import com.scame.parameterizedqueries.usecases.country_lang.AddCountryLanguagesRecord;
import com.scame.parameterizedqueries.usecases.country_lang.CountryLangsUseCases;
import com.scame.parameterizedqueries.usecases.country_lang.DeleteCountryLanguagesRecord;
import com.scame.parameterizedqueries.usecases.country_lang.GetAllCountryLangRecords;
import com.scame.parameterizedqueries.usecases.language.AddLanguageRecord;
import com.scame.parameterizedqueries.usecases.language.DeleteLanguageRecord;
import com.scame.parameterizedqueries.usecases.language.GetAllLanguagesRecords;
import com.scame.parameterizedqueries.usecases.language.LanguageUseCases;

import dagger.Module;
import dagger.Provides;

@Module
public class DbManagerModule {

    @Provides
    @PerActivity
    DbManagerPresenter<DbManagerPresenter.DbManagerView> provideDbManagerPresenter(CountryUseCases countryUseCases,
                                                                                   CapitalUseCases capitalUseCases,
                                                                                   LanguageUseCases languageUseCases,
                                                                                   CountryLangsUseCases countryLangsUseCases) {
        return new DbManagerPresenterImpl<>(countryUseCases, capitalUseCases, languageUseCases, countryLangsUseCases);
    }

    @Provides
    @PerActivity
    CountryUseCases proideCountryUseCases(GetAllCountriesRecords getAllCountriesRecords,
                                          DeleteCountryRecord deleteCountryRecord,
                                          AddCountryRecord addCountryRecord) {
        return new CountryUseCases(getAllCountriesRecords, deleteCountryRecord, addCountryRecord);
    }

    @Provides
    @PerActivity
    GetAllCountriesRecords provideGetAllCountriesRecords(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                         CountryRepository countryRepository) {
        return new GetAllCountriesRecords(subscribeOn, observeOn, countryRepository);
    }

    @Provides
    @PerActivity
    DeleteCountryRecord provideDeleteCountryRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                   CountryRepository countryRepository) {
        return new DeleteCountryRecord(subscribeOn, observeOn, countryRepository);
    }

    @Provides
    @PerActivity
    AddCountryRecord provideAddCountryRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                             CountryRepository countryRepository) {
        return new AddCountryRecord(subscribeOn, observeOn, countryRepository);
    }

    @Provides
    @PerActivity
    CapitalUseCases provideCapitalUseCases(GetAllCapitalsRecords getAllCapitalsRecords,
                                           DeleteCapitalRecord deleteCapitalRecord,
                                           AddCapitalRecord addCapitalRecord) {
        return new CapitalUseCases(getAllCapitalsRecords, deleteCapitalRecord, addCapitalRecord);
    }

    @Provides
    @PerActivity
    GetAllCapitalsRecords provideGetAllCapitalsRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                      CapitalRepository capitalRepository) {
        return new GetAllCapitalsRecords(subscribeOn, observeOn, capitalRepository);
    }

    @Provides
    @PerActivity
    DeleteCapitalRecord provideDeleteCapitalRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                   CapitalRepository capitalRepository) {
        return new DeleteCapitalRecord(subscribeOn, observeOn, capitalRepository);
    }

    @Provides
    @PerActivity
    AddCapitalRecord provideAddCapitalRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                             CapitalRepository capitalRepository) {
        return new AddCapitalRecord(subscribeOn, observeOn, capitalRepository);
    }

    @Provides
    @PerActivity
    LanguageUseCases provideLanguageUseCases(GetAllLanguagesRecords getAllLanguagesRecords,
                                             DeleteLanguageRecord deleteLanguageRecord,
                                             AddLanguageRecord addLanguageRecord) {
        return new LanguageUseCases(getAllLanguagesRecords, deleteLanguageRecord, addLanguageRecord);
    }

    @Provides
    @PerActivity
    GetAllLanguagesRecords provideGetAllLanguageRecords(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                        LanguageRepository languageRepository) {
        return new GetAllLanguagesRecords(subscribeOn, observeOn, languageRepository);
    }

    @Provides
    @PerActivity
    DeleteLanguageRecord provideDeleteLanguageRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                     LanguageRepository languageRepository) {
        return new DeleteLanguageRecord(subscribeOn, observeOn, languageRepository);
    }

    @Provides
    @PerActivity
    AddLanguageRecord provideAddLanguageRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                               LanguageRepository languageRepository) {
        return new AddLanguageRecord(subscribeOn, observeOn, languageRepository);
    }

    @Provides
    @PerActivity
    CountryLangsUseCases provideCountryLangsUseCases(GetAllCountryLangRecords getAllCountryLangRecords,
                                                     DeleteCountryLanguagesRecord deleteCountryLanguagesRecord,
                                                     AddCountryLanguagesRecord addCountryLanguagesRecord) {
        return new CountryLangsUseCases(getAllCountryLangRecords, deleteCountryLanguagesRecord, addCountryLanguagesRecord);
    }

    @Provides
    @PerActivity
    GetAllCountryLangRecords provideGetAllCountryLangRecords(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                             CountryLanguagesRepository countryLanguagesRepository) {
        return new GetAllCountryLangRecords(subscribeOn, observeOn, countryLanguagesRepository);
    }

    @Provides
    @PerActivity
    DeleteCountryLanguagesRecord provideDeleteCountryLangRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                                CountryLanguagesRepository countryLanguagesRepository) {
        return new DeleteCountryLanguagesRecord(subscribeOn, observeOn, countryLanguagesRepository);
    }

    @Provides
    @PerActivity
    AddCountryLanguagesRecord provideAddCountryLangRecord(SubscribeOn subscribeOn, ObserveOn observeOn,
                                                          CountryLanguagesRepository countryLanguagesRepository) {
        return new AddCountryLanguagesRecord(subscribeOn, observeOn, countryLanguagesRepository);
    }
}
