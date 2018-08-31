package com.dwolla.sagar;

import com.dwolla.sagar.Models.DataModel.TemperatureData;
import com.dwolla.sagar.Models.DataModel.WeatherDataModel;
import com.dwolla.sagar.Objects.*;
import org.json.JSONObject;
import com.dwolla.sagar.ApiKeyGen.ApiKey;
import javax.ws.rs.core.MediaType;

public class WeatherApp {

    private WeatherDataModel weatherdata;

    private String city;


    public WeatherApp(String city) {
        this.city = city;
    }


    public void displayWeather(){

    }



}
