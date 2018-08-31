package com.dwolla.sagar.Weather;

import com.dwolla.sagar.OWMClient.GetWeatherHttpClient;
import com.dwolla.sagar.Weather.DataStructure.WeatherData;

public class WeatherService {

    private WeatherData myCityWeatherData = new WeatherData();

    private String myCity;

    private String myCountryCode;

    public WeatherService(String city) throws Exception {
        this.myCity = city;
        GetWeatherHttpClient myClient = new GetWeatherHttpClient(city);
        this.myCityWeatherData.setTemperatureData(myClient.tempInKelvin());
    }


    public WeatherService(String city, String countryCode) throws Exception {
        this.myCity = city;
        this.myCountryCode = countryCode;
        GetWeatherHttpClient myClient = new GetWeatherHttpClient(city,countryCode);
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
