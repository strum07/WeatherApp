package com.dwolla.sagar;


import com.dwolla.sagar.Objects.*;
import org.json.JSONObject;
import com.dwolla.sagar.ApiKeyGen.ApiKey;

import javax.ws.rs.core.MediaType;

public class WeatherApp {
    public static void main(String[] args) throws Exception {
        ApiKey myKeyObject;

        myKeyObject = new ApiKey();

        String apiKey = myKeyObject.getKey();

        System.out.println(apiKey);

        UrlParams myParams = new UrlParams();

        myParams.setCityName("Bangalore");

        Url myUrl = new Url( myParams,myKeyObject );


        System.out.println("See this for URL!!!");
        System.out.println(myUrl.getPrepUrl());

        HttpClient myClient = new HttpClient(myUrl);


        //Extract Response

        System.out.println("See this for JSON!!!");

        String x = myClient.getTarget().request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(x);

        JSONObject json = new JSONObject(x);

        JSONObject y = (JSONObject) json.get("main");

        System.out.println(y);


        // HTTP Client Implementation
        GetResponse myResp = new GetResponse();
        myResp.setMyClient(myClient);
        myResp.getExtractedTemp();
        System.out.println("Extracted Temp");
        System.out.println(myResp.getExtractedTemp());


        //Temperature Class
        Temperature myTemp = new Temperature();
        myTemp.setKelvin(myResp.getExtractedTemp());
        System.out.println("Celsius Temp");
        System.out.println(myTemp.getCelsius());
        System.out.println("Fahrenheit Temp");
        System.out.println(myTemp.getFahrenheit());

    }
}
