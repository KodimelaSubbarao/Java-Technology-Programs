package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String val=req.getParameter("p1");
		Locale locales[]=Locale.getAvailableLocales();
		
		
		if(val.equalsIgnoreCase("link1"))
		{
			pw.println("<table border='1' cellspacing='10px' cellpadding='5px' >");
			pw.println("<tr><th>Languages</th></tr>");
			Set<String> s=new HashSet<String>();
			for(Locale l:locales)
			{
				s.add(l.getDisplayLanguage());
			}
			for(String l:s)
			{
				pw.println("<tr><td>"+l+"</td></tr>");
			}
			pw.println("</table>");
		}
		else if(val.equalsIgnoreCase("link2"))
		{
			pw.println("<table border='1' cellspacing='10px' cellpadding='5px' >");
			pw.println("<tr><th>Countries</th></tr>");
			Set<String> s=new HashSet<String>();
			for(Locale l:locales)
			{
				s.add(l.getDisplayCountry());
			}
			for(String l:s)
			{
				pw.println("<tr><td>"+l+"</td></tr>");
			}
			pw.println("</table>");
		}
		else 
		{
			LocalDate ld=LocalDate.now();
			int mon=ld.getMonthValue();
			String msg=null;
			if(mon>=3 && mon<=6)
				msg="Summer Season";
			else if(mon>=7 && mon<=10)
				msg="Rainy Season";
			else
				msg="Winter Season";
			pw.println("<h1 style='color:red; text-align:center;'>"+msg+"</h1>");
		}
		
		pw.println("<br><br><a href='links.html' style='font-size:20px; text-align:center;'> Home </a>"); 
		
		pw.close();
	}
}
