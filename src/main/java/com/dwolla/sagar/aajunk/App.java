package com.dwolla.sagar.aajunk;

import com.dwolla.sagar.ApiKeyGen.ApiKey;
import com.dwolla.sagar.Weather.TemperatureData;
import com.dwolla.sagar.aajunk.GetResponse;
import com.dwolla.sagar.aajunk.HttpClient;
import com.dwolla.sagar.aajunk.Url;
import com.dwolla.sagar.aajunk.UrlParams;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;

public class App {



    public static void main(String[] args) throws Exception {
        ApiKey myKeyObject = ApiKey.getInstance();
        String apiKey = myKeyObject.getKey();
        System.out.println(apiKey);
        UrlParams myParams = new UrlParams();

        myParams.setCityName("Chicago");


        Url myUrl = new Url( myParams,myKeyObject );

        System.out.println("See this for URL!!!");
        System.out.println(myUrl.getPrepUrl());

        HttpClient myClient = new HttpClient(myUrl);

        //Extract Response

        System.out.println("See this for JSON!!!");


        String x = myClient.getTarget().request(MediaType.APPLICATION_JSON).get(String.class);

        //JSONObject x = myClient.getTarget().request(MediaType.APPLICATION_JSON).get(JSONObject.class);
        System.out.println(x);

        JSONObject json = new JSONObject(x);

       // JSONObject y = (JSONObject) json.get("main");
        //JSONObject y = (JSONObject) json.get("main");
        JSONObject y = (JSONObject) json.get("main");

        System.out.println(y);


        // HTTP Client Implementation
        GetResponse myResp = new GetResponse();
        myResp.setMyClient(myClient);
        myResp.getExtractedTemp();

        System.out.println("Extracted Temp");
        System.out.println(myResp.getExtractedTemp());

        //Temperature Class
        TemperatureData myTemp = new TemperatureData();
        myTemp.setKelvin(myResp.getExtractedTemp());

        System.out.println("Celsius Temp");
        System.out.println(myTemp.getCelsius());

        System.out.println("Fahrenheit Temp");
        System.out.println(myTemp.getFahrenheit());

    }

    String city;

    public App(String City) {
        this.city = City;
    }

    //Call Http Client
        //Sets up API and makes the call
        //returns the response as temperature data

    // print out
}