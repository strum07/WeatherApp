package com.dwolla.sagar.weather;

import com.dwolla.sagar.tokenizer.FormatInput;

import java.util.List;

public class WeatherHelper {

    private final String rawInput;

    public WeatherHelper(String rawInput) {
        this.rawInput = rawInput;
    }

    public void reportWeather() {
        if (rawInput.isEmpty()) {

            System.out.println("Nothing Entered! Please enter location and try again!");

        } else {

            List<String> paramList = FormatInput.getFormattedInputList(rawInput);

            if (paramList.size() == 1) {
                WeatherService myApp;
                try {
                    myApp = new WeatherService(paramList.get(0));
                    myApp.displayWeather();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (paramList.size() == 2) {
                WeatherService myApp;
                try {
                    myApp = new WeatherService(paramList.get(0), paramList.get(1));
                    myApp.displayWeather();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
