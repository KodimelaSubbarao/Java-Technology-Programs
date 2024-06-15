package product.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.user.UserBeans;
import product.user.java.AddUserDAO;

@SuppressWarnings("serial")
@WebServlet("/uadd")
public class AddUserServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		UserBeans ub=new UserBeans();
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setpHno(Long.parseLong(req.getParameter("phno")));
		ub.setmId(req.getParameter("mid"));
		ub.setAddr(req.getParameter("addr"));
		int k=new AddUserDAO().insert(ub);
		if(k>0)
		{
			req.setAttribute("msg", "Registration Successfull....<br>");
			req.getRequestDispatcher("AddUser.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Registration Faild , Try Agian.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
