package app.emp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/eview")
public class ViewEmployee extends HttpServlet 
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			req.getRequestDispatcher("ViewEmployee.jsp").forward(req, res);
			
		}
	}	
}
