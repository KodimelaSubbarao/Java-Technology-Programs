package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SeasonFinder extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<h1 style='color:red;text-align:center;text-decoration:underline;'> Welcome to Season Finder </h1>");
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		pw.println("<br> <h2>&nbsp;&nbsp;Id :: "+id+"</h2>");
		pw.println("<h2>&nbsp;&nbsp;Name :: "+name+"</h2>");
		res.setHeader("refresh", "5");
		LocalDate ld=LocalDate.now();
		
		int mon=ld.getMonthValue();
		String msg=null;
		if(mon>3 && mon<6)
			msg="Summer";
		else if(mon>5 && mon<12)
			msg="Raniy";
		else if(mon>11 && mon<3)
			msg="Winter";
		
		pw.println("<br>&nbsp;&nbsp;<h2 style='color:green;text-align:center;'> Current Season is :: "+msg+"</h2");
		pw.println(" <br><a href='hello.html' style='font-size:20px;margin-left:10%;text-decoration:none;'> Home</a>");
		pw.close();
	}
}
