package com.dwolla.sagar.Objects;

public class Temperature {

    private double kelvin;
    private double celsius;
    private double fahrenheit;

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getCelsius() {
        celsius = kelvin - 273.15;
        return  Math.round(celsius * 100.0) / 100.0;
    }

    public double getFarenheit() {
        fahrenheit = 1.8*(kelvin-273)+32;
        return fahrenheit;
    }

}
