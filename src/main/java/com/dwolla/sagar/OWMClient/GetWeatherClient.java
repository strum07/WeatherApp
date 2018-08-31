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
    private String city;
    private String countryCode;


    //Constructor
    public GetWeatherClient(String City) throws Exception {
        this.city = City;
        this.countryCode = null;
    }

    public GetWeatherClient(String City,String CountryCode) throws Exception {
        this.city = City;
        this.countryCode = CountryCode;
    }



    private void setAPPID(ApiKey apiKeyInstance) {
        this.APPID = apiKeyInstance.getKey();
    }

    private String getPrepUrl(){
        setAPPID(apiKeyInstance);
        String targetUrl = "http://api.openweathermap.org/data/2.5/weather";

        if (countryCode == null) {
            return targetUrl +"?q="+city+"&APPID="+APPID;
        } else {
          return targetUrl +"?q="+city+","+countryCode+"&APPID="+APPID;
        }
    }

    private String getResponseString(){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(getPrepUrl());

        return target.request(MediaType.APPLICATION_JSON).get(String.class);
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
