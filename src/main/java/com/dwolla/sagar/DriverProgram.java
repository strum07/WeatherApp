package com.dwolla.sagar;

import com.dwolla.sagar.Weather.WeatherHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverProgram {

    public static void main(String[] args) throws IOException {
        String rawInput;

        WeatherHelper weatherMan;

        System.out.println("Where are you?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        rawInput = reader.readLine();

        weatherMan = new WeatherHelper(rawInput);

        weatherMan.reportWeather();
    }
}
