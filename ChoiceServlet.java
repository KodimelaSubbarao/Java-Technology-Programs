package com.servlets;
import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res)throws ServletException ,IOException
	{
		String s=req.getParameter("s");
		if(s.equals("Additon"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			rd.forward(req, res);			
		}
		else if(s.equals("Substraction"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("sb");
			rd.forward(req, res);		
		}
		else if(s.equals("Multiplication"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("mp");
			rd.forward(req, res);		
		}
		else if(s.equals("Division"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("dv");
			rd.forward(req, res);		
		}
		else if(s.equals("Modulus"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("md");
			rd.forward(req, res);		
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("av");
			rd.forward(req, res);		
		}
	}
}
