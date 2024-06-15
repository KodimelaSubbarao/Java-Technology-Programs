package app.emp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout1")
public class LogoutEmployess extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired.....<br>");
		}
		else
		{
			hs.removeAttribute("ebean");
			hs.invalidate();
			req.setAttribute("msg", "Logout Success Fully....<br>");
		}
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}
}
