package com.dwolla.sagar.weather.datastructure;

public class TemperatureData {

    private double kelvin;

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getKelvin() {
        return kelvin;
    }

    public double getCelsius() {
        double celsius = kelvin - 273.15;
        return  Math.round(celsius * 100.0) / 100.0;
    }

    public double getFahrenheit() {
        double fahrenheit = 1.8 * (kelvin - 273) + 32;
        return Math.round(fahrenheit * 100.0) / 100.0;
    }
}
