package com.dwolla.sagar.Weather;

import com.dwolla.sagar.OWMClient.GetWeatherClient;
import com.dwolla.sagar.Weather.WeatherData;

public class WeatherApp {

    private WeatherData myCityWeatherData = new WeatherData();

    private String myCity;

    private String myCountryCode;

    public WeatherApp(String city) throws Exception {
        this.myCity = city;
        GetWeatherClient myClient = new GetWeatherClient(city);
        this.myCityWeatherData.setTemperatureData(myClient.tempInKelvin());
    }


    public WeatherApp(String city, String countryCode) throws Exception {
        this.myCity = city;
        this.myCountryCode = countryCode;
        GetWeatherClient myClient = new GetWeatherClient(city,countryCode);
        this.myCityWeatherData.setTemperatureData(myClient.tempInKelvin());
    }


    public void displayWeather(){
        if(myCountryCode.isEmpty()){
            System.out.println(myCity +" Weather:");
        }else{
            System.out.println(myCity +" "+myCountryCode+" Weather:");

        }
        System.out.println(myCityWeatherData.getTemperatureData().getFahrenheit()+" degrees Fahrenheit"+"");

    }
}
