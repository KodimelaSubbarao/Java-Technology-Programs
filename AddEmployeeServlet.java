package emp.add;

import java.io.IOException;

import emp.EmployeeBean;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws ServletException , IOException
	{
		EmployeeBean eb=new EmployeeBean();
		eb.setEid(Integer.parseInt(req.getParameter("eid")));
		eb.setEname(req.getParameter("ename"));
		eb.setEjob(req.getParameter("ejob"));
		float esal1=Float.parseFloat(req.getParameter("esal"));
		float hra=esal1*93/100;
		float da=esal1*61/100;
		float totalSal=esal1+hra+da;
		eb.setEsal(esal1);
		eb.setEhra(hra);
		eb.setEda(da);
		eb.setEtotsal(totalSal);
		int k=AddEmployeeDAO.inesrt(eb);
		if(k>0)
		{
			req.setAttribute("msg", "Employee Details Added SuccessFully.............");
			RequestDispatcher rd=req.getRequestDispatcher("AddEmployee.jsp");
			rd.forward(req, res);
			
		}
	}
}
