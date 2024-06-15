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
@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);			
		}
		else {
			String eid=req.getParameter("eid");
			int bsal=Integer.parseInt(req.getParameter("bsal"));
			float hra=Float.parseFloat(req.getParameter("hra"));
			float da=Float.parseFloat(req.getParameter("da"));
			hra=(float)(hra*bsal)/100;
			da=(float)(da*bsal)/100;
			float totsal=(float)bsal+hra+da;			
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>) hs.getAttribute("alist");
			Iterator<EmployeeBean> i=al.iterator();
			while(i.hasNext())
			{
				EmployeeBean eb1=(EmployeeBean)i.next();
				if(eid.equals(eb1.geteId()))
				{
					eb1.setbSal(bsal);
					eb1.setHra(hra);
					eb1.setDa(da);
					eb1.setTotSal(totsal);
					int k=new UpdateDAO().update(eb1);
					if(k>0)
					{
						req.setAttribute("up", "Employee Details Updated Successfully......<br>");
					}
					break;
				}
			}
			req.getRequestDispatcher("Update.jsp").forward(req, res);
		}		
	}
}
