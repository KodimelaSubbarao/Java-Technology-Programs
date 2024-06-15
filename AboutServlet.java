package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AboutServlet extends HttpServlet
{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<h3 style='color:green; text-decoration:underline; text-align:center; '>Welcome to Programming World </h3>");
		pw.close();	
		
	}
}
