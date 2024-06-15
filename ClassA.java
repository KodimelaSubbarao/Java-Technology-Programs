package app;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/s1")
public class ClassA extends GenericServlet
{
	@Override
	public void init() throws ServletException
	{
		//nocode
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)
			throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("uname");
		String mailid=req.getParameter("mail");
		pw.println("****Details*****");
		pw.println("<br>UserName: "+name);
		pw.println("<br>Mail ID: "+mailid);
	}
	@Override
	public void destroy() {
		
	}
}
