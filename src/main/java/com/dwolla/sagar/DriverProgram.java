package com.dwolla.sagar;

import com.dwolla.sagar.Weather.TemperatureData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverProgram {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        String city = null;

        System.out.println("Where are you?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        city = reader.readLine();
        if(city.isEmpty()){
            System.out.println(city);
            System.out.println("Please enter a city and try again!");
        } else{
            System.out.println(city);
            System.out.println("Not empty");

            //pass the city to object 1 =
            TemperatureData temp;
            WeatherApp myApp = null;
            try {
                myApp = new WeatherApp(city);
            } catch (Exception e) {
                e.printStackTrace();
            }
            myApp.displayWeather();
        }
        System.out.println("End");
    }
}
