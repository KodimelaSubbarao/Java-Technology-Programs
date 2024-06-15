package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AirthmeticServlet extends HttpServlet 
{
	public void requestProcessing(HttpServletRequest req,HttpServletResponse res)
	throws ServletException , IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		LocalDateTime ldt=LocalDateTime.now();
		int time=ldt.getHour();
		int mon=ldt.getMonthValue();
		float v1=0.0f;
		float v2=0.0f;
		String param=req.getParameter("s1");
		if(!(param.equalsIgnoreCase("link1") || param.equalsIgnoreCase("link2")))
		{
			v1=Float.parseFloat(req.getParameter("val1"));
			v2=Float.parseFloat(req.getParameter("val2"));
		}
		if(param.equalsIgnoreCase("Add"))
		{
			pw.println("<br><br><h1 style='color:green;text-align:cnter;'> Addition of "+v1+" and "+v2+" is :: "+(v1+v2)+"</h1>");
		}
		else if(param.equalsIgnoreCase("Sub"))
		{
			pw.println("<br><br><h1 style='color:green;text-align:cnter;'> Substraction of "+v1+" and "+v2+" is :: "+(v1-v2)+"</h1>");
		}
		else if(param.equalsIgnoreCase("Mul"))
		{
			pw.println("<br><br><h1 style='color:green;text-align:cnter;'> Multiplication of "+v1+" and "+v2+" is :: "+(v1*v2)+"</h1>");
		}
		else if(param.equalsIgnoreCase("Div"))
		{
			if(v2>0)
				pw.println("<br><br><h1 style='color:green;text-align:cnter;'> Division of "+v1+" and "+v2+" is :: "+(v1/v2)+"</h1>");
			else
				pw.println("<br><br><h1 style='color:green;text-align:cnter;' >Value2 Must not be Zero Or Negative</h1>");
		}
		else if(param.equalsIgnoreCase("link1"))
		{
			String msg=null;
			if(time<12)
				msg="Good Morning";
			else if(time<16)
				msg="Good Afternoon";
			else if(time<20)
				msg="Good Evening";
			else 
				msg="Good Night";
			pw.println("<br><br><h1 style='color:green;text-align:cnter;'>"+msg+"</h1>");
		}
		else if(param.equalsIgnoreCase("link2"))
		{
			String msg=null;
			if(mon>=3 && mon<=6)
				msg="Summer Season";
			else if(mon>=7 && mon<=11)
				msg="Rainy Season";
			else
				msg="Winter Season";
			pw.println("<br><br><h1 style='color:green;text-align:cnter;'>"+msg+"</h1>");
		}
		pw.println("<br><br><h2 style='text-align:cnter;'><a href='input.html'>Home</a></h2>");
		pw.close();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException , IOException{
		requestProcessing(req, res);
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException , IOException{
		requestProcessing(req, res);	
	}
}
