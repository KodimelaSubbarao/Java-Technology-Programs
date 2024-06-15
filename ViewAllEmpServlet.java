package emp.retrieve;

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
@WebServlet("/view")
public class ViewAllEmpServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		ViewAllEmpDAO vad=new ViewAllEmpDAO();
		ArrayList<EmployeeBean> al=vad.retrive();
		req.setAttribute("arraylist", al);
		RequestDispatcher rd=req.getRequestDispatcher("ViewAllEmp.jsp");
		rd.forward(req, res);
	}

}
