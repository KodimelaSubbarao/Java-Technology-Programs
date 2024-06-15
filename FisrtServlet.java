package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FisrtServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String addrs= req.getParameter("paddrs");
		String ms=req.getParameter("ms");
		if(ms.equalsIgnoreCase("single"))
		{
			pw.println("<br><h1>Enter Bachelor Life details</h1>");
			pw.println("<br><form action='secondurl' method='post'>");
			pw.println("<input type='hidden' name='pname' value='"+name+"'>");
			pw.println("<input type='hidden' name='page' value='"+age+"'>");
			pw.println("<input type='hidden' name='paddrs' value='"+addrs+"'>");
			pw.println("<input type='hidden' name='ms' value='"+ms+"'>");
			pw.println("When do u want to marry ? <input type='text' name='sa1'><br>");
			pw.println("Why do u want to marry ? <input type='text' name='sa2'><br>");
			pw.println("<br>&nbsp;&nbsp;&nbsp; <input type='submit' value='Submit'><br> </form>");
		}
		else
		{
			pw.println("<br><h1>Enter Maarrid Life details</h1>");
			pw.println("<br><form action='secondurl' method='post'>");
			pw.println("<input type='hidden' name='pname' value='"+name+"'>");
			pw.println("<input type='hidden' name='page' value='"+age+"'>");
			pw.println("<input type='hidden' name='paddrs' value='"+addrs+"'>");
			pw.println("<input type='hidden' name='ms' value='"+ms+"'>");
			pw.println("Spouse Name :: <input type='text' name='sa1'><br>");
			pw.println("No.of Kids ::  <input type='text' name='sa2'><br>");
			pw.println("<br>&nbsp;&nbsp;&nbsp; <input type='submit' value='Submit'><br> </form>");
		}
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
