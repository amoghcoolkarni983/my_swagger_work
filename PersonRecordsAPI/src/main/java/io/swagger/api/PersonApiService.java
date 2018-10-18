package io.swagger.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.model.Person;

public abstract class PersonApiService {
	public abstract Response deletePerson(String PERSON_ID, SecurityContext securityContext) throws NotFoundException;

	public abstract Response fetchPersonRecord(String PERSON_ID, SecurityContext securityContext)
			throws NotFoundException;

	public abstract Response insertPersonRecord(String PERSON_ID, Person per,SecurityContext securityContext)
			throws NotFoundException;
}
