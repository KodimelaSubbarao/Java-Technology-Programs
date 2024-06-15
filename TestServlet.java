package com.sa.servlet;



import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet
{
//	static {
//		System.out.println("TestServlet.enclosing_method() static block");
//	}
//	
//	public TestServlet()
//	{
//		System.out.println("TestServlet.TestServlet() 0-param constructor");
//	}
//	
//	{
//		System.out.println("TestServlet.enclosing_method() instance block" );
//	}
	
//	public void init(jakarta.servlet.ServletConfig cg) throws jakarta.servlet.ServletException
//	{
//		System.out.println("init(-) meethod");
//		System.out.println("Param-1 value :: "+cg.getInitParameter("p1"));
//		System.out.println("Param-2 value :: "+cg.getInitParameter("p2"));
//		this.init();
//	}
//	public void init()
//	{
//		System.out.println("TestServlet.init() 0-param ");
//	}
	public  void service(jakarta.servlet.ServletRequest req, jakarta.servlet.ServletResponse res)
			throws jakarta.servlet.ServletException, java.io.IOException{
		/*
		 * ServletConfig cg=getServletConfig(); System.out.println(cg);
		 * System.out.println("Service Param-1 value :: "+cg.getInitParameter("p1"));
		 * System.out.println("Service Param-2 value :: "+cg.getInitParameter("p2"));
		 */
		System.out.println("service(-,-) method");
		res.setContentType("text/html");
		
		res.getWriter().println("<h1> Date of the dat ::"+new java.util.Date()+"</h1>");
	}
	
	public void destroy() {
		System.out.println("destroy() meethod");
	}
}
