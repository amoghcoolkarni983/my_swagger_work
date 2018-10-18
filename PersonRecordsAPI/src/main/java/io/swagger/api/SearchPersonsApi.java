package io.swagger.api;

import javax.servlet.ServletConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import io.swagger.model.ErrorMessage;
import io.swagger.model.Person;

@Path("/searchPersons")

@io.swagger.annotations.Api(description = "the searchPersons API")

public class SearchPersonsApi {
	private final SearchPersonsApiService delegate;

	public SearchPersonsApi(@Context ServletConfig servletContext) {
		SearchPersonsApiService delegate = null;

		if (servletContext != null) {
			String implClass = servletContext.getInitParameter("SearchPersonsApi.implementation");
			if (implClass != null && !"".equals(implClass.trim())) {
				try {
					delegate = (SearchPersonsApiService) Class.forName(implClass).newInstance();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		if (delegate == null) {
			delegate = SearchPersonsApiServiceFactory.getSearchPersonsApi();
		}

		this.delegate = delegate;
	}

	@GET

	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Get a person record matching the query parameters", notes = "", response = Person.class, tags = {
			"Search persons depends on Query parameters", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "An array of persons matching the string parameters", response = Person.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "The server can not find the requested page", response = ErrorMessage.class),

			@io.swagger.annotations.ApiResponse(code = 500, message = "Error", response = ErrorMessage.class) })
	public Response searchPersonRecord(@ApiParam(value = "") @QueryParam("firstName") String firstName,
			@ApiParam(value = "") @QueryParam("lastName") String lastName,
			@ApiParam(value = "") @QueryParam("mobile") String mobile, @Context SecurityContext securityContext)
			throws NotFoundException {
		return delegate.searchPersonRecord(firstName, lastName, mobile, securityContext);
	}
}
