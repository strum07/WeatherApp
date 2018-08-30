package com.dwolla.sagar.Objects;

import com.dwolla.sagar.ApiKeyGen.ApiKey;

public class Url{

    private String target = "http://api.openweathermap.org/data/2.5/weather";

    private String prepUrl;

    private String city;

    private String key;

    public Url(UrlParams myParams, ApiKey myKey) {
        this.city = myParams.getCityName();
        this.key = myKey.getKey();
    }

    public String getPrepUrl(){
        return prepUrl = target+"?q="+city+"&APPID="+key;
    }
}
