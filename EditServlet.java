package app.edit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import app.EmployeeBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String eid=req.getParameter("eid");
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>) hs.getAttribute("alist");
			Iterator<EmployeeBean> i=al.iterator();
			while(i.hasNext())
			{
				EmployeeBean eb=(EmployeeBean)i.next();
				if(eid.equals(eb.geteId()))
				{
					req.setAttribute("ebean", eb);
					break;
				}
			}
			req.getRequestDispatcher("EditEmployee.jsp").forward(req, res);
		}
	}
}
