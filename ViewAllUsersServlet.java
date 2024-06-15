package product.admin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import product.admin.java.ViewAllUsersDAO;
import product.user.UserBeans;

@SuppressWarnings("serial")
@WebServlet("/users")
public class ViewAllUsersServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<UserBeans> al=new ViewAllUsersDAO().retrive();
			hs.setAttribute("ulist", al);
			req.getRequestDispatcher("ViewAllUsers.jsp").forward(req, res);
		}
	}
}
