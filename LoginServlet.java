package user.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.UserBean;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		ArrayList<UserBean> al=new LoginDAO().retrive();
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		if(al.size()==0)
		{
			req.setAttribute("msg", "Details Not Avilable");
			rd.forward(req, res);
		}
		else {
			Iterator<UserBean> i=al.iterator();
			int x=0;
			while(i.hasNext())
			{
				UserBean ub=(UserBean)i.next();
				if(uname.equals(ub.getuName()) && pword.equals(ub.getpWord()))
				{
					req.setAttribute("msg","Login Successfull");
					x++;
					rd.forward(req, res);
				}
			}
			if(x==0)
			{
				req.setAttribute("msg", "Invalid Username and Password");
				rd.forward(req, res);
			}
		}
	}
}

/*
 
 public static void main(String[] args) {
	String uname="Subbu";
	String pword="Subbu@123";
	ArrayList<UserBean> al=new LoginDAO().retrive();
	System.out.println(al);
	if(al.size()==0)
	{
		System.out.println("Details Not Avilable");

	}
	else {
		Iterator<UserBean> i=al.iterator();
		int x=0;
		while(i.hasNext())
		{
			UserBean ub=(UserBean)i.next();
			System.out.println(ub.getuName());
			System.out.println(ub.getpWord());
			if(uname.equals(ub.getuName()) && pword.equals(ub.getpWord()))
			{
				System.out.println("Login Successfull");
				x++;
			}
		}
		if(x==0)
		{
			System.out.println("Invalid Username and Password");
		}
	}
}
 
 */


