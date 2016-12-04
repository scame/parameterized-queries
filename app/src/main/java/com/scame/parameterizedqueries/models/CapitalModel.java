package com.scame.parameterizedqueries.models;


public class CapitalModel {

    private int id;

    private int countryId;

    private String name;

    private int population;

    public void setId(int id) {
        this.id = id;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public CapitalModel() { }

    public CapitalModel(int id, int countryId, String name, int population) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.population = population;
    }
}
