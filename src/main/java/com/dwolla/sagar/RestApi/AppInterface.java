package com.dwolla.sagar.RestApi;

import com.dwolla.sagar.Objects.Url;
import com.dwolla.sagar.Objects.UrlParams;

public interface AppInterface {

    ResponseInterface call(Url url, UrlParams urlParams);
}
