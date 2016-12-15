package com.scame.parameterizedqueries.presenters;


import com.scame.parameterizedqueries.models.CapitalModel;
import com.scame.parameterizedqueries.models.CountryLanguagesModel;
import com.scame.parameterizedqueries.models.CountryModel;
import com.scame.parameterizedqueries.models.LanguageModel;

import java.util.List;

public interface DbManagerPresenter<T> extends Presenter<T> {

    interface DbManagerView {

        void displayCountryData(List<CountryModel> countries);

        void displayCapitalData(List<CapitalModel> capitals);

        void displayLanguageData(List<LanguageModel> languages);

        void displayCountryLangsData(List<CountryLanguagesModel> countryLanguages);
    }

    void requestCountryData();

    void requestCapitalData();

    void requestLanguageData();

    void requestCountryLangsData();


    void deleteCountryRecord(CountryModel countryModel);

    void deleteCapitalRecord(CapitalModel capitalModel);

    void deleteLanguageRecord(LanguageModel languageModel);

    void deleteCountryLangsRecord(CountryLanguagesModel countryLanguagesModel);


    void addCountryRecord(CountryModel countryModel);

    void addCapitalRecord(CapitalModel capitalModel);

    void addLanguageRecord(LanguageModel languageModel);

    void addCountryLangsRecord(CountryLanguagesModel countryLanguagesModel);


    void updateCountryRecord(CountryModel countryModel);

    void updateCapitalRecord(CapitalModel capitalModel);

    void updateLanguageRecord(LanguageModel languageModel);

    void updateCountryLangsRecord(CountryLanguagesModel countryLanguagesModel);
}
