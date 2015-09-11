package se.ce

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest

/**
 * @author Carl
 */
class ScalaServlet extends HttpServlet {
  
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
    super.doGet(req, resp)
    resp.getWriter.println("Heya / Scala")
  }
  
}