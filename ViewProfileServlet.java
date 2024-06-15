package app;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			req.setAttribute("msg", "Sessino Expired.........");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else {
			String name=c[0].getValue();
			req.setAttribute("name", name);
			req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);
		}
	}
}
