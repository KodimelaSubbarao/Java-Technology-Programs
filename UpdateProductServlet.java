package product.admin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import product.admin.ProductBean;
import product.admin.java.UpdateProductDAO;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException , IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String code=req.getParameter("code");
			String name=req.getParameter("name");
			float price=Float.parseFloat(req.getParameter("price"));
			int qty=Integer.parseInt(req.getParameter("qty"));
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("alist");
			for(ProductBean pb:al)
			{
				if(code.equals(pb.getpCode()))
				{
					pb.setpName(name);
					pb.setpPrice(price);
					pb.setpQty(qty);
					int k=new UpdateProductDAO().update(pb);
					if(k>0)
					{
						req.setAttribute("msg", "Product Record Updated Successsfull....<br> ");
					}
					/*
					 * else { req.setAttribute("msg",
					 * "Record Not Updated...Check Your Code Once ....<br>");
					 * req.getRequestDispatcher("Msg.jsp").forward(req, res); }
					 */
					break;
				}
			}
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
		
	}
}
