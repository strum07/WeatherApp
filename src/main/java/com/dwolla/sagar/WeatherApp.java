package com.dwolla.sagar;

import com.dwolla.sagar.Weather.WeatherData;

public class WeatherApp {

    private WeatherData weatherdata;

    private String city;


    public WeatherApp(String city) {
        this.city = city;
    }


    public void displayWeather(){
        System.out.println("Hey!Chicago");
    }



}
