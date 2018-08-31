package com.dwolla.sagar;

import com.dwolla.sagar.OWMClient.GetWeatherClient;
import com.dwolla.sagar.Weather.WeatherData;

public class WeatherApp {

    private WeatherData weatherdata;

    private String city;

    private GetWeatherClient myClient;

    public WeatherApp(String city) throws Exception {
        this.city = city;
        myClient = new GetWeatherClient(city);
        this.weatherdata = myClient.;
    }


    public void displayWeather(){


        System.out.println(weatherdata.getTemperatureData().getFahrenheit());


        //Retrieve the key

        // Set HTTP Client up

        // Make the Call


        //Extract the JSON for Weather

        // Set WeatherData
    }





}
