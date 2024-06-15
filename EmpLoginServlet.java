package app.emp;

import java.io.IOException;

import app.EmployeeBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/emplog")
public class EmpLoginServlet extends HttpServlet
{	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		String id=req.getParameter("eid");
		EmployeeBean eb=new EmpLoginDAO().verify(id);
		if(eb==null)
		{
			req.setAttribute("msg", "Invaild Employee ID");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs=req.getSession();
			hs.setAttribute("ebean", eb);
			req.setAttribute("msg", "Login Successfully.....<br>");
			req.getRequestDispatcher("LoginEmployee.jsp").forward(req, res);
		}
		
	}
}
