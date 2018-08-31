package com.dwolla.sagar.Weather.DataStructure;

public class WeatherData {

    private TemperatureData temperatureData = new TemperatureData();

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(Double temperatureInKelvin) {
        this.temperatureData.setKelvin(temperatureInKelvin);
    }

}
