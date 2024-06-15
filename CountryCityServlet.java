package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CountryCityServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int code=Integer.parseInt(req.getParameter("country"));
		String[] countries= {"NewDelhi","Islamabad","Bejing","WashingtonDC","London","Paris"};
		
		pw.println("<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1 style='color:red;font-size:25px; text-align:center'> The Capital City Name is :: "+countries[code]+"</h1>");
		pw.println("<h2 style='text-align:center'><a href='input.html'> Home</a></h2>");
		pw.close();
	}
}
