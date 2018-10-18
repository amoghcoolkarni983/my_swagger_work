package io.swagger.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public abstract class SearchPersonsApiService {
	public abstract Response searchPersonRecord(String firstName, String lastName, String mobile,
			SecurityContext securityContext) throws NotFoundException;
}
