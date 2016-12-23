package com.scame.parameterizedqueries.models.queries;


public class ThirdQueryModel {

    private String language;

    private int numberOfCountries;

    public ThirdQueryModel() { }

    public ThirdQueryModel(String language, int numberOfCountries) {
        this.language = language;
        this.numberOfCountries = numberOfCountries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfCountries() {
        return numberOfCountries;
    }

    public void setNumberOfCountries(int numberOfCountries) {
        this.numberOfCountries = numberOfCountries;
    }
}
