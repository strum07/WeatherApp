package com.dwolla.sagar.Models.DataModel;

public class WeatherDataModel implements DataModel {

    private TemperatureData temperatureData;

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(TemperatureData temperatureData) {
        this.temperatureData = temperatureData;
    }

}
