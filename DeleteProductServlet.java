package product.admin.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import product.admin.ProductBean;
import product.admin.java.DeleteProductADAO;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) 
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String code=(String)req.getParameter("code");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>) hs.getAttribute("alist");
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=(ProductBean)i.next();
				if(code.equals(pb.getpCode()))
				{
					al.remove((Object)pb);
					int k=new DeleteProductADAO().delete(code);
					if(k>0)
					{
						req.setAttribute("msg", "Record Deleted Successfully........<br>");
						break;
					}
				}
			}
			req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
				
		}
		
	}
}
