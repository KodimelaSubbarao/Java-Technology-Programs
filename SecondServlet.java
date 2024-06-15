package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet 
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("pname");
		String age=req.getParameter("page");
		String addrs= req.getParameter("paddrs");
		String ms=req.getParameter("ms");
		String val1=req.getParameter("sa1");
		String val2=req.getParameter("sa2");
		
		pw.println("<h1 style='color:red;text-align:center;'>Form1 Requst Data :: "+name+"....."+age+"....."+addrs+"....."+ms+"</h1>");
		pw.println("<h1 style='color:red;text-align:center;'>Form2 Requst Data :: "+val1+"&nbsp;"+val2+"</h1>");
		pw.println("<a href='person_details.html'>home</a>");
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
