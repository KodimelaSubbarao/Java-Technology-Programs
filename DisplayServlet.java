package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet
{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String qfy=req.getParameter("qfy");
		String lang=req.getParameter("lang");
		String tech=req.getParameter("tech");
		res.setContentType("text/html");
		res.setHeader("refresh", "5");
		PrintWriter pw=res.getWriter();
		pw.println("<br><span style='font-size:20px;font-weight:bold; '>Your ID :: </span> &nbsp;&nbsp; <span style='color:red;font-weight:bold'>" +id+"</span>");
		pw.println("<br><span style='font-size:20px;font-weight:bold; '>Your Name  :: </span> &nbsp;&nbsp; <span style='color:red;font-weight:bold'>" +name+"</span>");
		pw.println("<br><span style='font-size:20px;font-weight:bold; '>Your Qualification :: </span> &nbsp;&nbsp; <span style='color:red;font-weight:bold'>" +qfy+"</span>");
		pw.println("<br><span style='font-size:20px;font-weight:bold; '>Your Languages :: </span> &nbsp;&nbsp; <span style='color:red;font-weight:bold'>" +lang+"</span>");
		pw.println("<br><span style='font-size:20px;font-weight:bold; '>Your Technologies :: </span> &nbsp;&nbsp; <span style='color:red;font-weight:bold'>" +tech+"</span>");
		pw.close();
		
		
	}
}
