package com.dwolla.sagar.RestApi;

import com.dwolla.sagar.Objects.Url;
import com.dwolla.sagar.Objects.UrlParams;

public abstract class RestInterface implements AppInterface {

    ResponseInterface response;
    Url url;
    UrlParams urlParams;

    public abstract ResponseInterface call(Url url, UrlParams urlParams);

}
