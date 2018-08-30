package com.dwolla.sagar.Objects;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class HttpClient {

    private String url;
    WebTarget target;

    Client client = ClientBuilder.newClient();


    public WebTarget getTarget() {
        return target;
    }

    public HttpClient(Url myUrl) {
        this.url = myUrl.getPrepUrl();
        target = client.target(url);
    }



}
