package se.ce.servlets

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces

/**
 * @author Carl
 */
@Path("/scala")
class ScalaServlet {
  
  @GET
  @Produces(Array("text/plain"))
  def hello = "Hello from Scala"
  
}