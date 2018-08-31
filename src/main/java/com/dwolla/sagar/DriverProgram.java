package com.dwolla.sagar;

import com.dwolla.sagar.Tokenizer.FormatInput;
import com.dwolla.sagar.Weather.TemperatureData;
import com.dwolla.sagar.Weather.WeatherApp;
import com.dwolla.sagar.Weather.WeatherData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DriverProgram {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        String rawInput;

        List<String> paramList;

        FormatInput inputParams;


        System.out.println("Where are you?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        rawInput = reader.readLine();

        if(rawInput.isEmpty()){

            System.out.println("Nothing Entered! Please Try again!");

        }else{

            inputParams = new FormatInput(rawInput);

            paramList = inputParams.getFormattedInputList();

            if(paramList.size()==1){
                WeatherApp myApp = null;
                try {
                    myApp = new WeatherApp(paramList.get(0));
                    myApp.displayWeather();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(paramList.size()==2){
                WeatherApp myApp = null;
                try {
                    myApp = new WeatherApp(paramList.get(0),paramList.get(1));
                    myApp.displayWeather();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Invalid parameters!");
            }
        }
        System.out.println("End");
    }
}
