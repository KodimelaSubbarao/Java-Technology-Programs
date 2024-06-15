package product.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import product.admin.ProductBean;
import product.user.UserBeans;
import product.user.java.UserLoginDAO;
import product.user.java.ViewProductdsDAO;

@SuppressWarnings("serial")
@WebServlet("/ulogin")
public class UserLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException
	{
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		UserBeans ub=new UserLoginDAO().logVerfiy(uname, pword);
		if(ub==null)
		{
			req.setAttribute("msg", "Enter Valid Login Details.....!<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs1=req.getSession();
			hs1.setAttribute("ubean", ub);
			req.setAttribute("msg", "Login Successfull......<br>");
//			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
			this.doGet(req, res);
		}
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
	{
		HttpSession hs1=req.getSession(false);
		if(hs1==null)
		{
			req.setAttribute("msg", "Session Expired.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<ProductBean> al1=new ViewProductdsDAO().retrive();
			hs1.setAttribute("arraylist", al1);
			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
		}
	}
}
