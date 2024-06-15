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
@WebServlet("/view")
public class ViewAllProductsServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException ,ServletException
	{
		ViewAllProductsDAO vpd=new ViewAllProductsDAO();
		ArrayList<ProductBean> al=vpd.retrieve();
		req.setAttribute("alist", al);
		RequestDispatcher rd=req.getRequestDispatcher("ViewAllProducts.jsp");
		rd.forward(req, res);
	}
}































//statement
/*
try {
			Connection con=DBConnection.getCon();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from product");
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			while(rs.next())
			{
				pw.print(rs.getString(1));
				pw.print(rs.getString(2));
				pw.print(rs.getFloat(3));
				pw.print(rs.getInt(4));
				pw.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
*/