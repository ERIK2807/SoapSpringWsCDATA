package com.example.producingwebservice;

public class Country {

    private String city;
    private int population;
    private String capital;
    private String currency;

    // Constructores, getters y setters

    public Country() {
        // Constructor por defecto
    }

    public Country(String city, int population, String capital, String currency) {
        this.city = city;
        this.population = population;
        this.capital = capital;
        this.currency = currency;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

