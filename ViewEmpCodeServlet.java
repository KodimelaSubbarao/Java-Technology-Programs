package emp.empcode;

import java.io.IOException;
import java.util.ArrayList;

import emp.EmployeeBean;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/vcode")
public class ViewEmpCodeServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		EmployeeBean eb=new EmployeeBean();
		eb.setEid(Integer.parseInt(req.getParameter("ecode")));
		ArrayList<EmployeeBean> al= new ViewEmpCodeDAO().retrieveCode(eb);
		req.setAttribute("arraylist", al);
		RequestDispatcher rd=req.getRequestDispatcher("ViewEmpCode.jsp");
		rd.forward(req, res);
		
	}

}
