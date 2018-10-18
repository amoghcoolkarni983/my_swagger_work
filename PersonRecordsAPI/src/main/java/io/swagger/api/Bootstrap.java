package io.swagger.api;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;
import io.swagger.models.Swagger;

public class Bootstrap extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		Info info = new Info().title("Swagger Server")
				.description("Patient Api to Search, Update and Delete patient record.").termsOfService("")
				.contact(new Contact().email("amogh.kulkarni@cerner.com"))
				.license(new License().name("").url("http://unlicense.org"));

		ServletContext context = config.getServletContext();
		Swagger swagger = new Swagger().info(info);

		new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
	}
}
