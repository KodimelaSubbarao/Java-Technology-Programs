package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet 
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String ss=req.getParameter("ss");
		String eng=req.getParameter("seng");
		if(eng.equalsIgnoreCase("google"))
			pw.println("<h1><a href='https://www.google.com/search?q="+ss+"'>click here for Google Search</a></h1>");
		else if(eng.equalsIgnoreCase("bing"))
			pw.println("<h1><a href='https://www.bing.com/search?q="+ss+"'>click here for Bing Search</a></h1>");
		else
			pw.println("<h1><a href='https://in.search.yahoo.com/search?q="+ss+"'>click here for Yahoo Search</a></h1>");
		
		pw.close();
	
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}
