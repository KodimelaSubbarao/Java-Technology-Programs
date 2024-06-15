package product.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.user.UserBeans;
import product.user.java.UserForgotDAO;

@SuppressWarnings("serial")
@WebServlet("/forgot")
public class UserForgotServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		String uname=req.getParameter("uname");
		String mid=req.getParameter("mid");
		if(uname.trim()!="")
		{
			if(mid.trim()=="")
			{
				UserBeans ub=new UserForgotDAO().verify("uname",uname);
				if(ub==null)
				{
					req.setAttribute("msg", "Enter Valid UserName.....!<br>");
					req.getRequestDispatcher("Msg.jsp").forward(req, res);
				}
				else {
					req.setAttribute("ubean", ub);
					req.getRequestDispatcher("UserPassword.jsp").forward(req, res);
				}
			}
		}
		else if(mid.trim()!="")
		{
			if(uname.trim()=="")
			{
				UserBeans ub=new UserForgotDAO().verify("mid",uname);
				if(ub==null)
				{
					req.setAttribute("msg", "Enter Valid Mail ID.....!<br>");
					req.getRequestDispatcher("Msg.jsp").forward(req, res);
				}
				else {
					req.setAttribute("ubean", ub);
					req.getRequestDispatcher("UserPassword.jsp").forward(req, res);
				}
			}
		}
		else {
			req.setAttribute("msg", "Please Enter Any one Field..... <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
