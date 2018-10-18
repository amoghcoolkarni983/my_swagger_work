package io.swagger.api;

import com.devcenter.person.API.SearchPersonsApiServiceImpl;


public class SearchPersonsApiServiceFactory {
    private final static SearchPersonsApiService service = new SearchPersonsApiServiceImpl();

    public static SearchPersonsApiService getSearchPersonsApi() {
        return service;
    }
}
