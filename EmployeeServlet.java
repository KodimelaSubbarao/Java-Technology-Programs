package com.sa.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
@WebServlet("/empdata")
public class EmployeeServlet extends HttpServlet
{
	private final String  SELECT_QUERY="select * from emp where empno=?";
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-08IIGEE:1521:XE","system","subbu");
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
		)
		{
			if(con!=null && ps!=null) {
				ps.setInt(1, id);
			}
			try(ResultSet rs=ps.executeQuery();)
			{
				if(rs!=null)
				{
					
					if(rs.next())
					{
						pw.println("<center><table border ='1' cellpadding='5px' cellspeacing='5px'><tr><th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPTNO</th></tr>");
						pw.println("<tr><td>"+rs.getString(1)+" </td><td>"+rs.getString(2)+" </td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
						pw.println("</table>");
					}
					else {
						pw.println("<h2 style='color:red; text-align:center;'> Record Not Found");
					}
				}
				
			}
			pw.println("<h3 style='text-align:center;'><a href='input.html'> Home</a></h3>");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			pw.println("Database Problem");
		}
		catch(Exception e)
		{
			pw.println("Internal Server Error");
		}
		
		
		
	}

}
