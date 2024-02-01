package com.example.producingwebservice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "city",
    "population",
    "capital",
    "currency"
})
@XmlRootElement(name = "getCountryResponse")
public class GetCountryResponse {

    @XmlElement(required = true)
    protected String city;

    protected int population;

    @XmlElement(required = true)
    protected String capital;

    @XmlElement(required = true)
    protected String currency;

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int value) {
        this.population = value;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String value) {
        this.capital = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String value) {
        this.currency = value;
    }
}
