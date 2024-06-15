package com.sa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/std")
public class StudentRegServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
		{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			String name=req.getParameter("name");
			String addr=req.getParameter("addr");
			float avg=Float.parseFloat(req.getParameter("avg"));
			try( Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement("insert into student values (stdseq.nextval,?,?,?)");)
			
			{
				ps.setString(1, name);
				ps.setString(2, addr);
				ps.setFloat(3, avg);
				int i=ps.executeUpdate();
				if(i>0)
					pw.println("<h1>Recored Inserted Successsfully</h1>");
				else
					pw.println("<h1>Recored Not Inserted </h1>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.println("<h1>DataBase Error </h1>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.println("<h1>Internal Error </h1>");
			}
			pw.println("<a href='index.html'>Home</a>");
		}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		doGet(req, res);	
	}
	@SuppressWarnings("unused")
	private Connection getConnection() throws NamingException, SQLException
	{
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("DsJndi");
		Connection con=ds.getConnection();
		return con;
	}
}
