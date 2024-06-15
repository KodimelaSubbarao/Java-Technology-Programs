package product.user.servlet;

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

@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs1=req.getSession(false);
		if(hs1==null)
		{
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String code=(String)req.getParameter("code");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs1.getAttribute("arraylist");
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=(ProductBean)i.next();
				if(code.equals(pb.getpCode()))
				{
					req.setAttribute("pbean", pb);
					break;
				}
			}
			req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
		}
	}
}
