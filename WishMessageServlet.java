package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		int no=Integer.parseInt(req.getParameter("no"));
		String name=req.getParameter("name");
		LocalDateTime ldt=LocalDateTime.now();
		
		PrintWriter pw=res.getWriter();
		int time=ldt.getHour();
		String msg=null;
		if(time<12)
			msg="Good Morning";
		else if(time<16)
			msg="Good Afternoon";
		else if(time<20)
			msg="Good Evening";
		else 
			msg="Good Night";
		
		pw.println("<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1 style='color:red;font-size:25px;'>"+msg+"</h1>");
		pw.println(no+name);
		pw.println("<br><a href='index.html'>Home</a>");
		
		pw.close();
	}
}
