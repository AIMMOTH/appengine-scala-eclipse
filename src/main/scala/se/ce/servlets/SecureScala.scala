package se.ce.servlets

import javax.ws.rs.Path
import javax.ws.rs.core.SecurityContext
import javax.ws.rs.GET
import javax.annotation.security.RolesAllowed
import javax.ws.rs.core.Context
import se.ce.provider.User

@Path("secure")
class SecuredResource {
  
    @GET
    @RolesAllowed(Array("ADMIN"))
    def getUsername(@Context securityContext: SecurityContext) = {
        val user = securityContext.getUserPrincipal().asInstanceOf[User]
        val a1 = securityContext.isUserInRole("ADMIN")
        val a2 = securityContext.isUserInRole("admin")
        "Name:" + user.getName() + "<br>Role in ADMIN?" + a1 + "<br>Role in admin?" + a2
    }
}