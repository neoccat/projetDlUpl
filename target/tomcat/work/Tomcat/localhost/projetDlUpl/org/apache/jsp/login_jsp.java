/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-12-31 17:27:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n");
      out.write("    <title>Login</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div style=\"margin: 50px; margin-left: 40%; margin-right: 40%;\">\r\n");
      out.write("        <form action=\"Authent\" method=\"POST\">\r\n");
      out.write("            <div class=\"mb-3\">\r\n");
      out.write("                <label for=\"login\" class=\"form-label\">Login :</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"login\" name=\"login\" aria-describedby=\"emailHelp\">\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"mb-3\">\r\n");
      out.write("                <label for=\"password\" class=\"form-label\">Password :</label>\r\n");
      out.write("                <input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\">\r\n");
      out.write("                <div id=\"emailHelp\" class=\"form-text\">No account ? Create one <a href=\"signin.jsp\">here</a></div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\t\t");
if(null != request.getParameter("error") && request.getParameter("error").equals("error")) {
      out.write("\r\n");
      out.write("        <div class=\"alert alert-danger\" style=\"margin-top: 10px;\" role=\"alert\">\r\n");
      out.write("            Identifiants incorrects\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
if(null != request.getParameter("error") && request.getParameter("error").equals("error2")) {
      out.write("\r\n");
      out.write("        <div class=\"alert alert-danger\" style=\"margin-top: 10px;\" role=\"alert\">\r\n");
      out.write("            Ce login est déja pris.\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
if(null != request.getParameter("info")) {
      out.write("\r\n");
      out.write("        <div class=\"alert alert-success\" style=\"margin-top: 10px;\" role=\"alert\">\r\n");
      out.write("            Votre compte à été crée avec succés. Vous pouvez vous connecter.\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
