package app.addemp;

import java.io.IOException;

import app.EmployeeBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class EmployeeAddServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired.....");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			EmployeeBean eb=new EmployeeBean();
			eb.seteId(req.getParameter("eid"));
			eb.seteName(req.getParameter("ename"));
			eb.seteDesg(req.getParameter("edesg"));
			int sal=Integer.parseInt(req.getParameter("bsal"));
			float hra=Float.parseFloat(req.getParameter("hra"));
			float da=Float.parseFloat(req.getParameter("da"));
			hra=(float)(hra*sal)/100;
			da=(float)(da*sal)/100;
			eb.setbSal(sal);
			eb.setHra(hra);
			eb.setDa(da);
			float totSal=(float)sal+hra+da;
			eb.setTotSal(totSal);
			
			int k=new EmployeeAddDAO().insret(eb);
			if(k>0)
			{
				req.setAttribute("msg", "Employee Added Successfully......<br>");
				req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
			}
		}
	}
//	public static void main(String[] args) {
//		int s=166;
//		float h=50;
//		float d=47;
//		h=(h*s)/100;
//		d=(d*s)/100;
//		System.out.println(h);
//		System.out.println(d);
//	}
}
