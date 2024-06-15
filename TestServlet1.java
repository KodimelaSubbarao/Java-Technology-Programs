package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/test")

//@WebServlet(urlPatterns = {"/test1","/test2","/test3"})
//@WebServlet(value = {"/test1","/test2","/test3"})
//@WebServlet({"/test1","/test2","/test3"})

//@WebServlet(value="/test",loadOnStartup = 1,name="Test")
//@WebServlet(value="/test1")
//@WebServlet(value="/test",loadOnStartup = 1,name="Test",description = "servlet to test",displayName = "test component")

@WebServlet(value="/test",initParams= {@WebInitParam(name="p1",value="val1"),@WebInitParam(name="p2",value="val2")})

public class TestServlet1 extends HttpServlet {
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw=response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletConfig cfg=getServletConfig();
		response.setContentType("text/html");
		pw.println("<br><h1>Hello Every one</h1>");
		pw.println("<br><h1> Init Param Value :: "+cfg.getInitParameter("p1")+"</h1>");
		pw.println("<br><h1> Init Param Value :: "+cfg.getInitParameter("p2")+"</h1>");
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
