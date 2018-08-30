package com.dwolla.sagar.Objects;

import org.json.JSONObject;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

public class GetResponse {

    JSONObject response;
    JSONObject nestedResponse;
    Double extractedTemp;
    HttpClient myClient;

    public void setMyClient(HttpClient myClient) {
        this.myClient = myClient;
    }

    public JSONObject getResponse() {
        return response;
    }

    public void setResponse(JSONObject response) {
        this.response = response;
    }

    public Double getExtractedTemp() {
        convertToJson(myClient);
        return extractedTemp;
    }


    public void convertToJson(HttpClient myClient){

        String rawResponse = myClient.getTarget().request(MediaType.APPLICATION_JSON).get(String.class);

        response = new JSONObject(rawResponse);

        nestedResponse = (JSONObject) response.get("main");

        extractedTemp =  BigDecimal.valueOf(nestedResponse.getDouble("temp")).doubleValue();
     }
}
