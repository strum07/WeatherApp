package com.dwolla.sagar.weather.datastructure;

public class WeatherData {

    private TemperatureData temperatureData = new TemperatureData();

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(Double temperatureInKelvin) {
        this.temperatureData.setKelvin(temperatureInKelvin);
    }

}
