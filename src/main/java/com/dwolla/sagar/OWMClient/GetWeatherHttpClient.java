package com.dwolla.sagar.OWMClient;

import com.dwolla.sagar.ApiKeyGen.ApiKey;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

import static java.lang.System.exit;

public class GetWeatherHttpClient {

    private ApiKey apiKeyInstance = ApiKey.getInstance();
    private String APPID;
    private String city;
    private String countryCode;


    //Constructor
    public GetWeatherHttpClient(String City){
        this.city = City;
        this.countryCode = null;
    }

    public GetWeatherHttpClient(String City, String CountryCode){
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
