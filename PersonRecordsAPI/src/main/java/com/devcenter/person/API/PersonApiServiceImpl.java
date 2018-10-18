package com.devcenter.person.API;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.PersonApiService;
import io.swagger.model.Person;

public class PersonApiServiceImpl extends PersonApiService {
	@Override
	public Response deletePerson(String PERSON_ID, SecurityContext securityContext) throws NotFoundException {
		// do some magic!
		return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
	}

	@Override
	public Response fetchPersonRecord(String PERSON_ID, SecurityContext securityContext) throws NotFoundException {
		PersonFinderById responseObj = new PersonFinderById();
		return Response.ok(responseObj.findPersonById(PERSON_ID), MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response insertPersonRecord(String PERSON_ID, Person per, SecurityContext securityContext)
			throws NotFoundException {

		PersonEditorById edit = new PersonEditorById();
		edit.editPersonById(PERSON_ID, per);
		System.out.println(per);
		return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Updated")).build();
	}
}
