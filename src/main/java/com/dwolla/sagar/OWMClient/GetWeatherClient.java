package com.dwolla.sagar.OWMClient;

import com.dwolla.sagar.ApiKeyGen.ApiKey;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

public class GetWeatherClient {

    private ApiKey apiKeyInstance = ApiKey.getInstance();
    private String APPID;
    private String prepUrl;
    private String city;
    private String responseString;
    private double kelvin;


    //Constructor
    public GetWeatherClient(String City) throws Exception {
        this.city = City;
    }

    private void setAPPID(ApiKey apiKeyInstance) {
        this.APPID = apiKeyInstance.getKey();
    }

    private String getPrepUrl(){
        setAPPID(apiKeyInstance);
        String targetUrl = "http://api.openweathermap.org/data/2.5/weather";
        return prepUrl = targetUrl +"?q="+city+"&APPID="+APPID;
    }

    private String getResponseString(){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(getPrepUrl());
        responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
        
        return responseString;
    }

    private double extractTemperature(String responseString){

        JSONObject response = new JSONObject(responseString);
        JSONObject mainResponse = (JSONObject) response.get("main");

        return BigDecimal.valueOf(mainResponse.getDouble("temp")).doubleValue();
    }

    //WeatherApp - Perhaps?
    public double tempInKelvin(){



        return kelvin;

    }


}
