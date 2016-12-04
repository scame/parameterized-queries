package com.scame.parameterizedqueries.models;


public class CountryLanguagesModel {

    private int id;

    private int countryId;

    private int languageId;

    public void setId(int id) {
        this.id = id;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getId() {
        return id;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public CountryLanguagesModel() { }

    public CountryLanguagesModel(int id, int countryId, int languageId) {
        this.id = id;
        this.countryId = countryId;
        this.languageId = languageId;
    }
}
