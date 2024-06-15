package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/fisrt")
public class FirstServlet extends HttpServlet 
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("pname");
		String age=req.getParameter("page");
		String addr=req.getParameter("paddrs");
		String ms=req.getParameter("ms");
		
		Cookie ck1=new Cookie("pname", name);
		Cookie ck2=new Cookie("page", age);
		Cookie ck3=new Cookie("paddr", addr);
		Cookie ck4=new Cookie("ms", ms);
		//Persistence memroy
		ck1.setMaxAge(1000);
		ck2.setMaxAge(600);
		res.addCookie(ck1);
		res.addCookie(ck2);
		//InMemory
		res.addCookie(ck3);
		res.addCookie(ck4);
		
		if(ms.equalsIgnoreCase("single"))
		{
			pw.println("<form action='second' method='post'>");
			pw.println("When do u marry? : <input type='text' name='sa1'><br>");
			pw.println("why do u marry? : <input type='text' name='sa2'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		else
		{
			pw.println("<form action='second' method='post'>");
			pw.println("Spouse Name : <input type='text' name='sa1'><br>");
			pw.println("SNo.of Kids : <input type='text' name='sa2'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		pw.println("<a href='person_details.html>Home</a>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
