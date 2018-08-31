package com.dwolla.sagar.RestApi;

import com.dwolla.sagar.Objects.Url;
import com.dwolla.sagar.Objects.UrlParams;

import javax.ws.rs.core.MediaType;

public class GetMethod extends RestInterface{

    @Override
    public ResponseInterface call(Url url, UrlParams urlParams) {
        return response;
    }
}
