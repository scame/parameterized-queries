package com.scame.parameterizedqueries.models.queries;



public class FifthQueryModel {

    private String capital;

    private String country;

    private int countryPopulation;

    public FifthQueryModel() { }

    public FifthQueryModel(String capital, String country, int countryPopulation) {
        this.capital = capital;
        this.country = country;
        this.countryPopulation = countryPopulation;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }
}
