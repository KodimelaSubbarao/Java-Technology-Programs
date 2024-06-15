package product.admin.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import product.admin.AdminBean;
import product.admin.java.AdminLogDAO;

@SuppressWarnings("serial")
@WebServlet("/alogin")
public class AdminLogServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException
	{
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		AdminBean ab=new AdminLogDAO().verify(uname, pword); 
		if(ab==null)
		{
			req.setAttribute("msg", "Invalid Login details....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLogJSP.jsp").forward(req, res);
		}
	}
}
