package app;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/code")
public class ViewProductByCodeServlet extends GenericServlet
{
	static ProductBean pb=new ProductBean();
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		String code=req.getParameter("pcode");
		pb.setCode(code);
		ViewProductByCodeADAO vpd=new ViewProductByCodeADAO();
		ArrayList<ProductBean> al=vpd.retriveByCode();
		req.setAttribute("alist", al);
		RequestDispatcher rd=req.getRequestDispatcher("ViewProductByCode.jsp");
		rd.forward(req, res);
	}
}
