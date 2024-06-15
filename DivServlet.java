 package com.servlets; 

 import java.io.IOException;
 import java.io.PrintWriter;

 import jakarta.servlet.GenericServlet;
 import jakarta.servlet.RequestDispatcher;
 import jakarta.servlet.ServletException;
 import jakarta.servlet.ServletRequest;
 import jakarta.servlet.ServletResponse;
 import jakarta.servlet.annotation.WebServlet;

 @SuppressWarnings("serial")
 @WebServlet("/dv")
 public class   DivServlet extends GenericServlet
 {
 	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
 	{
 		int v1=Integer.parseInt(req.getParameter("value1"));
 		int v2=Integer.parseInt(req.getParameter("value2"));
 		float v3=(float)v1/v2;
 		PrintWriter pw=res.getWriter();
 		res.setContentType("text/html");
 		pw.println("<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"	
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "Division = "+v3+"</h3>");
 		RequestDispatcher rd=req.getRequestDispatcher("index.html");
 		rd.include(req, res);
 	}
 }



