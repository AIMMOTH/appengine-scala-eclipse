package se.ce.provider

import javax.annotation.Priority
import javax.ws.rs.Priorities
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.core.SecurityContext
import java.security.Principal
import javax.ws.rs.ext.Provider

@Provider
@Priority(Priorities.AUTHENTICATION)
class SecurityFilter extends ContainerRequestFilter {

    @Override
    def filter(requestContext: ContainerRequestContext) = {
        val originalContext = requestContext.getSecurityContext();
        val authorizer = new Authorizer(Set("ADMIN"), "name of admin", 
                                               originalContext.isSecure());
        requestContext.setSecurityContext(authorizer);
    }

}

class Authorizer(roles: Set[String], username: String, 
                                         isSecure: Boolean) extends SecurityContext {

    override def getUserPrincipal() = new User(username)

    override def isUserInRole(role: String) = roles.contains(role)

    override def isSecure() = isSecure

    override def getAuthenticationScheme() =  "Your Scheme"
} 

class User(name: String) extends Principal {

    override def getName() = name   
}
