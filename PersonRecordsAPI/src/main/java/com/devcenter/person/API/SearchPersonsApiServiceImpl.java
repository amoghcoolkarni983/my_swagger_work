package com.devcenter.person.API;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.api.NotFoundException;
import io.swagger.api.SearchPersonsApiService;

public class SearchPersonsApiServiceImpl extends SearchPersonsApiService {
    @Override
    public Response searchPersonRecord( String firstName,  String lastName,  String mobile, SecurityContext securityContext) throws NotFoundException {
		PersonFinder responseObj = new PersonFinder();
		System.out.println("_"+firstName+"_"+lastName+"_"+mobile);
		return Response.ok(responseObj.searchPersonRecord(firstName, lastName, mobile), MediaType.APPLICATION_JSON)
				.build();
    }
}
