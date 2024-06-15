package com.sa.servlet;

public class  HtmlServlet extends jakarta.servlet.http.HttpServlet
{
	protected void service (jakarta.servlet.http.HttpServletRequest req,jakarta.servlet.http.HttpServletResponse res)throws jakarta.servlet.ServletException, java.io.IOException
	{
		res.setContentType("text/html");
		java.io.PrintWriter pw=res.getWriter();
		pw.println("<table align='center' cellspacing=5px  cellpadding=25px width=500px height=300px border=1 bgcolor='yellow' style='color:red; font-weghit:bold; font-size:20px;'>");
		pw.println("<tr><th>TeamName</th><th>Year</th><th>Place</th> </tr>");
		pw.println("<tr><td>India </td> <td> 2007</td><td> South Africa</td></tr>");
		pw.println("<tr> <td> Pakistan</td><td> 2009</td><td>England </td></tr>");
		pw.println("<tr><td> England</td><td> 2010</td><td>WestIndies </td> </tr>");
		pw.println("<tr><td>WestIndies </td><td> 2012</td><td> Austrillia</td> </tr>");
		pw.println("</table>");

		res.setHeader("refresh","1");

		pw.println("<br><br><h1> Date and Time ::  "+new java.util.Date()+"</h1>");
		pw.close();
	}
}
