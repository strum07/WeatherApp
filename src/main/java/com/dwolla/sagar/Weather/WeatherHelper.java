package com.dwolla.sagar.Weather;

import com.dwolla.sagar.Tokenizer.FormatInput;

import java.util.List;

public class WeatherHelper {


    private String rawInput;

    public WeatherHelper(String rawInput) {
        this.rawInput = rawInput;
    }

    public void serveWeather(){
        if(rawInput.isEmpty()){

            System.out.println("Nothing Entered! Please Try again!");

        }else{

            FormatInput inputParams = new FormatInput(rawInput);

            List<String> paramList = inputParams.getFormattedInputList();

            if(paramList.size()==1){
                WeatherService myApp = null;
                try {
                    myApp = new WeatherService(paramList.get(0));
                    myApp.displayWeather();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(paramList.size()==2){
                WeatherService myApp = null;
                try {
                    myApp = new WeatherService(paramList.get(0), paramList.get(1));
                    myApp.displayWeather();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Invalid parameters!");
            }
        }
    }

}
