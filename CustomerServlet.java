package app;
import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.PrintWriter;
@SuppressWarnings("serial")
@WebServlet("/CostomerD")
public class CustomerServlet extends GenericServlet
{
	public void init() throws ServletException
	{
		//nocode
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String id=req.getParameter("cid");
		String cn=req.getParameter("cname");
		String cp=req.getParameter("cpno");
		String cm=req.getParameter("cmail");
		String city=req.getParameter("ccity");
		String cpin=req.getParameter("ccode");
		pw.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h3>------------Customer Details--------------</h3>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>Customer ID :</b> "+id);
		pw.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b> Customer Name : </b>"+cn);
		pw.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b> Customer Phone Number : </b>"+cp);
		pw.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <b>Customer Mail ID :</b> "+cm);
		pw.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b> Customer City : </b>"+city);
		pw.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b> Customer Pin Code : </b>"+cpin);
	}
	public void destroy()
	{
		//nocode
	}
}
