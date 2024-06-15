package app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class Sample extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("uname");
		String p=req.getParameter("pword");
		pw.println("hello");
		pw.println("Mr."+name);
		pw.println("This is your password or not : "+p);
	}

}
