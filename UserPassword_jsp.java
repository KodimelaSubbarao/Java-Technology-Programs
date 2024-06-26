/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2024-03-18 12:45:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import product.user.UserBeans;

public final class UserPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("product.user.UserBeans");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <style>\r\n");
      out.write(".dt1 {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	font-size: 25px;\r\n");
      out.write("	padding-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("dt {\r\n");
      out.write("	font-size: 18px;\r\n");
      out.write("	padding-bottom: 10px;\r\n");
      out.write("	padding-left: 20px;\r\n");
      out.write("	font-weight: bolder;\r\n");
      out.write("	padding-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("	margin-left: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("	margin-left: 120px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function pverify() {\r\n");
      out.write("        var pw1 = document.getElementById(\"pw1\").value;\r\n");
      out.write("        var pw2 = document.getElementById(\"pw2\").value;\r\n");
      out.write("        var error = document.getElementById(\"error\");\r\n");
      out.write("        var submitBtn = document.getElementById(\"bt1\");\r\n");
      out.write("        if (pw1 != pw2) {\r\n");
      out.write("            error.innerHTML = \"Password mismatch. Enter valid password only.\";\r\n");
      out.write("            submitBtn.hidden = true;\r\n");
      out.write("        } else {\r\n");
      out.write("            error.innerHTML = \"\";\r\n");
      out.write("            submitBtn.hidden = false;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		UserBeans ub=(UserBeans)request.getAttribute("ubean");
	
      out.write("\r\n");
      out.write("    <dialog open style=\"margin-top: 100px; width: 300px; height: 300px;\">\r\n");
      out.write("	\r\n");
      out.write("        <form action=\"password\" method=\"post\" >\r\n");
      out.write("            <dl>\r\n");
      out.write("                <dt>User Name</dt>\r\n");
      out.write("                <dd><input type=\"text\" name=\"uname\" value=\"");
      out.print(ub.getuName() );
      out.write("\" readonly></dd>\r\n");
      out.write("                <dt>New Password</dt>\r\n");
      out.write("                <dd><input type=\"password\" name=\"pword\" id=\"pw1\" placeholder=\"Enter New Password...\" required=\"required\"></dd>\r\n");
      out.write("                <dt>Re-Type Password</dt>\r\n");
      out.write("                <dd><input type=\"password\" id=\"pw2\" onkeyup=\"pverify()\" placeholder=\"Enter Re Enter Password...\" required=\"required\"></dd>\r\n");
      out.write("            	<dd id=\"error\" style=\"color:red; font-size:12px;\"></dd>\r\n");
      out.write("            </dl>\r\n");
      out.write("            <button id=\"bt1\" type=\"submit\">Submit</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </dialog>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
