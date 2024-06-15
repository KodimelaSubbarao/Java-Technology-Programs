package app.admin;

import java.io.IOException;

import app.AdminBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String un=req.getParameter("uname");
		String pw=req.getParameter("pword");
		AdminBean ab=new AdminLoginDAO().verify(un, pw);
		if(ab==null)
		{
			req.setAttribute("msg", "Invalid username and password");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLogn.jsp").forward(req, res);
		}
	}
}
