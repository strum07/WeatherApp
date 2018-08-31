package com.dwolla.sagar.Models.DataModel;

public class TemperatureData {

    private double kelvin;
    private double celsius;
    private double fahrenheit;

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getKelvin() {
        return kelvin;
    }

    public double getCelsius() {
        celsius = kelvin - 273.15;
        return  Math.round(celsius * 100.0) / 100.0;
    }

    public double getFahrenheit() {
        fahrenheit = 1.8*(kelvin-273)+32;
        return Math.round(fahrenheit * 100.0) / 100.0;
    }
}
