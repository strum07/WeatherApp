package com.dwolla.sagar.Weather;

import com.dwolla.sagar.OWMClient.GetWeatherClient;

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
