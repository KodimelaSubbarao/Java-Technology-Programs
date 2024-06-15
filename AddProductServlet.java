package app;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		ProductBean pb=new ProductBean();
		pb.setCode(req.getParameter("code"));
		pb.setName(req.getParameter("name"));
		pb.setPrice(Float.parseFloat(req.getParameter("price")));
		String s=req.getParameter("qty");
		if(s=="")
		{
			pb.setQty(Integer.parseInt("0"));
		}
		else {
			pb.setQty(Integer.parseInt(s));
		}
		
		AddProductDAO apd=new AddProductDAO();
		int k=apd.insert(pb);
		if(k>0)
		{
			req.setAttribute("msg", "Product Added Successfully");
			RequestDispatcher rd=req.getRequestDispatcher("AddProduct.jsp");
			rd.forward(req, res);
		}
	}
}
