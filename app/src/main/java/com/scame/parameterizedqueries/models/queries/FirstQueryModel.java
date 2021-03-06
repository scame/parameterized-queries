package com.scame.parameterizedqueries.models.queries;



public class FirstQueryModel {

    private String country;

    private String language;

    private int nativeSpeakers;

    public FirstQueryModel() { }

    public FirstQueryModel(String country, String language, int nativeSpeakers) {
        this.country = country;
        this.language = language;
        this.nativeSpeakers = nativeSpeakers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNativeSpeakers() {
        return nativeSpeakers;
    }

    public void setNativeSpeakers(int nativeSpeakers) {
        this.nativeSpeakers = nativeSpeakers;
    }
}
