package com.voidmain.servlets;

import java.io.IOException;

import com.voidmain.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String username=req.getParameter("username").trim();
		String password=req.getParameter("password").trim();
		if(username.equals("admin") && password.equals("admin"))
		{
			req.getSession().setAttribute("role","admin");
			res.sendRedirect("home.jsp");
		}
		else
		{
			String userType=UserDAO.isValidUser(username, password);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doGet(req, res);
	}
}
