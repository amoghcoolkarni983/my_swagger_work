package io.swagger.api;

import com.devcenter.person.API.PersonApiServiceImpl;


public class PersonApiServiceFactory {
    private final static PersonApiService service = new PersonApiServiceImpl();

    public static PersonApiService getPersonApi() {
        return service;
    }
}
