package com.scame.parameterizedqueries.models.queries;



public class SecondQueryModel {

    private String country;

    private String languageFamily;

    public SecondQueryModel() { }

    public SecondQueryModel(String country, String languageFamily) {
        this.country = country;
        this.languageFamily = languageFamily;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguageFamily() {
        return languageFamily;
    }

    public void setLanguageFamily(String languageFamily) {
        this.languageFamily = languageFamily;
    }
}
