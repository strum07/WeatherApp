package com.dwolla.sagar.owmclient;

import com.dwolla.sagar.keymanagement.ApiKey;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

import static java.lang.System.exit;

public class WeatherClient {

    private final String city;
    private final String countryCode;

    //Constructor
    public WeatherClient(String city){
        this.city = city;
        this.countryCode = null;
    }

    public WeatherClient(String city, String countryCode){
        this.city = city;
        this.countryCode = countryCode;
    }

    private String getPrepUrl(){
        String appid = ApiKey.getApiKey();
        String targetUrl = "http://api.openweathermap.org/data/2.5/weather";

        if (countryCode == null) {
            return targetUrl +"?q="+city+"&APPID="+ appid;
        } else {
          return targetUrl +"?q="+city+","+countryCode+"&APPID="+ appid;
        }
    }

    private String getResponseString(){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(getPrepUrl());

        String responseString = null;

        int httpStatusCode = target.request(MediaType.APPLICATION_JSON).get().getStatus();

        if(httpStatusCode==200){
            return target.request(MediaType.APPLICATION_JSON).get(String.class);

        }else if(httpStatusCode == 404){
            System.out.println("Location not found! "+httpStatusCode);
            exit(1);
        }else if(httpStatusCode == 500){
            System.out.println("Internal Server Error. Please try again!");
            exit(2);
        }

        System.out.println("Please reset the key or enter the right key in the file! "+httpStatusCode);
        exit(3);
        return  responseString;


    }

    private double extractTemperature(String responseString){

        JSONObject response = new JSONObject(responseString);
        JSONObject mainResponse = (JSONObject) response.get("main");

        return BigDecimal.valueOf(mainResponse.getDouble("temp")).doubleValue();
    }

    public double tempInKelvin(){
        return extractTemperature(getResponseString());
    }
}
