package com.dwolla.sagar;

import com.dwolla.sagar.ApiKeyGen.ApiKey;
import com.dwolla.sagar.Objects.HttpClient;
import com.dwolla.sagar.Objects.Url;
import com.dwolla.sagar.Objects.UrlParams;

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

        System.out.println("See this for JSON!!!");

        String x = myClient.getTarget().request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(x);


        // HTTP Client Implementation
    }
}
