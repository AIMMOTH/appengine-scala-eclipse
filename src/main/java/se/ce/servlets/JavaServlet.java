package se.ce.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/java")
public class JavaServlet {

	@GET
	@Produces("text/plain")
	public String hello() {
	    return "Heja /Java";
	}
}
