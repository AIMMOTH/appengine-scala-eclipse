package se.ce.provider

import javax.annotation.Priority
import javax.ws.rs.Priorities
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.core.SecurityContext
import java.security.Principal
import javax.ws.rs.ext.Provider
import javax.servlet.http.HttpServletRequest
import javax.servlet.ServletException
import java.util.regex.Pattern
import com.auth0.jwt.JWTVerifier
import org.apache.commons.codec.binary.Base64

@Provider
@Priority(Priorities.AUTHENTICATION)
class JwtSecurityFilter extends ContainerRequestFilter {

  val b = new Base64(true)
  val jwtVerifier = new JWTVerifier(b.decode("YOUR_CLIENT_SECRET"), "YOUR_CLIENT_ID")

  @Override
  def filter(requestContext: ContainerRequestContext) = {
    //        val originalContext = requestContext.getSecurityContext();
    //        val authorizer = new Authorizer(Set("ADMIN"), "name of admin", 
    //                                               originalContext.isSecure());
    //        requestContext.setSecurityContext(authorizer);
    val token = getToken(requestContext.getHeaderString("authorization"))

    try {
      val decoded = jwtVerifier.verify(token)
      // Do something with decoded information like UserId
      //      chain.doFilter(request, response)
      val originalContext = requestContext.getSecurityContext();
      val authorizer = new Authorizer(Set("ADMIN"), "name of admin", originalContext.isSecure());
      requestContext.setSecurityContext(authorizer);
    } catch {
      case e: Throwable =>
        throw new ServletException("Unauthorized: Token validation failed", e)
    }
  }

  def getToken(authorizationHeader: String): String = {
    //      String token = null;
    if (authorizationHeader == null) {
      throw new ServletException("Unauthorized: No Authorization header was found");
    }

    val parts = authorizationHeader.split(" ");
    if (parts.length != 2) {
      throw new ServletException("Unauthorized: Format is Authorization: Bearer [token]");
    }

    val scheme = parts(0);
    val credentials = parts(1);

    val pattern = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
    if (pattern.matcher(scheme).matches()) {
      credentials;
    } else {
      null
    }
  }
}
