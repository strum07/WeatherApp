package com.dwolla.sagar.weather;

import com.dwolla.sagar.owmclient.WeatherClient;
import com.dwolla.sagar.weather.datastructure.WeatherData;

public class WeatherService {

    private WeatherData myCityWeatherData = new WeatherData();

    private String myCity;

    private String myCountryCode;

    public WeatherService(String city)  {
        this.myCity = city;
        WeatherClient myClient;
        try {
            myClient = new WeatherClient(city);
            this.myCityWeatherData.setTemperatureData(myClient.tempInKelvin());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public WeatherService(String city, String countryCode){
        this.myCity = city;
        this.myCountryCode = countryCode;
        WeatherClient myClient = new WeatherClient(city,countryCode);
        this.myCityWeatherData.setTemperatureData(myClient.tempInKelvin());
    }


    public void displayWeather(){
        if(myCountryCode==null){
            System.out.println(capitalizeFirstLetterOfWord(myCity) +" Weather:");
        }else{
            System.out.println(capitalizeFirstLetterOfWord(myCity) +" "+myCountryCode.toUpperCase()+" Weather:");

        }
        System.out.println(myCityWeatherData.getTemperatureData().getFahrenheit()+" degrees Fahrenheit"+"");

    }

    private String capitalizeFirstLetterOfWord(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
