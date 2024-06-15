package product.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.user.java.UserPasswordDAO;

@SuppressWarnings("serial")
@WebServlet("/password")
public class UserPasswordServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		
		int k=new UserPasswordDAO().password(uname, pword);
		if(k>0)
		{
			req.setAttribute("msg", "Password Changed Successfully.....<br>");
			req.getRequestDispatcher("PasswordUpdated.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Password Not Changed, Try Again .....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
