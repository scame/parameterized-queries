package com.scame.parameterizedqueries.presenters;


import android.util.Log;

import com.scame.parameterizedqueries.models.CapitalModel;
import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.models.CountryModel;
import com.scame.parameterizedqueries.models.LanguageModel;
import com.scame.parameterizedqueries.usecases.capital.CapitalUseCases;
import com.scame.parameterizedqueries.usecases.country.CountryUseCases;
import com.scame.parameterizedqueries.usecases.country_lang.CountryLangsUseCases;
import com.scame.parameterizedqueries.usecases.language.LanguageUseCases;

public class DbManagerPresenterImpl<T extends DbManagerPresenter.DbManagerView> implements DbManagerPresenter<T> {

    private T view;

    private CountryLangsUseCases countryLangsUseCases;

    private LanguageUseCases languageUseCases;

    private CapitalUseCases capitalUseCases;

    private CountryUseCases countryUseCases;

    public DbManagerPresenterImpl(CountryUseCases countryUseCases,
                                  CapitalUseCases capitalUseCases,
                                  LanguageUseCases languageUseCases,
                                  CountryLangsUseCases countryLangsUseCases) {
        this.countryLangsUseCases = countryLangsUseCases;
        this.languageUseCases = languageUseCases;
        this.capitalUseCases = capitalUseCases;
        this.countryUseCases = countryUseCases;
    }

    @Override
    public void requestCountryData() {
        countryUseCases.getGetAllCountriesRecords().executeSingle(
                countryModels -> {
                    if (view != null) {
                        countryModels.add(new CountryModel(-1, "", -1));
                        view.displayCountryData(countryModels);
                    }
                },
                throwable -> Log.i("onxCountryDataErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void requestCapitalData() {
        capitalUseCases.getGetAllCapitalsRecords().executeSingle(
                capitalModels -> {
                    if (view != null) {
                        capitalModels.add(new CapitalModel(-1, -1, "", -1));
                        view.displayCapitalData(capitalModels);
                    }
                }
                , throwable -> Log.i("onxCapitalDataErr",  throwable.getLocalizedMessage()));
    }

    @Override
    public void requestLanguageData() {
        languageUseCases.getGetAllLanguagesRecords().executeSingle(
                languageModels -> {
                    if (view != null) {
                        languageModels.add(new LanguageModel(-1, "", -1, ""));
                        view.displayLanguageData(languageModels);
                    }
                }
                , throwable -> Log.i("onxLanguageDataErr", throwable.getLocalizedMessage()));
    }

    @Override
    public void requestCountryLangsData() {
        countryLangsUseCases.getGetAllCountryLangRecords().executeSingle(
                countryLanguagesModels -> {
                    if (view != null) {
                        countryLanguagesModels.add(new CountryLanguagesModel(-1, -1, -1));
                        view.displayCountryLangsData(countryLanguagesModels);
                    }
                }
                , throwable -> Log.i("onxCountryLangsDataErr", throwable.getLocalizedMessage()));
    }

    @Override
    public void deleteCountryRecord(CountryModel countryModel) {
        countryUseCases.getDeleteCountryRecord().setCountryModel(countryModel);
        countryUseCases.getDeleteCountryRecord().executeCompletable(
                () -> Log.i("onxDeleteCountryRecord", "complete"),
                throwable -> Log.i("onxDeleteCountryErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void deleteCapitalRecord(CapitalModel capitalModel) {
        capitalUseCases.getDeleteCapitalRecord().setCapitalModel(capitalModel);
        capitalUseCases.getDeleteCapitalRecord().executeCompletable(
                () -> Log.i("onxDeleteCapitalRecord", "complete"),
                throwable -> Log.i("onxDeleteCapitalErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void deleteLanguageRecord(LanguageModel languageModel) {
        languageUseCases.getDeleteLanguageRecord().setLanguageModel(languageModel);
        languageUseCases.getDeleteLanguageRecord().executeCompletable(
                () -> Log.i("onxDeleteLanguageRecord", "complete"),
                throwable -> Log.i("onxDeleteLanguageErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void deleteCountryLangsRecord(CountryLanguagesModel countryLanguagesModel) {
        countryLangsUseCases.getDeleteCountryLanguagesRecord().setModel(countryLanguagesModel);
        countryLangsUseCases.getDeleteCountryLanguagesRecord().executeCompletable(
                () -> Log.i("onxDeleteCountryLangs", "complete"),
                throwable -> Log.i("onxDeleteCountryLangsEr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void addCountryRecord(CountryModel countryModel) {
        countryUseCases.getAddCountryRecord().setCountryModel(countryModel);
        countryUseCases.getAddCountryRecord().executeCompletable(
                () -> Log.i("onxAddCountryRecord", "complete"),
                throwable -> Log.i("onxAddCountryErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void addCapitalRecord(CapitalModel capitalModel) {
        capitalUseCases.getAddCapitalRecord().setCapitalModel(capitalModel);
        capitalUseCases.getAddCapitalRecord().executeCompletable(
                () -> Log.i("onxAddCapitalRecord", "complete"),
                throwable -> Log.i("onxAddCapitalErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void addLanguageRecord(LanguageModel languageModel) {
        languageUseCases.getAddLanguageRecord().setLanguageModel(languageModel);
        languageUseCases.getAddLanguageRecord().executeCompletable(
                () -> Log.i("onxAddLanguageRecord", "complete"),
                throwable -> Log.i("onxAddLanguageErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void addCountryLangsRecord(CountryLanguagesModel countryLanguagesModel) {
        countryLangsUseCases.getAddCountryLanguagesRecord().setModel(countryLanguagesModel);
        countryLangsUseCases.getAddCountryLanguagesRecord().executeCompletable(
                () -> Log.i("onxAddCountryLangRecord", "complete"),
                throwable -> Log.i("onxAddCountryLangErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void updateCountryRecord(CountryModel countryModel) {
        countryUseCases.getUpdateCountryRecord().setCountryModel(countryModel);
        countryUseCases.getUpdateCountryRecord().executeCompletable(
                () -> Log.i("onxUpdateCountryRecord", "complete"),
                throwable -> Log.i("onxUpdateCountryErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void updateCapitalRecord(CapitalModel capitalModel) {
        capitalUseCases.getUpdateCapitalRecord().setCapitalModel(capitalModel);
        capitalUseCases.getUpdateCapitalRecord().executeCompletable(
                () -> Log.i("onxUpdateCapitalRecord", "complete"),
                throwable -> Log.i("onxUpdateCapitalErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void updateLanguageRecord(LanguageModel languageModel) {
        languageUseCases.getUpdateLanguageRecord().setLanguageModel(languageModel);
        languageUseCases.getUpdateLanguageRecord().executeCompletable(
                () -> Log.i("onxUpdateLanguageRecord", "complete"),
                throwable -> Log.i("onxUpdateLanguageErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void updateCountryLangsRecord(CountryLanguagesModel countryLanguagesModel) {
        countryLangsUseCases.getUpdateCountryLanguagesRecord().setCountryLanguagesModel(countryLanguagesModel);
        countryLangsUseCases.getUpdateCountryLanguagesRecord().executeCompletable(
                () -> Log.i("onxCountryLangRecordUpd", "complete"),
                throwable -> Log.i("onxCountryLangRecordErr", throwable.getLocalizedMessage())
        );
    }

    @Override
    public void setView(T view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
        countryUseCases.unsubscribe();
        languageUseCases.unsubscribe();
        capitalUseCases.unsubscribe();
        countryLangsUseCases.unsubscribe();
    }
}
