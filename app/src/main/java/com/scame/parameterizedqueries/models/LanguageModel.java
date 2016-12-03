package com.scame.parameterizedqueries.models;


public class LanguageModel {

    private int id;

    private String name;

    private int nativeSpeakers;

    private String languageFamily;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNativeSpeakers(int nativeSpeakers) {
        this.nativeSpeakers = nativeSpeakers;
    }

    public void setLanguageFamily(String languageFamily) {
        this.languageFamily = languageFamily;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNativeSpeakers() {
        return nativeSpeakers;
    }

    public String getLanguageFamily() {
        return languageFamily;
    }
}
