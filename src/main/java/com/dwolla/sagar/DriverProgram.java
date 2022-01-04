package com.dwolla.sagar;

import com.dwolla.sagar.weather.WeatherHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverProgram {

    public static void main(String[] args) throws IOException {
        String rawInput;

        System.out.println("Where are you?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        rawInput = reader.readLine();

        WeatherHelper weatherMan = new WeatherHelper(rawInput);

        weatherMan.reportWeather();

        //Does this commit show up correctly?
    }
}
