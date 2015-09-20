package se.ce.filter

import javax.servlet.Filter
import com.auth0.jwt.JWTVerifier
import javax.servlet.FilterConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.ServletException
import java.util.regex.Pattern
import org.apache.commons.codec.binary.Base64


/**
 * @author Carl
 */
class JwtFilter extends Filter {

  var jwtVerifier : JWTVerifier = null

  override def init(filterConfig: FilterConfig): Unit = {
    val b = new Base64(true)
    jwtVerifier = new JWTVerifier(b.decode("YOUR_CLIENT_SECRET"), "YOUR_CLIENT_ID")
  }

  override def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain): Unit = {
    val token = getToken(request.asInstanceOf[HttpServletRequest])

    try {
      val decoded = jwtVerifier.verify(token)
      // Do something with decoded information like UserId
      chain.doFilter(request, response)
    } catch {
      case e : Throwable =>
        throw new ServletException("Unauthorized: Token validation failed", e)
    }
  }

  def getToken(httpRequest: HttpServletRequest): String = {
    //      String token = null;
    val authorizationHeader = httpRequest.getHeader("authorization");
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

  override def destroy() = {}

}