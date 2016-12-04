package com.scame.parameterizedqueries.models;



public class CountryModel {

    private int id;

    private String name;

    private int population;

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public CountryModel() { }

    public CountryModel(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
}
