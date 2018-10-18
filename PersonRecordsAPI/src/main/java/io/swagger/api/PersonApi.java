package io.swagger.api;

import javax.servlet.ServletConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import io.swagger.model.ErrorMessage;
import io.swagger.model.Person;
import io.swagger.model.Success;

@Path("/person")

@io.swagger.annotations.Api(description = "the person API")

public class PersonApi {
	private final PersonApiService delegate;

	public PersonApi(@Context ServletConfig servletContext) {
		PersonApiService delegate = null;

		if (servletContext != null) {
			String implClass = servletContext.getInitParameter("PersonApi.implementation");
			if (implClass != null && !"".equals(implClass.trim())) {
				try {
					delegate = (PersonApiService) Class.forName(implClass).newInstance();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		if (delegate == null) {
			delegate = PersonApiServiceFactory.getPersonApi();
		}

		this.delegate = delegate;
	}

	@DELETE
	@Path("/{PERSON_ID}")

	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Deletes a person record", notes = "", response = Success.class, tags = {
			"Deletes a Person", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "An object containing a success boolean", response = Success.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "The server can not find the requested page", response = ErrorMessage.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Error", response = ErrorMessage.class) })
	public Response deletePerson(
			@ApiParam(value = "Person id to delete", required = true) @PathParam("PERSON_ID") String PERSON_ID,
			@Context SecurityContext securityContext) throws NotFoundException {
		return delegate.deletePerson(PERSON_ID, securityContext);
	}
    @GET
    @Path("/{PERSON_ID}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Fetch Single Person Record", notes = "Fetches a single person records", response = Person.class, tags={ "Fetch Single Person Record", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "An array of persons matching the string parameters", response = Person.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "No Data found for requested  Person Id.", response = ErrorMessage.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The server can not find the requested page", response = ErrorMessage.class) })
    public Response fetchPersonRecord(@ApiParam(value = "Person ID to fetch single Person record",required=true) @PathParam("PERSON_ID") String PERSON_ID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.fetchPersonRecord(PERSON_ID,securityContext);
    }
    	

	@PUT
	@Path("/{PERSON_ID}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Insert a single person record", notes = "Inserts a single person record", response = Void.class, tags = {
			"Update Single Person Record", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 204, message = "Successfully fulfileed the request. No Content to send", response = Void.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "The server can not find the requested page", response = ErrorMessage.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Error", response = ErrorMessage.class) })
	public Response insertPersonRecord(@ApiParam(value = "Pet object that needs to be added to the store", required = true) Person per,
			@ApiParam(value = "Person ID to update single person", required = true) @PathParam("PERSON_ID") String PERSON_ID,
			@Context SecurityContext securityContext) throws NotFoundException {
		return delegate.insertPersonRecord(PERSON_ID, per, securityContext);
	}
}
